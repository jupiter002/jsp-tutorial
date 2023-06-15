<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>
<form action="/member/DeleteProcess" method="post">
    <div class="container-sm mt-5">
      <div class="row mt-5 justify-content-center ">
        <div class="col-6">
          <div class="mb-3">
            <input type="text" name="userId" class="form-control form-control-lg" id="floatingInput" 
            placeholder="아이디를 입력해주세요" value="${ loggedmemeber.id } }" />	
            <!-- login-process의 String pUserId의 getParagmeter랑 이름을 맞출것 -->
          </div>
          <div class="form-floating mb-3">
            <input type="password" name="userPw" class="form-control form-control-lg" id="floatingPassword" placeholder="Password" />
            <label for="floatingPassword">Password</label>
          </div>
        </div>
      </div>
      <button type="submit" class="btn btn-primary">회원탈퇴</button>
<%@ include file = "../include/footer.jsp" %>