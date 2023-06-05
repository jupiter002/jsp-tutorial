<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String pUserId = request.getParameter("userId");
	String pUserPw = request.getParameter("userPw");
	String pUserName = request.getParameter("userName");
	String pAddress = request.getParameter("Address");
	String pZipcode = request.getParameter("zipcode");
	String pGender = request.getParameter("gender");
	
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "jupiter002";						//db의 사용자 정보 //각 테이블과는 상관없음
	String pw = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "insert into member values (?,?,?,?,?,?)";		//
	
	Class.forName(driver);
	conn = DriverManager.getConnection(url, id, pw);	//db에 연결
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,pUserId);
	pstmt.setString(2,pUserName);
	pstmt.setString(3,pUserPw);
	pstmt.setString(4,pAddress);
	pstmt.setString(5,pZipcode);
	pstmt.setString(6,pGender);
	int result = pstmt.executeUpdate();		//
	if(result>0){
		response.sendRedirect("login-form.jsp");
	}else{
		out.println("<script>alert('서버오류입니다. 잠시후에 다시 시도해 주세요'); history.back();</script>");	//history.back() 한단계 뒤로
	}
			
%>