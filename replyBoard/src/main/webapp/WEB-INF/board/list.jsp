<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container-sm mt-5">
	<table class="table">
		<colgroup>
			<col style="width:50px">
			<col >
			<col style="width:150px">
			<col style="width:250px">
			<col style="width:50px">
		</colgroup>
		<thead>
			<tr>
				<th scope="col">No</th>
				<th scope="col">Title</th>
				<th scope="col">Name</th>
				<th scope="col">Date</th>
				<th scope="col">Hit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${boardList}" var = "boardDto" varStatus="status">
			<tr>
				<td>${pageDto.total - pageDto.pagePerList*(clickPage-1) - status.index}</td>
				<!-- query paramamter  get -->
				<c:choose>
					<c:when test="${boardDto.available eq 1 }">
						<td><a href="../board/view?id=${boardDto.id}" class="step step${boardDto.restep }">${boardDto.title }</a></td>
					</c:when>
					<c:otherwise>
					<td><a href="" class="step step${boardDto.restep }notAvailable">삭제된 글입니다</a></td>
					</c:otherwise>
				</c:choose>
				<td>${boardDto.name }</td>
				<td>${boardDto.regDate }</td>
				<td>${boardDto.hit }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<nav aria-label="Page navigation example "class="justify-content-center">
  <ul class="pagination">
  <li class="page-item">
      <a class="page-link" href="../board/list?clickPage=1" aria-label="Previous">
        <span aria-hidden="true">처음으로</span>
        </a>
  <c:if test="${pageDto.pageStart ne 1 }">		<!-- previous -->
    <li class="page-item">
      <a class="page-link" href="../board/list?clickPage=${pageDto.pageStart-pageDto.pageBlock }" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    
    <c:forEach begin="${pageDto.pageStart }" end="${pageDto.pageEnd}" step="1" var="page" varStatus="status">
    	<li class="page-item ${page == clickPage?'active':''}">
    	<a class="page-link" href="../board/list?clickPage=${page}">${page}</a></li>
    	<%-- <a class="page-link" href="../board/list?start=${(page-1)*pagePerList+1}&end=${pagePerList}&clickPage=${page}">${page}</a></li> --%>
    </c:forEach>
    
    <c:if test="${pageDto.pageEnd ne pageDto.pageTotal }">	<!-- next -->
    <li class="page-item">
    <c:choose>
    	<c:when test="${pageDto.pageEnd+pageDto.pageBlock le pageDto.pageTotal}">
    	  <a class="page-link" href="../board/list?clickPage=${pageDto.pageEnd+pageDto.pageBlock}" aria-label="Next">
        	<span aria-hidden="true">&raquo;</span>
      		</a>
      	</c:when>
      	<c:otherwise>
      <a class="page-link" href="../board/list?clickPage=${pageDto.pageTotal}" aria-label="Next">
        	<span aria-hidden="true">&raquo;</span>
      		</a>
      	</c:otherwise>
      </c:choose>
    </li>
    </c:if>
    <li class="page-item">
    <a class="page-link" href="../board/list?clickPage=${pageDto.pageTotal}" aria-label="마지막으로" >
        <span aria-hidden="true">마지막으로</span>
        </a>
    
  </ul>
</nav>
	<h1>${pageDto} </h1>
	<h1>tempClickPage${tempclickPage} </h1>
	<h1>clickPage${clickPage} </h1>

	<div class="mt-5">
		<a href="../board/write" class="btn btn-primary">WRITE</a>
		<!-- <a href="" class="btn btn-danger">DELETE</a> -->
	</div>
</div>
<%@ include file="../include/footer.jsp"%>
