package com.jjang051.controller.member;

import java.io.File; 
import java.io.IOException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jjang051.model.MemberDao;
import com.jjang051.model.MemberDto;
import com.jjang051.utils.ScriptWriter;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/member/joinProcess")
public class JoinProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Loading...");
		
		
		request.setCharacterEncoding("utf-8"); 
		String encoding = "utf-8";
		int fileSize = 1024*1024*10;
		String savePath = "C:\\Users\\a\\OneDrive\\문서\\Upload";
		File currentDir = new File(savePath);
		
		DefaultFileRenamePolicy fileRenamePolicy = new DefaultFileRenamePolicy();
		
		MultipartRequest multipartRequest = new MultipartRequest(request, savePath, fileSize, encoding, fileRenamePolicy);
		
		
		String userId = multipartRequest.getParameter("userId"); 
		String userPw = multipartRequest.getParameter("userPw"); 
		String userName = multipartRequest.getParameter("userName"); 
		String userEmail = multipartRequest.getParameter("userEmail"); 
		int zonecode = Integer.parseInt(multipartRequest.getParameter("zonecode")); 
		System.out.println(zonecode);
		String userAddress = multipartRequest.getParameter("userAddress"); 
		String detailAddress = multipartRequest.getParameter("detailAddress"); 
		String extraAddress = multipartRequest.getParameter("extraAddress"); 
		
		String originalFile = multipartRequest.getOriginalFileName("profile");
		String renameFile = multipartRequest.getFilesystemName("profile");
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		memberDto.setName(userName);
		memberDto.setZonecode(zonecode);
		memberDto.setAddress(userAddress);
		memberDto.setExtraAddress(extraAddress);
		memberDto.setDetailAddress(detailAddress);
		memberDto.setEmail(userEmail);
		
		
		int result = memberDao.insertMember(memberDto);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "회원가입 되었습니다.", "../member/login");
		} else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생 되었습니다. 다시 시도해 주세요");
		}
	}



private String GetToday() {
	
	
	return new SimpleDateFormat("yyyy-mm-dd").format(System.currentTimeMillis());
}
}



