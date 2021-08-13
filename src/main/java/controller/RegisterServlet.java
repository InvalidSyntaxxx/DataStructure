package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserInfo;
import dao.UserInfoDao;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private UserInfoDao userService = new UserInfoDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd1 = request.getParameter("pwdName1");
		String pwd2 = request.getParameter("pwdName2");
		UserInfo user = new UserInfo();			
		user.setLogname(request.getParameter("userName"));
		if(pwd1.equals(pwd2)){
			user.setPassword(pwd1);
			int row = 0;
			try {
				row = userService.register(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("改变的行数："+row);
			if (row > 0) {
			System.out.println("注册成功");
			String backNews="注册成功！";
			request.setAttribute(backNews, backNews);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				String backNews="注册失败！";
				request.setAttribute(backNews, backNews);
				request.getRequestDispatcher("user/register.jsp").forward(request, response);
			}		
		}else {
			System.out.println("两次密码不同，注册失败");
			request.getRequestDispatcher("user/register.jsp").forward(request, response);
		}

	}

}

