<!--prettier-ignore-->
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "include/header.jsp" %>
<!--prettier-ignore-->
<%
    String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "jupiter002";						//db의 사용자 정보 //각 테이블과는 상관없음
	String pw = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String pLoggedUserId = (String)session.getAttribute("loggedUserId");
	String sql = "select id,name,email,address,lpad(zonecode,5,'0') as zonecode,detailAddress  from member where id = ?"+pLoggedUserId;		//
	
	Class.forName(driver);
	conn = DriverManager.getConnection(url, id, pw);	//db에 연결
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
  	pstmt.setString(1,pLoggedUserId);
	String address = null;
	String detailAddress = null;
	String zonecode = null;
	String name = null;
	String email = null;
	String extraAddress = null; 
	
	if(rs.next()){
		address = rs.getString("address");
		detailAddress = rs.getString("detailAddress");
		extraAddress = rs.getString("extraAddress");
		zonecode = rs.getString("zonecode");
		name = rs.getString("name");
		email = rs.getString("email");
		
	}

    %>

<form action="modify-process.jsp" method="post" class="join" name="joinForm">
  <div class="container-sm mt-5">
    <div class="row justify-content-center">
      <div class="col-6">
        <div class="input-group mb-3">
          <input
            type="text"
            name="userId"
            class="form-control form-control-lg userId"
            id="floatingInput"
            placeholder="아이디를 입력해주세요"
            readonly
            value="<%= pLoggedUserId %>"
          />
        </div>
        <div class="mb-3">
          <input type="password" name="userPw" class="form-control form-control-lg" id="floatingPassword" placeholder="Password" />
          <label for="floatingPassword">Password</label>
        </div>
        <div class="mb-3">
          <input
            type="text"
            name="userName"
            class="form-control form-control-lg"
            id="floatingName"
            placeholder="이름을 입력해주세요"
            value="<%= name %>"
          />
          <label for="floatingName">Name</label>
        </div>
        <div class="mb-3">
          <input
            type="text"
            name="userEmail"
            class="form-control form-control-lg"
            id="floatinEmail"
            placeholder="이메일을 입력해주세요"
            readonly
            value="<%= email %>"
          />
          <label for="floatingEmail">email</label>
        </div>
        <div class="form">
          <div class="input-group mb-3">
            <input type="text" class="form-control form-control-lg" name="zonecode" id="zonecode" placeholder="우편번호" readonly value= "<%= zonecode
            %>"" />
            <button class="btn btn-secondary" type="button" id="button-addon2" onclick="searchZonecode()">Button</button>
          </div>
        </div>
        <div class="mb-3">
          <input
            type="text"
            name="userAddress"
            class="form-control address"
            id="floatingAddress"
            placeholder="주소를 입력해주세요"
            readonly
            value="<%= address %>"
          />
          <label for="floatingAddress">Address</label>
        </div>
        <div class="row mb-3">
          <div class="col">
            <input type="text" class="form-control-lg detailAddress" placeholder="참고사항" name="detailAddress" value="<%= detailAddress %>" />
          </div>
          <div class="col">
            <input type="text" class="form-control-lg extraAddress" placeholder="상세주소" name="extraAddress" value="<%= extraAddress %>" />
          </div>
        </div>

        <div class="text-center"><button type="submit" id="btnSubmit" class="btn btn-outline-primary btn-lg">Join</button></div>
      </div>
    </div>
  </div>
</form>


<%@ include file ="include/footer.jsp" %>
