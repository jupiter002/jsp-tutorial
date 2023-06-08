<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<script>
  const userId = document.querySelector(".userId");
  const btnIdCheck = document.querySelector("#btnIdCheck");
  const btnSubmit = document.querySelector("#btnSubmit");
  const regEmail = "^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$";

  const joinForm = document.forms.joinForm; //document아래 forms들 아래 joinForm
  let isDoubleCheck = false;
  btnSubmit.addEventListener("click", (e) => {
    if (userId.value === "") {
      e.preventDefault();
      alert("아이디를 입력하세요.");
      joinForm.elements.userId.value = "";
      joinForm.elements.userId.focus();
      //return false;
    } else if (joinForm.elements.userPw.value.trim() == 0) {
      e.preventDefault();
      alert("비밀번호를 입력하세요.");
      joinForm.elements.userPw.value = "";
      joinForm.elements.userPw.focus();
    } else if (joinForm.elements.userPw.value !== joinForm.elements.userPw02.value) {
      e.preventDefault();
      alert("비밀번호가 맞지 않습니다");
      joinForm.elements.userPw02.value = "";
      joinForm.elements.userPw02.focus();
    } else if (joinForm.elements.userName.value.trim() === "") {
      e.preventDefault();
      alert("이름을 입력하세요.");
      joinForm.elements.userName.value = "";
      joinForm.elements.userName.focus();
    } else if (joinForm.elements.userEmail.value.trim() === "") {
      e.preventDefault();
      alert("이메일을 입력하세요.");
      joinForm.elements.userEmail.value = "";
      joinForm.elements.userEmail.focus();
    } else if (joinForm.elements.userEmail.value.trim().match(regEmail) === null) {
      e.preventDefault();
      alert("이메일을 형식에 맞게 입력하세요.");
    } else if (joinForm.elements.zonecode.value.trim() === "") {
      e.preventDefault();
      alert("우편번호 입력하세요.");
      joinForm.elements.zonecode.value = "";
      joinForm.elements.zonecode.focus();
    } else if (joinForm.elements.address.value.trim() === "") {
      e.preventDefault();
      alert("주소를 입력하세요.");
      joinForm.elements.us.value = "";
      joinForm.elements.userPw.focus();
    }
    if (isDoubleCheck === false) {
      //중복확인
      e.preventDefault();
      alert("아이디 중복체크 해주세요");
      joinForm.elements.userId.focus();
    }
  });
  btnIdCheck.addEventListener("click", () => {
    // console.log('idCheck.jsp?userId=${userId.value}')
    fetch("idCheck.jsp?userId=" + userId.value)
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        console.log(data);
        if (data.isOK) {
          alert("쓸 수 있는 아이디입니다.");
          isDoubleCheck = true;
        } else {
          alert("쓸 수 없는 아이디입니다.");
          userId.value = "";
          userId.focus();
        }
      });
  });

  function searchZonecode() {
    new daum.Postcode({
      oncomplete: function (data) {
        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

        // 각 주소의 노출 규칙에 따라 주소를 조합한다.
        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
        let addr = ""; // 주소 변수
        let extraAddr = ""; // 참고항목 변수

        //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
        if (data.userSelectedType === "R") {
          // 사용자가 도로명 주소를 선택했을 경우
          addr = data.roadAddress;
        } else {
          // 사용자가 지번 주소를 선택했을 경우(J)
          addr = data.jibunAddress;
        }

        // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
        if (data.userSelectedType === "R") {
          // 법정동명이 있을 경우 추가한다. (법정리는 제외)
          // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
          if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
            extraAddr += data.bname;
          }
          // 건물명이 있고, 공동주택일 경우 추가한다.
          if (data.buildingName !== "" && data.apartment === "Y") {
            extraAddr += extraAddr !== "" ? ", " + data.buildingName : data.buildingName;
          }
          // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
          if (extraAddr !== "") {
            extraAddr = " (" + extraAddr + ")";
          }
          // 조합된 참고항목을 해당 필드에 넣는다.
          document.querySelector(".extraAddress").value = extraAddr;
        } else {
          document.querySelector(".extraAddress").value = "";
        }

        // 우편번호와 주소 정보를 해당 필드에 넣는다.
        document.querySelector("#zonecode").value = data.zonecode;
        document.querySelector(".address").value = addr;
        // 커서를 상세주소 필드로 이동한다.
        document.querySelector(".detailAddress").focus();
      },
    }).open();
  }

  // const testEmail = "jang22@nanmail.net";
  // console.log(testEmail.match(regEmail));
</script>
<%@ include file ="include/footer.jsp" %>