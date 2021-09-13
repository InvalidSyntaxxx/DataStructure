package controller.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Goodsinfo;
import dao.GoodsInfoDao;

/**
 * Servlet implementation class UpdateGoodsServlet
 */
@WebServlet("/UpdateGoodsServlet")
public class UpdateGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=utf-8");
	     
	     GoodsInfoDao ud = new GoodsInfoDao();
	     Integer id = Integer.parseInt(request.getParameter("id"));
	     String password = request.getParameter("name");
	     String logname = request.getParameter("price");
	     String realname = request.getParameter("classify");
	     String address = request.getParameter("detail");
	     String self_introuce = request.getParameter("stock"); 
	     String phone=request.getParameter("sale");
	    
	     ud.updateGoodsInfo(id, logname, password, realname, address, self_introuce,phone);   
	     

		 List<Goodsinfo> listUser = ud.findAll();
		 request.setAttribute("list", listUser);
		 

	     request.getRequestDispatcher("goods/goodslist.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
