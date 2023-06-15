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

@WebServlet("/member/modify")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyController() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		MemberDao memberDao = new MemberDao();
		MemberDto infoMemberDto;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/modify.jsp");	
		dispatcher.forward(request, response);
	}

}
