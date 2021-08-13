package controller.User;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserInfo;
import dao.UserInfoDao;
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		 request.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=utf-8");
	     
	     UserInfoDao ud = new UserInfoDao();
	     Integer id = Integer.parseInt(request.getParameter("id"));
	     String password = request.getParameter("password");
	     String logname = request.getParameter("logname");
	     String realname = request.getParameter("realname");
	     String address = request.getParameter("address");
	     String self_introuce = request.getParameter("self_introduce"); 
	     String phone=request.getParameter("phone");
	    
	     ud.updateUserInfo(id, logname, password, realname, address, self_introuce,phone);   
	     

		 List<UserInfo> listUser = ud.findAll();
		 request.setAttribute("list", listUser);
		 
		 PrintWriter out=response.getWriter();
		 out.print("<html><body>alert(\"更新成功！\");</body></html>");
	     request.getRequestDispatcher("admin/userlist.jsp").forward(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}