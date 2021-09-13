package controller.User;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserInfo;
import dao.UserInfoDao;
@WebServlet("/GetUserServlet")
public class GetUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		 request.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=utf-8");
	     
	     int id = Integer.parseInt(request.getParameter("id"));
	     UserInfoDao ud = new UserInfoDao();
		 UserInfo user = ud.selectUserInfo(id);
		 request.setAttribute("user", user);
	     request.getRequestDispatcher("admin/updateuser.jsp").forward(request,response);	
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
	        doGet(request, response);
	 }
}