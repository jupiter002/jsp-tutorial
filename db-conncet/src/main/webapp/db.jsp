<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pUserid = request.getParameter("userid");
	String pUserpw = request.getParameter("userpw");
	String driver = "oracle.jdbc.OracleDriver";					
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "jupiter002";
	String pw = "1234";													//기본옵션
	
	Connection conn = null;
	String sql = "select * from member where id = ? and password =?";
	PreparedStatement pstmt = null;		//oracle select
	ResultSet rs = null;
	
	Class.forName(driver);		//driver찾아서 
	conn = DriverManager.getConnection(url, id, pw);		//Drivemanager를 통해서 driver를 찾고 getConnection으로 
	pstmt=conn.prepareStatement(sql);				//sql날림
	pstmt.setString(1, pUserid);
	pstmt.setString(2, pUserpw);
	
	rs = pstmt.executeQuery();
	while(rs.next()){		//next()다음 값이 있으면 true를 반환
		String _userid = rs.getString("id");
		String _username = rs.getString("name");
		String _userpw = rs.getString("password");
		System.out.println(_userid+"=="+_username+"=="+_userpw);
	}
	
	/* System.out.println(conn); */
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