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
import com.jupiter002.utils.ScriptWriter;

@WebServlet("/member/loginProcess")
public class LoginProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
//		String userId = request.getParameter("userId");
//		String userPw = request.getParameter("userPw");
//		memberDto.setId(userId);
//		memberDto.setPassword(userPw);
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		MemberDto loggedMember = memberDao.loginMember(memberDto);
		
		
		HttpSession session = request.getSession();
		if(loggedMember!=null) {
			session.setAttribute("loggedMemberId",loggedMember.getId());
			session.setAttribute("loggedMemberName",loggedMember.getName());
			session.setAttribute("loggedMember", loggedMember);
			ScriptWriter.alertAndNext(response,loggedMember.getName()+"님 안녕하세요", "../index/index");
		}else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생했습니다. 잠시 후 다시 시도해 주세요");
		}
		System.out.println(loggedMember.toString());
		//System.out.println(loggedMember.toString());
	
	}

}
