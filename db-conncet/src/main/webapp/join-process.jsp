<!--prettier-ignore-->
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--prettier-ignore-->
<%
	String pUserId = request.getParameter("userId");
	int pUserPw = Integer.parseInt(request.getParameter("userPw"));
	String pUserName = request.getParameter("userName");
	String pUserEmail = reqeust.getParameter("userEmail");
	int pZonecode = Integer.parseInt(request.getParameter("zonecode"));
	String pUserAddress = request.getParameter("userAddress");
	String pDetailAddress = request.getParameter("detailAddress");
	String pExtraAddress = request.getParameter("extraAddress");
	
	
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "jupiter002";						//db의 사용자 정보 //각 테이블과는 상관없음
	String pw = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "insert into member values (?,?,?,?,?,?,?,?,?)";		//
	
	Class.forName(driver);
	conn = DriverManager.getConnection(url, id, pw);	//db에 연결
	pstmt = conn.prepareStatement(sql);
	
	pstmt.setString(1,pUserId);
	pstmt.setString(2,pUserName);
	pstmt.setInt(3,pUserPw);
	pstmt.setInt(4,pUserPw);
	pstmt.setString(5,pUserEmail);
	pstmt.setInt(6,pZonecode);
	pstmt.setString(7,pUserAddress);
	pstmt.setString(8,pDetailAddress);
	pstmt.setString(9,pExtraAddress);

	int result = pstmt.executeUpdate();		// select를 제외한 나머지 update, delete, insert
	if(result>0){
		response.sendRedirect("login-form.jsp");
	}else{

<script>
  alert("서버오류입니다. 잠시후에 다시 시도해 주세요");
  history.back();
</script>
"); //history.back() 한단계 뒤로 } %>
