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
				String userEmail = rs.getString("email");
				String userAddress = rs.getString("address");
				int Zonecode = rs.getInt("zonecode");
				loggedmemberDto.setId(userId);
				loggedmemberDto.setName(userName);
				loggedmemberDto.setEmaill(userEmail);
				loggedmemberDto.setAddress(userAddress);
				loggedmemberDto.setZonecode(Zonecode);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return loggedmemberDto;
	}
	public MemberDto infoMember(MemberDto memberDto) {
		MemberDto infoMemberDto = null;
		getConnection();
		String sql = "select id,name,email,address,lpad(zonecode 5,'0') as zonecode detailaddress extraaddress from member where id = ?"; //쿼리문 작성
		try {
			pstmt = conn.prepareStatement(sql);			//쿼리문 날림
			pstmt.setString(1, memberDto.getId());		//
			rs = pstmt.executeQuery();
			if(rs.next()) {
				 infoMemberDto = new MemberDto();
				infoMemberDto.setId(rs.getString("id"));
				infoMemberDto.setName(rs.getString("name"));
				infoMemberDto.setEmaill(rs.getString("email"));
				infoMemberDto.setZonecode(rs.getInt("zonecode"));
				infoMemberDto.setAddress(rs.getString("address"));
				infoMemberDto.setDetailAddressl(rs.getString("detailaddress"));
				infoMemberDto.setExtraAddress(rs.getString("extraaddress"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	return infoMemberDto;
	}
	
	public int modifyMember(MemberDto memberDto) {
		int result = 0;
		getConnection();
		String sql = "update memeber set name = ?, email = ?, zonecode = ?, address = ?, detailaddress = ?, extraaddress = ?"
						+"where id = ? and password = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getName());		//쿼리문이랑 순서 맞춤
			pstmt.setString(2, memberDto.getEmaill());
			pstmt.setInt(3, memberDto.getZonecode());
			pstmt.setString(4, memberDto.getAddress());
			pstmt.setString(5, memberDto.getDetailAddressl());
			pstmt.setString(6, memberDto.getExtraAddress());
			pstmt.setString(7, memberDto.getId());
			pstmt.setString(8, memberDto.getPassword());
			result = pstmt.executeUpdate();			//executeUpdate는 int값 
				
			}
		 catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return result;
	}
	
	
	public int modifyPassword(PasswordDto passwordDto) {
		int result = 0;
		getConnection();
		String sql = "update member set password = ? where userId = ? password = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, passwordDto.getNewUserPw());
			pstmt.setString(2, passwordDto.getUserId());
			pstmt.setString(3, passwordDto.getUserPw());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	public int idCheck(String userId) {
		int result = 0;
		getConnection();
		String sql = "select count(*) as count from member where id = ?";			//쿼리문의 count 명령어는 컬럼의 개수를 값으로 반환함
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			rs = pstmt.executeQuery();												//count명령어는 excuteQuery명령어로 값을 가져옴
			if(rs.next()) {															//next()메소드는 다음 값이 있으면 true를 반환함
				result = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
		
	}	
	}
