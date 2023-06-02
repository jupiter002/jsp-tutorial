	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String dans[] = request.getParameterValues("dan");
    
    for(String item:dans){
    	out.println(item);
    }
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
for(String j:dans) {
	int num = Integer.parseInt(j);
out.println("<h1>"+j+"단을 출력합니다.</h1>");
	for(int i=1; i<10; i++) {
		out.println("<p>"+j+"X"+i+"="+num*i+"</p>");
}
}
%>
</body>
</html>