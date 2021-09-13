package controller.User;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserInfo;
import utils.DBUtils;
@WebServlet("/UserinfoServlet")
public class UserinfoServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		 request.setCharacterEncoding("UTF-8");
	     response.setContentType("text/html;charset=utf-8");
		UserInfo userBean=new UserInfo();
		request.setAttribute("userBean", userBean);
		String logname=request.getParameter("logname").trim();
		String password=request.getParameter("password").trim();
		String again_password=request.getParameter("again_password").trim();
		String phone=request.getParameter("phone").trim();
		String address=request.getParameter("address").trim();
		String realname=request.getParameter("realname").trim();
		String originpassword=request.getParameter("originpassword".trim());
		String self_introduce=request.getParameter("self_introfuce");
		System.out.print(originpassword);
		if(logname==null)
			logname="";
		if(password==null)
			password="";
		if(!password.equals(again_password)){
			userBean.setBackNews("两次密码不同，注册失败！");
			RequestDispatcher dispatcher=request.getRequestDispatcher("userinfo.jsp");
			dispatcher.forward(request, response);
			return;
		}
		boolean isLD=true;
		for(int i=0;i<logname.length();i++){//用户名字符或数字的判定
			char c=logname.charAt(i);
			if(!((c<='z'&&c>='a')||(c<='Z'&&c>='A')||(c<='9'&&c>='0')))
				isLD=false;
		}
		int check=0;
		if(logname.length()>0&&password.length()>0&&isLD)
			check=0;
		else {
			check=1;
		}
		String backNews="";//返回是否成功的消息
		try {
		Connection con1 = DBUtils.getConnection();
		String sql2="select password from user where logname=?";
	    PreparedStatement Originpassword=con1.prepareStatement(sql2);
	    Originpassword.setString(1, logname);
	    ResultSet rs2=Originpassword.executeQuery();
	    while(rs2.next()) {
	    	if(!originpassword.equals(rs2.getString("password"))) {
	    		System.out.println(rs2.getString("password"));
				backNews="原始密码不对！请再试一次";
				userBean.setBackNews(backNews);
				request.getRequestDispatcher("user/userinfo.jsp").forward(request, response);
				return;
			}
	    }
		
		}catch(Exception e) {
			System.out.print(e);
		}
		try{
		    if(check==0){
		    	Connection con2=DBUtils.getConnection();
		    	String insertCondition="update user set password=?,phone=?,address=?,realname=?,self_introduce=? where logname=?";
		    	PreparedStatement insertsql = con2.prepareStatement(insertCondition);
		    	   
					insertsql.setString(1,password);
					insertsql.setString(2, phone);
					insertsql.setString(3, address);
					insertsql.setString(4, realname);
					insertsql.setString(5, self_introduce);
					 insertsql.setString(6, logname);
					int m=insertsql.executeUpdate();
					if(m!=0){//更新成功之后，将数据存到userBean中
						backNews="个人信息修改成功！";
						userBean.setBackNews(backNews);
						userBean.setLogname(logname);
						userBean.setPhone(phone);
						userBean.setAddress(address);
						userBean.setRealname(realname);
					}
				}
			      else {
					backNews="您输入的信息不完整或用户名中有非法字符";
					userBean.setBackNews(backNews);
				}
		}
	      catch(Exception e){
			backNews="程序出错啦！错误信息："+e;
			userBean.setBackNews(backNews);
		  }
		request.getRequestDispatcher("user/userinfo.jsp").forward(request, response);
	}
 
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
}