package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserInfo;
import dao.UserInfoDao;
import utils.DBUtils;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
    UserInfoDao dao=new UserInfoDao();
    UserInfo user = new UserInfo();
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			Connection connection = DBUtils.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}///////////////////注意这里的连接数据库！！两次连接数据库，防止第一次调用的时候无法正常连接数据库，导致登录错误！！！
		String logname = request.getParameter("userName");
		String password = request.getParameter("pwdName");
		UserInfo userBean=new UserInfo();
		request.setAttribute("userBean", userBean);
		if(logname.length()==0) {
			response.setContentType("text/html;charset=UTF-8");
			userBean.setBackNews("提示：您还未输入用户名哦");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if(password.length()==0) {
			response.setContentType("text/html;charset=UTF-8");
			userBean.setBackNews("提示：您还未输入密码哦");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		try {
			user = dao.login(logname,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(user==null);
		if (user != null) {
		HttpSession session = request.getSession();
		user.setLogname(logname);
		session.setAttribute("userlogname", user.getLogname());
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("shop/Shop.jsp").forward(request, response);
		}
		 else {
		response.setContentType("text/html;charset=UTF-8");
		userBean.setBackNews("提示：您输入用户名不存在或者密码不正确，请重试");
		request.getRequestDispatcher("index.jsp").forward(request, response);// 转发
		     }
		
	}

}

