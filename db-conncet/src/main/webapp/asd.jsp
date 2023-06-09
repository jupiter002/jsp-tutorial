<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "include/header.jsp" %>
<form action="write-process.jsp" method="post" class="join" name="joinForm">
  <div class="container-sm mt-5">
    <div class="row justify-content-center">
      <div class="col-6">
      <div class="mb-3">
     	 <label for="floatingName">Name</label>
          <input type="text" name="userName" class="form-control form-control-lg" id="floatingName" placeholder="이름을 입력해주세요" />
        </div>
        <div class="mb-3">
       	  <label for="floatingPassword">title</label>
          <input type="text" name="title" class="form-control form-control-lg" id="floatingPassword" placeholder="제목을 입력해주세요" />
          
        </div>
        <div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Contents</label>
  <textarea class="form-control" id="exampleFormControlTextarea1" rows="10" name="contents"></textarea>
</div>
        <div class="text-center"><button type="submit" id="btnSubmit" class="btn btn-secondary btn-lg">Confirm</button></div>
      </div>
    </div>
  </div>
</form>
<%@ include file = "include/footer.jsp" %>