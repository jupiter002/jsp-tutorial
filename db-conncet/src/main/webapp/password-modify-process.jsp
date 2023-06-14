<%@page import="com.jupiter002.utils.ScriptWriter"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setCharacterEncoding("utf-8");
    String pLoggedUserId = (String)session.getAttribute("loggedUserId");
	int pUserPw = Integer.parseInt(request.getParameter("userPw"));
   	int pNewUserPw = Integer.parseInt(request.getParameter("newUserPw"));
    
    String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "jupiter002";						//db의 사용자 정보 //각 테이블과는 상관없음
	String pw = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "update member set password = ? where id = ? and password = ?";

	
	Class.forName(driver);
	conn = DriverManager.getConnection(url,id,pw);
	pstmt=conn.prepareStatement(sql);
	pstmt.setInt(1,pNewUserPw);
	pstmt.setString(2,pLoggedUserId);
	pstmt.setInt(3,pUserPw);
	int result = pstmt.executeUpdate();
	if(result>0){
		session.invalidate();
		//ScriptWriter.alertAndNext(response,"비밀번호가 변경되었습니다.다시 로그인 해주세요.","login-form.jsp");
		out.println("<script>alert('비밀번호가 변경되었습니다.다시 로그인 해주세요'); location.href='login-form.jsp'; </script>");		/* sendRedirect하면 경고창으 띄우지 않고 바로 창을 이동함 */
	}else{
		//ScriptWriter.alertAndBack(response, "비밀번호가 맞지 않습니다.");
		out.println("<script>alert('비밀번호가 맞지 않습니다.'); history.back();' </script>");
	}
    %>
  <%--   <%
	String pUserId = request.getParameter("userId");
	int pUserPw = Integer.parseInt(request.getParameter("userPw"));
	String pUserName = request.getParameter("userName");
	String pUserEmail = request.getParameter("userEmail");
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
	
	String sql = "update member set name = ?"
			+", email = ?, zonecode = ?, address = ?, detailAddress = ?, extraAddress"
			+"where id = ? and password = ?";
	
	Class.forName(driver);
	conn = DriverManager.getConnection(url,id,pw);
	pstmt.setString(1, pUserName);
	pstmt.setString(2, pUserEmail);
	pstmt.setInt(3, pZonecode);
	pstmt.setString(4, pUserAddress);
	pstmt.setString(5, pDetailAddress);
	pstmt.setString(6, pExtraAddress);
	pstmt.setString(7, pUserId);
	pstmt.setInt(8, pUserPw);
	
	int result = pstmt.executeUpdate();
	if(result > 0){
		session.invalidate();
		response.sendRedirect("login-form.jsp");
	}else{
		out.println("<script>alert('서버오류입니다. 잠시뒤에 다시 시도해 주세요');history.back();</script>");
	}
	
			

    
    %>
 --%>