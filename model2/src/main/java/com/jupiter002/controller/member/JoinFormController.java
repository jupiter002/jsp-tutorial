package com.jupiter002.controller.member;

import java.io.IOException;					

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")								//web-inf폴더안에 있는 객체는 내부에서만 접근가능(보안강화)
public class JoinFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinFormController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/join.jsp");
	dispatcher.forward(request, response);
	
	}

}
	