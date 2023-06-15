<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ include file="../include/header.jsp" %>

<div class="container-sm mt-5">

	<table class="table">
	<colgroup>
		<col style="width:50px">
		<col >
		<col style="width:150px">
		<col style="width:250px">
		<col style="width:50px">
	</colgroup>
  <tbody>
    <tr>
		<th>Title</th>
		<td>${boardDto.title }</td>
    </tr>
    <tr>
		<th>Writer</th>
		<td>${boardDto.name }</td>
    </tr>
    <tr>
		<th>Date</th>
		<td>${boardDto.regdate }</td>
    </tr>
    <tr>
		<th>Contents</th>
		<td>${boardDto.contents }</td>
    </tr>
  </tbody>
</table>
<div class="mt-5 text-center">
	<a href="../board/wirte" class="btn btn-primary">WRITE</a>
	<a href="" class="btn btn-primary">MODIFY</a>
	<a href="../board/delete?id=${ boardDto.id }" id=btnDelete class="btn btn-danger">DELETE</a>
	<a href="../board/list" class="btn btn-danger">LIST</a>
</div>
<script>
	const btnDelete = document.querySelector("#btnDelete");
		btnDelete.addEventListenr("click",(e)=>{
			e.preventDefault();
			const isDelete = confirm("게시글을 삭제하시겠습니까?")
			if(isDelete){
				location.href="../board/delete?id="${boardDto.id};
			}
	
})
</script>

</div>

<%@ include file="../include/footer.jsp" %>