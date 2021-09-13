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
 * Servlet implementation class OrderStatusServlet
 */
@WebServlet("/OrderStatusServlet")
public class OrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=utf-8");
	     String status=(String)request.getParameter("status");
	     String order_id=(String)request.getParameter("order_id");
	     Integer Status=1;
	     if("确认收货".equals(status)) {
	    	 Status=4; 
	     }else if("支付".equals(status)) {
	        Status=2;
	     }
	 	 GetAllOrderDao GOD=new GetAllOrderDao();
	     GOD.ChangeStatus(Status,order_id);

	     System.out.println(Status);
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
