<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String pUserId = request.getParameter("userId");
	String pUserPw = request.getParameter("userPw");
	
	String driver = "oracle.jdbc.OracleDriver";					// db연결
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "jupiter002";
	String pw = "1234";
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "select * from member where id = ? and password = ?";		//컬럼의 값들이 맞는지 확인 : where
	
	Class.forName(driver); // forName으로 driver클래스 호출
	conn = DriverManager.getConnection(url,id,pw);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, pUserId);
	pstmt.setString(2, pUserPw);
	rs = pstmt.executeQuery();		// 결과 리턴
	//response.setContentType("text/html;charset=utf-8");
	//pageContext <request<session<application	
	
	if(rs.next()){		//next()다음 순서에 값이 있으면 true를 반환
		String userId = rs.getString("id");
		String userPw = rs.getString("password");
		String userName = rs.getString("name");
		out.println("로그인 성공");
		//request.getRequestDispatcher(path)
		//response.sendRedirect("login-ok.jsp?userId="+userId);		
		//response는 페이지 자체를 바뀌어버림
		
		//직접 주소창을 바꾸는 명령어
		pageContext.setAttribute("pageUserId", userId);
		//request.setAttribute("userId", userId);		//서버 내부적으로 값을 보낸느 명령어
		session.setAttribute("loggedUserId", userId);
		session.setAttribute("loggedUserName", userName);
		//request.getRequestDispatcher("login-ok.jsp").	forward(request, response);
		RequestDispatcher dispatcher =  request.getRequestDispatcher("asd.jsp");			//
		dispatcher.forward(request, response);
		
	}else{
		out.println("로그인 실패");
	}
	
	
%>
