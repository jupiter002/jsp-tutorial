<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

String pUserId = request.getParameter("userId");
String pUserPw = request.getParameter("userPw");

String driver = "oracle.jdbc.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "jupiter002";						//db의 사용자 정보 //각 테이블과는 상관없음
String pw = "1234";

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String dbUserId ="";
String dbUserPw ="";

String sql = "select id,password from member where id = ? and password = ?";		//db에 보낼 쿼리문
																					// select이후에 컬러명을 적어줄것

Class.forName(driver);
conn = DriverManager.getConnection(url,id,pw);
pstmt = conn.prepareStatement(sql);
pstmt.setString(1,pUserId);
pstmt.setString(2,pUserPw);
rs = pstmt.executeQuery();


 if(rs.next()){
	 dbUserId = rs.getString("id");
	 dbUserPw = rs.getString("password");
	if(dbUserId.equals(pUserId)  && dbUserPw.equals(pUserPw) ){
		pstmt = conn.prepareStatement("delete from member where id = ? and password = ?");
		pstmt.setString(1, pUserId);
		pstmt.setString(2, pUserPw);
		int result = pstmt.executeUpdate();
		if(result>0) {
			session.invalidate();
			response.sendRedirect("login-form.jsp");
		} 
	}
	else{
	out.println("<script>alert('정보가 일치하지 않습니다. 다시 시도해주세요'); history.back();</script>");
	}
 }
%>






