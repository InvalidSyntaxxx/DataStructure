package controller.User;
 
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserInfo;
import dao.UserInfoDao;
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet{
 
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		 request.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=utf-8");
	     int id = Integer.parseInt(request.getParameter("id"));
	     UserInfoDao ud = new UserInfoDao();
	     ud.deleteUserInfo(id);	 

		 List<UserInfo> listUser = ud.findAll();
		 request.setAttribute("list", listUser);
		 
		 request.getRequestDispatcher("admin/userlist.jsp").forward(request,response);
	}
	    	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}