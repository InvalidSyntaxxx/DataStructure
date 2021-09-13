package controller.goods;

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
 * Servlet implementation class GetAllOrderServlet
 */
@WebServlet("/GetAllOrderServlet")
public class GetAllOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=utf-8");
	     GetAllOrderDao GOD=new GetAllOrderDao();
	     List<Order> order=new ArrayList<Order>();
	     order=GOD.getallorder();
		 request.setAttribute("list", order);
	     request.getRequestDispatcher("admin/profit.jsp").forward(request,response);      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
