<!--prettier-ignore-->
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@includefile="include/header.jsp"%>
<!-- <p><%= session.getAttribute("loggedUserName") %></p> -->
<!--prettier-ignore-->
<% 
//db접속

	String pLoggedUserId = (String)session.getAttribute("loggedUserId");		//getAttibute로 받아온 값은 으로 형변환 할것

	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "jupiter002";						//db의 사용자 정보 //각 테이블과는 상관없음
	String pw = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "select id,name,email,address,lpad(zonecode,5,'0') as zonecode,detailAddress  from member where id = ?";	
// lpad (왼쪽부터 5자리를 채우는데 자리가 남으면 0으로 채워라)
// as: 컬렴명에 대한 별명을 지정 
	Class.forName(driver);
	conn = DriverManager.getConnection(url,id,pw);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,pLoggedUserId);
	//pstmt.executeQuery();
	rs = pstmt.executeQuery();
	
	String address = null;
	String detailAddress = null;
	String zonecode = null;
	String name = null;
	String email = null;
	String allAddress = null; 
	
	if(rs.next()){
		address = rs.getString("address");
		detailAddress = rs.getString("detailAddress");
		zonecode = rs.getString("zonecode");
		name = rs.getString("name");
		email = rs.getString("email");
		allAddress= address+ " / "+detailAddress;
	}

%>

<div class="container-sm mt-5">
  <table class="table">
    <tbody>
      <tr>
      <th scope="row">ID</th>
        <td><%=pLoggedUserId%></td>
      </tr>
      <tr>
      <tr>
        <th scope="row">Name</th>
        <td><%=name%></td>
      </tr>
      <tr>
      <th scope="row">email</th>
        <td><%=email%></td>
      </tr>
      <tr>
        <th scope="row">주소</th>
        <td><%=allAddress %></td>
      </tr>
      <tr>
        <th scope="row">우편번호</th>
        <td><%=zonecode %></td>
      </tr>
    </tbody>
  </table>
  <div class="mt-5">
    <a href="modify.jsp" class="btn btn-info">회원 정보 수정</a>
    <a href="modify-password.jsp" class="btn btn-info">비밀번호 변경</a>
    <a href="delete.jsp" class="btn btn-danger">회원 탈퇴</a>
  </div>
</div>
<%@include file="include/footer.jsp"%>
