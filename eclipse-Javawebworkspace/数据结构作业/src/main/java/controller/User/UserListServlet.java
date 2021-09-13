package controller.User;
 
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Page;
import bean.UserInfo;
import dao.UserInfoDao;
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet{
 
	private static final long serialVersionUID = 1L;
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		 request.setCharacterEncoding("UTF-8");
	     response.setContentType("text/html;charset=UTF-8");
	   //分页显示对应的代码
	     Page page = new Page();
	     String pageNum = request.getParameter("pageNum");
	     if(pageNum == null){
			page.setPageNum(1);
		 }else{
			page.setPageNum(Integer.parseInt(pageNum));
		 }	

	     	     
	     UserInfoDao ud = new UserInfoDao();
		 List<UserInfo> listUser = ud.findByPageNum(page);
		 request.setAttribute("list", listUser);
	     request.setAttribute("page", page);//对应分页
	     request.getRequestDispatcher("admin/userlist.jsp").forward(request,response);      
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
	        doGet(request, response);
	 }
}