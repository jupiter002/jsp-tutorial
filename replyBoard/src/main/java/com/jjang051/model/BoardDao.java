package com.jjang051.model;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jjang051.mybatis.MybatisConnectionFactroy;

public class BoardDao {
	private String driver = "oracle.jdbc.OracleDriver"; 
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	private String id = "jupiter002"; 
	private String pw = "1234"; 
	
	private Connection conn = null; 
	private PreparedStatement pstmt = null;
	private ResultSet rs = null; 
	// MVC  design pattern  
	private void getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	private void ComorRoll() {
		SqlSession sqlSession = MybatisConnectionFactroy.getSqlSession();
		int result = 0;
		if(result>0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
	}
	
	
	private void close() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int getMaxregroup() {
		int result = 0;
		getConnection();
		String sql = "select nvl( max(regroup),0 ) as regroupMax from replyboard";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("regroupMax");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	
	public int writeBoard(BoardDto boardDto) {
		int result = 0;
		int max = getMaxregroup();
		boardDto.setRegroup(max+1);
		boardDto.setRelevel(1);
		boardDto.setRegroup(1);
		SqlSession sqlSession = MybatisConnectionFactroy.getSqlSession();
		sqlSession.insert("writeBoard",boardDto);
		if(result>0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		return result;
	}

	public int upadteRelevel(BoardDto boardDto) {
		int result=0;
		getConnection();
		String sql = "update replyboard set relevel = relevel+1 where regroup = ? and relevel > ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,boardDto.getRegroup());
			pstmt.setInt(2,boardDto.getRelevel());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

		}
	

	public List<BoardDto> getList(HashMap<String, Integer> pageMap) {
		List<BoardDto> boardList = null;
		SqlSession sqlSession = MybatisConnectionFactroy.getSqlSession();
		boardList = sqlSession.selectList("getList", pageMap);
		sqlSession.close();
		return boardList;
	}
	
	public double getTotal() {
		double total = 0;
		getConnection();
		String sql = "select count(*) as total from replyboard";
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return total;
	}

	
	public int updateHit(int id) {
		int result=0;
		SqlSession sqlSession = MybatisConnectionFactroy.getSqlSession();
		result = sqlSession.update("updateHit",id);
		ComorRoll();
		sqlSession.close();
		return result;
	
	}
	public BoardDto getView(int id) {
		BoardDao boardDao = null;
		boardDao.updateHit(id);
		BoardDto boardDto = null;
		SqlSession sqlSession = MybatisConnectionFactroy.getSqlSession();
		boardDto = sqlSession.selectOne("getView",id);
		sqlSession.close();
		return boardDto;
	}

	public int deleteBoard(int id) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactroy.getSqlSession();
		result = sqlSession.update("deleteBoard",id);
		ComorRoll();
		sqlSession.close();
		return result;
		
		
	}

	public int modifyBoard(BoardDto boardDto) {
		int result = 0;
		getConnection();
		String sql = "update replyboard set title = ?, name = ?, contents = ? where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getTitle());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getContents());
			pstmt.setInt(4, boardDto.getId());
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public int replyBoard(BoardDto boardDto) {
		int result = 0;
		getConnection();
		String sql = "insert into replyboard values (seq_replyboard.nextval,?,?,?,?,sysdate,0,?,?,?,1)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getUserId());
			pstmt.setString(2, boardDto.getName());
			pstmt.setString(3, boardDto.getTitle());
			pstmt.setString(4, boardDto.getContents());
			pstmt.setInt(5, boardDto.getRegroup());
			pstmt.setInt(6, boardDto.getRelevel());
			pstmt.setInt(7, boardDto.getRestep());
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	
	}

	public List<BoardDto> search(String category, String searchWord) {
		List<BoardDto> searchList = null;
		SqlSession sqlSession = MybatisConnectionFactroy.getSqlSession();
		HashMap<String,String> searchMap = new HashMap<>();
		searchMap.put("category", category);
		searchMap.put("searchWord", searchWord);
		
		
		searchList = sqlSession.selectList("search",searchMap);
		
		//컬럼명은 ?로 못씀
		//컬럼명은 data binding 안됨
		return searchList;
		
	}

		


}
			

