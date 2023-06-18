package com.jupiter002.model;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.jupiter002.model.BoardDto;

public class BoardDao {
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

	public int writeBoard(BoardDto boardDto) {
		int result = 0;
		getConnection();
		String sql = "insert into board values(seq_board.nextval,?,?,?,?,sysdate,0)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getUserId());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getTitle());
			pstmt.setString(4, boardDto.getContents());
			result = pstmt.executeUpdate();
			toString();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
		}


	public ArrayList<BoardDto> getList() {
		ArrayList<BoardDto> boardList = null;
		
		getConnection();
		
		String sql = "select * from board";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			boardList = new ArrayList<>();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setId(rs.getInt("id"));
				boardDto.setUserId(rs.getString("userId"));
				boardDto.setName(rs.getString("name"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContents(rs.getString("contents"));
				boardDto.setRegdate(rs.getString("regdate"));
				boardDto.setHit(rs.getInt("hit"));
				boardList.add(boardDto);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return boardList;
	}

	public void updateHit(int id) {
		getConnection();
		String sql = "update board set hit = hit + 1 where id = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
	}
	public BoardDto getview(int id2) {
		BoardDto boardDto = null;
		updateHit(id2);				// updateHIt()메소드의 finally의 close때문에 getconnection보다 위에 있지 않으면 아래 실행문들이 실행되지 않고 종료된다.
		getConnection();
		String sql = "select * from board where id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id2);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardDto = new BoardDto();
				boardDto.setId(rs.getInt("id"));
				boardDto.setUserId(rs.getString("userId"));
				boardDto.setName(rs.getString("name"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContents(rs.getString("contents"));
				boardDto.setRegdate(rs.getString("regdate"));
				boardDto.setHit(rs.getInt("hit"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return boardDto;
	}
	/*
	 * public int modifyBoard(BoardDto boardDto) { int result = 0; getConnection();
	 * String sql =
	 * "update board set title = ?, name = ? contents = ? where id = ?"; try { pstmt
	 * = conn.prepareStatement(sql); } catch (SQLException e) { e.printStackTrace();
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */


	public int deleteDao(int id2) {
		int result = 0;
		getConnection();
		
		String sql = "delete  from board where id = ?";		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id2);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		
		return result;
	}

	
	
}