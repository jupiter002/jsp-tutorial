<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>
<body>
  <form action="../member/loginProcess" method="post">
    <div class="container-sm mt-5">
      <div class="row mt-5 justify-content-center">
        <div class="col-6">
          <div class="form-floating mb-3">
            <input type="text" name="userId" class="form-control" id="floatingInput" placeholder="아이디를 입력해주세요" />
            <!-- login-process의 String pUserId의 getParagmete랑 이름을 ㄱ맞출것 -->
            <label for="floatingInput">ID</label>
          </div>
          <div class="form-floating">
            <input type="password" name="userPw" class="form-control" id="floatingPassword" placeholder="Password" />
            <label for="floatingPassword">Password</label>
          </div>
        </div>
        <div class="text-center mt-5"><button type="submit" class="btn btn-primary">로그인</button></div>
      </div>
    </div>
  </form>
<%@ include file = "../include/footer.jsp" %>
