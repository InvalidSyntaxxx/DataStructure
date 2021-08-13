package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserInfo;
import dao.UserInfoDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
    UserInfoDao dao=new UserInfoDao();
    UserInfo user = new UserInfo();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String logname = request.getParameter("userName");
		String password = request.getParameter("pwdName");
		
		if(logname.length()==0) {
			request.setAttribute(password, "密码为空");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		try {
			user = dao.login(logname,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user==null);
		if (user != null) {
		System.out.println("登录成功");
		HttpSession session = request.getSession();
		user.setLogname(logname);
		session.setAttribute("userlogname", user.getLogname());
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("shop/Shop.jsp").forward(request, response);
		}
		 else {
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("index.jsp").forward(request, response);// 转发
		     }
		
	}

}

