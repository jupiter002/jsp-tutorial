<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    /*html코드안이 아닌 밖에 쓸때는 느낌표를 하나 써준다  */
    String name = "아무개";
    String msg = "hello";
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello jsp</h1>
	<h2><%= name %></h2>
	<!--선언해놓은 변수로 출력할때는 =만 써도 됨  -->
	
	<!--tomcat은 기본포트가 8080  -->
	<%
		out.println("hello jsp <br>");
		out.println(name+" "+msg+"<br>");
		for(int i=0; i<100; i++){
			out.println("hello jsp <br/>");
		}
	%>	



		
</body>
</html>