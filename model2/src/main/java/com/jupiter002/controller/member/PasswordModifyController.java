package com.jupiter002.controller.member;

import java.io.IOException; 

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/passwordModify")
public class PasswordModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PasswordModifyController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/modify-password.jsp");
		dispatcher.forward(request, response);
	}
}
