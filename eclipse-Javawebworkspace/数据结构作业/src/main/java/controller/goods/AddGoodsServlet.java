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

@WebServlet("/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=utf-8");	
	     Integer id = Integer.parseInt(request.getParameter("id"));
	     String name = request.getParameter("name");
	     Integer price = Integer.parseInt(request.getParameter("price"));
	     String detail = request.getParameter("detail");
	     Integer stock = Integer.parseInt(request.getParameter("stock"));
	     String classify=request.getParameter("classify");
	     GoodsInfoDao ud = new GoodsInfoDao();
		 ud.addGoodsInfo(id,name,price,detail, stock,classify);  
		 
		 List<Goodsinfo> listGoods = ud.findAll();
		 request.setAttribute("list", listGoods);
		 
	     request.getRequestDispatcher("/goods/goodslist.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
