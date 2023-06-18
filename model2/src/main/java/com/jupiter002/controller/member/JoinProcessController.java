package com.jupiter002.controller.member;

import java.io.IOException;  
 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jupiter002.model.MemberDao;
import com.jupiter002.model.MemberDto;
import com.jupiter002.utils.ScriptWriter;

@WebServlet("/member/joinProcess")
public class JoinProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//business logic
		request.setCharacterEncoding("utf-8");
		String UserId = request.getParameter("userId");
		String UserPw = request.getParameter("userPw");
		String UserName = request.getParameter("userName");
		String UserEmail = request.getParameter("userEmail");
		int Zonecode = Integer.parseInt(request.getParameter("zonecode"));
		String UserAddress = request.getParameter("userAddress");
		String DetailAddress = request.getParameter("detailAddress");
		String ExtraAddress = request.getParameter("extraAddress");
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setId(UserId);
		memberDto.setPassword(UserPw);
		memberDto.setName(UserName);
		memberDto.setZonecode(Zonecode);
		memberDto.setAddress(UserAddress);
		memberDto.setEmaill(UserEmail);
		memberDto.setDetailAddressl(DetailAddress);
		memberDto.setExtraAddress(ExtraAddress);
		int result = memberDao.insertMember(memberDto);
		System.out.println(result);
		
		if(result>0) {
			ScriptWriter.alertAndNext(response, "회원가입 되었습니다.", "../member/login");
		}else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생하였습니다. 다시 시도해 주세요");
		}
	}

}
