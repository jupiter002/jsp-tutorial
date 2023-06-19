package com.jupiter002.controller.member;

import java.io.IOException;  


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.jupiter002.model.MemberDao;
import com.jupiter002.model.MemberDto;

@WebServlet("/member/info")
public class InfoFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InfoFormController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispathcer = request.getRequestDispatcher("/WEB-INF/member/info.jsp");
		dispathcer.forward(request, response);
		MemberDto memberDto = new MemberDto();
		MemberDao memberDao = new MemberDao();
		MemberDto getinfo = memberDao.infoMember(memberDto);
		
		HttpSession session = request.getSession();
			session.setAttribute("getinfoID", getinfo.getId());
			session.setAttribute("getinfo", getinfo);
		
		
		
		
	
	}
	

	

}
