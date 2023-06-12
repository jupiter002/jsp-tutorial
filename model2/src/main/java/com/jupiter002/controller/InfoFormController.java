package com.jupiter002.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juipter002.utils.ScriptWriter;
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
		if(getinfo != null) {
			session.setAttribute("getinfoID",getinfo.getId());
			session.setAttribute("getinfoName",getinfo.getName());
			session.setAttribute("getinfo", getinfo);
		}
		
	
	}
	

}
