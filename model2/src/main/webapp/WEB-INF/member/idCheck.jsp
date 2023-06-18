<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%
int result =(int)request.getAttribute("count");
boolean isState = true;
if(result > 0){
	isState = false;
}
%> --%>
<%-- {"isOK":<%= isState %>} --%>

<c:out value = "${isState}"></c:out>
<c:choose>
	<c:when test="${count gt 0}"> 
		<c:set var ="isState" value="false"/>
	</c:when>
	<c:otherwise>
		<c:set var ="isState" value="true"/>
	</c:otherwise>
</c:choose>
{"isOk":<c:out value="${isState}"></c:out>}