package com.jjang051.controller.member;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.jjang051.model.MemberDao;
import com.jjang051.model.MemberDto;
import com.jjang051.utils.ScriptWriter;
//import com.oreilly.servlet.MultipartRequest;
//import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/member/joinProcess")
public class JoinProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinProcessController() {
        super();
    }

	protected void service(Multipa request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("왜 안넘어오니...");
		
		
		request.setCharacterEncoding("utf-8"); 
		
		int fileSize = 1024*1024*10;
		String savePath = "C:\\Users\\y\\Documents\\Upload";
		File currentDir = new File(savePath);
		DiskFileItemFactory diskFileItemFac = new DiskFileItemFactory();
		diskFileItemFac.setRepository(currentDir);	// 경로 설정
		diskFileItemFac.setSizeThreshold(fileSize);	// 파일 업로드 사이즈
		
		ServletFileUpload upload = new ServletFileUpload(diskFileItemFac);
		try {
			//leacy project
//			List<FileItem> items = new ArrayList<>();
//			List<FileItem> items = upload.parseRequest(request);
			List<FileItem> items = new ArrayList<>();
			Iterator iterator = request.getFileNames();
			while(iterator.next()) {
				for(FileItem fileItem:items) {
					if(fileItem.isFormField()) {
						
					}else {
						// 여기에 파일 들어옴. 여기에서 파일 관련된 것들 즉 이름바꾸기 등을 처리한다.
						System.out.println("fieldName==="+fileItem.getFieldName());
						String orginalName = fileItem.getName();
						System.out.println("originalName==="+orginalName);
						String extension = orginalName.substring(orginalName.lastIndexOf("."));		//lastIndexOf()뒤에서 처음 나오는 무언가를 찾음
						UUID uuid = UUID.randomUUID();
						System.out.println(uuid);
						String fileName = uuid+extension;
						
						
						File uploadPath = new File(currentDir+"\\"+GetToday());
						if(!uploadPath.exists()) {
							uploadPath.mkdir();
						}
						fileItem.write(currentDir);
					}
				}
			}
				
			}
		catch (Exception e) {
				e.printStackTrace();
			}
		
		String userId = request.getParameter("userId"); 
		String userPw = request.getParameter("userPw"); 
		String userName = request.getParameter("userName"); 
		String userEmail = request.getParameter("userEmail"); 
		int zonecode = Integer.parseInt(request.getParameter("zonecode")); 
		String userAddress = request.getParameter("userAddress"); 
		String detailAddress = request.getParameter("detailAddress"); 
		String extraAddress = request.getParameter("extraAddress"); 
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

















