

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginResult")
public class LoginResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginResult() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	String userId = request.getParameter("userId");
	String userpw = request.getParameter("userpw");
	if(userId.equals("aa")&& userpw.equals("1234")) {
	out.println("<p>succes</p>");
	}else {
		out.println("<p>fail</p>");
		out.println("<a href='javascript:history.back()'>back</a>");
	}
	
	}


}
