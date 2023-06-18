package com.jupiter002.controller.board;

import java.io.IOException;

import com.jupiter002.model.BoardDao;
import com.jupiter002.utils.ScriptWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDeleteController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));			//getParameter로 가져오는 값은 전부 String타입임
	BoardDao boardDao = new BoardDao();
	int result = boardDao.deleteDao(id);
	if(result>0) {
		ScriptWriter.alertAndNext(response, "삭제되었습니다", "../board/list");
	}else {
		ScriptWriter.alertAndBack(response, "비밀번호가 일치하지 않습니다. 비밀번호를 확인해주세요");
	}
	
	}

}
