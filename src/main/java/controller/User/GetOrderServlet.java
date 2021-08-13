package controller.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import bean.UserInfo;
import dao.GetAllOrderDao;
import dao.UserInfoDao;

/**
 * Servlet implementation class GetOrderServlet
 */
@WebServlet("/GetOrderServlet")
public class GetOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=utf-8");
	   //分页显示对应的代码
//	     Page page = new Page();
//	     String pageNum = request.getParameter("pageNum");
//	     if(pageNum == null){
//			page.setPageNum(1);
//		 }else{
//			page.setPageNum(Integer.parseInt(pageNum));
//		 }	
	 	String userlogname=(String)request.getSession().getAttribute("userlogname");
		UserInfoDao user=new UserInfoDao();
		List<UserInfo> userlist=new ArrayList<UserInfo>();
		userlist=user.finduserBylogname(userlogname);
		
		if(userlist==null) {
			request.setAttribute("BackNews", "您还未登陆哦亲，请登录后在进行操作");
			request.getRequestDispatcher("shop/tips.jsp").forward(request, response);
		}
		UserInfo user1=userlist.get(0);
	     
	     GetAllOrderDao GOD=new GetAllOrderDao();
	     List<Order> order=new ArrayList<Order>();
	     order=GOD.getorderbylogname(userlogname);
		 request.setAttribute("list", order);
		 for(Order or:order) {
		    	System.out.println(or.getOrder_id());
		    	System.out.println(or.getDate());
		    }
	     request.getRequestDispatcher("user/myorder.jsp").forward(request,response);      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
