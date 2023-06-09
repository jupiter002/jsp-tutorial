package com.jupiter002.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InfoFormController")
public class InfoFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InfoFormController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
	
	
	
	}
	

}
