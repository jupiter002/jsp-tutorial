package com.jupiter002.controller.member;

import java.io.IOException; 

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import com.jupiter002.model.MemberDao;
import com.jupiter002.model.MemberDto;

@WebServlet("/member/idCheck")
public class IdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IdCheckController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		
		String userId = request.getParameter("userId");
		int result = memberDao.idCheck(userId);
		request.setAttribute("count", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/idCheck.jsp");
		dispatcher.forward(request, response);
		
	
	}

}
