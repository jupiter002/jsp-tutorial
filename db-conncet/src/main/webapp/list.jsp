<%@page import="com.jupiter002.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String driver = "oracle.jdbc.OracleDriver";					// db연결
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "jupiter002";
String pw = "1234";


Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String sql = "select * from board";		//컬럼의 값들이 맞는지 확인 : where

Class.forName(driver); // forName으로 driver클래스 호출
conn = DriverManager.getConnection(url,id,pw);
pstmt = conn.prepareStatement(sql);
rs = pstmt.executeQuery();		// 결과 리턴
ArrayList<BoardDto> boardList = new ArrayList<>();
while(rs.next()){
	BoardDto boardDto = new BoardDto();
	boardDto.setId(rs.getInt(id));
	boardDto.setName(rs.getString("name"));
	boardDto.setTitle(rs.getString("title"));
	boardDto.setContents(rs.getString("contents"));
	boardDto.setDate(rs.getString("regdate"));
	boardDto.setHit(rs.getInt("hit"));
	boardList.add(boardDto);
}
%>

<%@ include file = "include/header.jsp" %>
<div class="container">
<ul>
	<li>
		<span>1</span>
		<span>제목</span>
		<span>김지훈</span>
		<span>2023/06/09</span>
		<span>0</span>
	</li>
</ul>
</div>
<%@ include file = "include/footer.jsp" %>

