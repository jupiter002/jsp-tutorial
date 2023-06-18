<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file = "../include/header.jsp"%>

<div class="container-sm mt-5">
<h1>${getinfoId}</h1>
  <table class="table">
    <tbody>
      <tr>
      <th scope="row">ID</th>
        <td>${ getinfoId }</td>
      </tr>
      <tr>
      <tr>
        <th scope="row">Name</th>
        <td>${ getinfo.name }</td>
      </tr>
      <tr>
      <th scope="row">email</th>
        <td>${ getinfo.email }</td>
      </tr>
      <tr>
        <th scope="row">주소</th>
        <td></td>
      </tr>
      <tr>
        <th scope="row">우편번호</th>
        <td></td>
      </tr>
    </tbody>
  </table>
  <div class="mt-5">
    <a href="modify.jsp" class="btn btn-info">회원 정보 수정</a>
    <a href="modify-password.jsp" class="btn btn-info">비밀번호 변경</a>
    <a href="delete.jsp" class="btn btn-danger">회원 탈퇴</a>
  </div>
</div>


<%@ include file = "../include/footer.jsp"%>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div class="container-sm mt-5">
  <table class="table">
    <tbody>
      <tr>
      <th scope="row">ID</th>
        <td>${ loggedMember.id }</td>
      </tr>
      <tr>
      <tr>
        <th scope="row">Name</th>
        <td>${ loggedMember.name }</td>
      </tr>
      <tr>
      <th scope="row">email</th>
        <td>${ loggedMember.emaill }</td>
      </tr>
      <tr>
        <th scope="row">주소</th>
        <td>${ loggedMember.address }</td>
      </tr>
      <tr>
        <th scope="row">우편번호</th>
        <td>${ loggedMember.zonecode }</td>
      </tr>
    </tbody>
  </table>
  <div class="mt-5">
    <a href="../member/modify" class="btn btn-info">회원 정보 수정</a>
    <a href="../member/passwordModify" class="btn btn-info">비밀번호 변경</a>
    <a href="delete.jsp" class="btn btn-danger">회원 탈퇴</a>
  </div>
</div>



<%@ include file="../include/footer.jsp"%>
