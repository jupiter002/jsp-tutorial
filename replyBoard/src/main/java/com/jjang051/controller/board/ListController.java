package com.jjang051.controller.board;

import java.io.IOException;  
import java.util.ArrayList;



import com.jjang051.model.BoardDao;
import com.jjang051.model.BoardDto;
import com.jjang051.model.PageDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		int clickPage = 0;
		String tempClickPage = request.getParameter("clickPage");
		
		
		if(tempClickPage==null) {
			clickPage = 1;
		}else {
			clickPage = Integer.parseInt(tempClickPage);
		}
		
		double pagePerList = 10;						// 한번에 보여줄 게시글 수
		
		double total = boardDao.getTotal();				//전체 페이지 갯수
		int pageBlock = 3; 								// 아래쪽 pagination에 한번에 보여지는 갯수
		
		
		int pageTotal = (int)(Math.ceil(total / pagePerList));				//아래쪽 페이지 출력 갯수
		int pageStart = (int)((clickPage-1)/pageBlock)*pageBlock+1;			//clickPage가1~4까지일떄는 int가 소수점을 탈락시키기떄문에 pageBlock을 곱해도 0으로 계산되고 +1하면 결과로 1이 나온다
		int pageEnd = pageStart+pageBlock-1;	
		if(pageEnd==pageTotal)pageEnd = pageTotal;
		
		
//		int start =StrStart==null ? 1 : Integer.parseInt(StrStart);
//		int end =StrStart==null ? (int)pagePerList : Integer.parseInt(StrEnd);
		//clickPage = 1; ..1 == 1~10; 2== 10~20
		int start = (clickPage - 1)*(int)pagePerList+1;
		int end = start+(int)pagePerList-1;
		
		PageDto pageDto = new PageDto();
		pageDto.setPageTotal(pageTotal);
		pageDto.setTotal((int)total);
		pageDto.setPageBlock(pageBlock);
		pageDto.setPageStart(pageStart);
		pageDto.setPageEnd(pageEnd);
		pageDto.setPagePerList(pagePerList);
		
		
		ArrayList<BoardDto> boardList = boardDao.getList();
		request.setAttribute("boardList", boardList);
//		request.setAttribute("pageTotal", pageTotal);
//		request.setAttribute("total", (int)total);
//		request.setAttribute("pagePerList", (int)pagePerList);
//		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("clickPage", clickPage);
//		request.setAttribute("pageStart", pageStart);
//		request.setAttribute("pageEnd", pageEnd);
		request.setAttribute("pageDto",pageDto);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		dispatcher.forward(request, response);
	}
}
