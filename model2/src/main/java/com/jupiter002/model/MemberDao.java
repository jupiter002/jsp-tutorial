package com.jupiter002.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "jupiter002";						//db의 사용자 정보 //각 테이블과는 상관없음
	private String pw = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// MVC 디자인 패턴
	private void getConnection() {
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url,id,pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void close() {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public int insertMember(MemberDto memberDto) {
		int result = 0;
		getConnection();
		String sql = "insert into member values(?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);		//쿼리문을 날려주는 메소드
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getName());
			pstmt.setString(3, memberDto.getPassword());
			pstmt.setString(4, memberDto.getEmaill());
			pstmt.setInt(5, memberDto.getZonecode());
			pstmt.setString(6, memberDto.getAddress());
			pstmt.setString(7, memberDto.getDetailAddressl());
			pstmt.setString(8, memberDto.getExtraAddress());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				close();
		}
		return result;
	}
	
	public MemberDto loginMember(MemberDto memberDto) {
		MemberDto loggedmemberDto = null;
		getConnection();
		String sql = "select * from member where id = ? and password = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loggedmemberDto = new MemberDto();
				String userId = rs.getString("id");
				String userName = rs.getString("name");
				loggedmemberDto.setId(userId);
				loggedmemberDto.setName(userName);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return loggedmemberDto;
	}

}