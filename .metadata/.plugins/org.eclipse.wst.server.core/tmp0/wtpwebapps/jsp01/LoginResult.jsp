<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
    String userid = request.getParameter("userId");
    String userpw = request.getParameter("userPw");
    String isLogin;
    if(userid.equals("a") && userpw.equals("1234")){
    	isLogin = "succes";
    }else{
    	isLogin="fail";
    }
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><% out.println(isLogin); %></h1>
	<h1><%= isLogin %></h1>

	<%
	out.println("hello jsp");
	%>

</body>
</html>