<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<form action="../member/ModifyPasswordProcess" method="post" class="join" name="pwForm">
<input type="hidden" name="userId" value="${loggedMemberDto.id}"/>
  <div class="container-sm">
    <div class="row justify-content-center">
      <div class="col-6">
        <div class="mb-3">
          <label for="floatingPassword">기존 비밀번호</label>
          <input type="password" name="userPw" class="form-control" id="floatingPassword" placeholder="Password" />
        </div>
        <div class="mb-3">
          <label for="floatingPassword">새 비밀번호</label>
          <input type="password" name="newUserPw" class="form-control" id="floatingPassword" placeholder="Password" />
        </div>
        <div class="mb-3">
          <label for="floatingPassword">새 비밀번호 확인</label>
          <input type="password" name="newUserPw02" class="form-control" id="floatingPassword02" placeholder="Password" />
        </div>
        
        <div class="text-center">
          <button type="submit" class="btn btn-primary btn-lg" id="btnSubmit">비밀번호 변경</button>
        </div>
      </div>
    </div>
  </div>
</form>
<%@ include file="../include/footer.jsp" %>