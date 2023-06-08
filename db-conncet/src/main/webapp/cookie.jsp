<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Cookie cookie01 = new Cookie("myCookie01","초코칩");
	cookie01.setPath(request.getContextPath());	//맥락을 파악
	cookie01.setMaxAge(60);		//하루동안 쿠키를 저장하겠다
	response.addCookie(cookie01);
	System.out.println(request.getContextPath());
	
	Cookie cookie02 = new Cookie("myCookie02","칙촉");
	cookie02.setPath(request.getContextPath());	//맥락을 파악
	cookie02.setMaxAge(60);		//하루동안 쿠키를 저장하겠다
	response.addCookie(cookie02);
	System.out.println(request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>