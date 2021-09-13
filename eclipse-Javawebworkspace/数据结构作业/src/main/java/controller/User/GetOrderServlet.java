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
import dao.GetAllOrderDao;

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
	     
	 	String userlogname=(String)request.getSession().getAttribute("userlogname");
		if(userlogname==null) {
			request.setAttribute("BackNews", "Äú»¹Î´µÇÂ½Å¶Ç×£¬ÇëµÇÂ¼ºóÔÚ½øÐÐ²Ù×÷");
			request.getRequestDispatcher("shop/tips.jsp").forward(request, response);
		}
	     
	     GetAllOrderDao GOD=new GetAllOrderDao();
	     List<Order> order=new ArrayList<Order>();
	     order=GOD.getorderbylogname(userlogname);
		 request.setAttribute("list", order);
	     request.getRequestDispatcher("user/myorder.jsp").forward(request,response);      
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
