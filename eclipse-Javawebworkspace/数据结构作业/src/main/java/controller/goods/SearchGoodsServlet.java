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
 * Servlet implementation class SearchGoodsServlet
 */
@WebServlet("/SearchGoodsServlet")
public class SearchGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=utf-8");
	     String name = request.getParameter("search");	     
	     GoodsInfoDao ud = new GoodsInfoDao();
		 List<Goodsinfo> listGoods = ud.findByname(name);
		 if(listGoods!=null) {
			 request.setAttribute("name", name);
			 request.setAttribute("goodslist", listGoods);
		     request.getRequestDispatcher("shop/searchresult.jsp").forward(request,response);  
		 }
		 else {
			 System.out.print("null");
			 request.getRequestDispatcher("shop/Shop.jsp").forward(request, response);
		 }
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
