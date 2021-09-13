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
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet{
 
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		 request.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=utf-8");	
	     Integer id = Integer.parseInt(request.getParameter("id"));
	     String realname = request.getParameter("realname");
	     String phone = request.getParameter("phone");
	     String address = request.getParameter("address");
	     String self_introduce = request.getParameter("self_introduce");
	     String logname=request.getParameter("logname");
	     
	     UserInfoDao ud = new UserInfoDao();
		 ud.addUserInfo(id,logname,realname,phone, address, self_introduce);  
		 
		 List<UserInfo> listUser = ud.findAll();
		 request.setAttribute("list", listUser);
	     request.getRequestDispatcher("/admin/userlist.jsp").forward(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}