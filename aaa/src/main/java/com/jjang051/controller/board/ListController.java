package com.jjang051.controller.board;

import java.io.IOException;
import java.util.ArrayList;



import com.jjang051.model.BoardDao;
import com.jjang051.model.BoardDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/board/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// board 테이블의 row값을 가지고 오기....
		BoardDao boardDao = new BoardDao();
		String StrStart = request.getParameter("start");
		String StrEnd = request.getParameter("end");
		double pagePerList = 10;
		double total = boardDao.getTotal();
		int pageTotal = (int)(Math.ceil(total / pagePerList));
		
		int start =StrStart==null ? 1 : Integer.parseInt(StrStart);
		int end =StrStart==null ? (int)pagePerList : Integer.parseInt(StrEnd);
		
		
		ArrayList<BoardDto> boardList = boardDao.getList(start,end);
		request.setAttribute("boardList", boardList);
		request.setAttribute("pagePerList", pagePerList);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		dispatcher.forward(request, response);
	}
}












