package com.jupiter002.controller.member;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.jupiter002.model.MemberDto;
import com.jupiter002.utils.ScriptWriter;

@WebServlet("/member/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto loggedMember = (MemberDto)session.getAttribute("loggedMember");
		String loggedMemberName = loggedMember.getName();
		session.invalidate();
		ScriptWriter.alertAndNext(response, loggedMemberName+"님 로그아웃 되었습니다.", "../index/index");
	}
	
}
