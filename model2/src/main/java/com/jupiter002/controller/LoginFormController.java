package com.jupiter002.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/login")			//내부 폴더명이랑 상관없지만 사용자가 예상 가능한 주소명을 적어줘야댐
public class LoginFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginFormController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/login.jsp");
		dispatcher.forward(request, response);
		
		
	}
	

}
