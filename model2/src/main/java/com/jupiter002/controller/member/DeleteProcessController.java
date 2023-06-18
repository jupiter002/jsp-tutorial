package com.jupiter002.controller.member;

import java.io.IOException;

import com.jupiter002.model.MemberDao;
import com.jupiter002.model.MemberDto;
import com.jupiter002.utils.ScriptWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member/DeleteProcess")
public class DeleteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userId");
		
	MemberDao memberDao = new MemberDao();		//제어역전(DI)
	MemberDto memberDto = new MemberDto();
	memberDto.setId(userId);
	memberDto.setPassword(userPw);
	int result = memberDao.deleteMember(memberDto);
	if(result>0) {	
		HttpSession session = request.getSession();
		session.invalidate();
		ScriptWriter.alertAndNext(response, "회원탈퇴가 완료되었습니다.", "../index/index");
	}else {
		ScriptWriter.alertAndBack(response, "비밀번호를 확인해주세요");
		
	}
	
	
	
	}

}
