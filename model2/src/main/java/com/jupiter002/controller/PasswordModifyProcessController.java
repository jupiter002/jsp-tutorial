package com.jupiter002.controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juipter002.utils.ScriptWriter;
import com.jupiter002.model.MemberDao;
import com.jupiter002.model.PasswordDto;

@WebServlet("/member/ModifyPasswordProcess")
public class PasswordModifyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PasswordModifyProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPw = request.getParameter("userPw");
		String newUserPw = request.getParameter("newuserPw");
		String userId = request.getParameter("userId");
		PasswordDto passwordDto = new PasswordDto();
		passwordDto.setUserId(userId);
		passwordDto.setUserPw(userPw);
		passwordDto.setNewUserPw(newUserPw);
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.modifyPassword(passwordDto);
		if(result>0) {
			HttpSession session = request.getSession();
			session.invalidate();
			ScriptWriter.alertAndNext(response, "비밀번호 변경 되었습니다. 다시 로그인 해주세요", "../member/login");
		}else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생했습니다. 다시 시도헤주세요");
		}
		
		
	
	}

}

