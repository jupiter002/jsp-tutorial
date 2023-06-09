<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../include/header.jsp" %>
<div class="container-sm mt-5">

<form action="../board/writeProcess" method="post">
	<input type="hidden" name="userId" value="${ loggedMember.id }"/>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">제목</label>
  <input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력하세요">
</div>
<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">이름</label>
  <textarea class="form-control" id="userName" name="userName" placeholder="이름을 입력하세요"></textarea>
</div>
<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">내용</label>
  <textarea class="form-control" name="contents" id="contents" rows="10"></textarea>
</div>
<div class="text-center">
<button type="submit" id="btnSubmit" class="btn btn-outline-primary btn-lg">WRITE</button>		
<button type="reset" id="btnSubmit" class="btn btn-secondary btn-lg">CANCEL</button>
<a href="../board/list" class="btn btn-primary btn-lg">LIST</a>
</div>
</form>

</div>


<%@ include file="../include/footer.jsp" %>
