package controller.goods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Goodsinfo;
import dao.GoodsInfoDao;
/**
 * Servlet implementation class ClassifyGoodsServlet
 */
@WebServlet("/ClassifyGoodsServlet")
public class ClassifyGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassifyGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classify=(String)request.getParameter("classify");
		List<Goodsinfo> goodslist=new ArrayList<Goodsinfo>();
		GoodsInfoDao GIFD=new GoodsInfoDao();
		goodslist=(List<Goodsinfo>) GIFD.findByClassify(classify);
		if(goodslist==null) {
			request.setAttribute("BackNews", classify+"类暂时没有哦!");
			request.getRequestDispatcher("/shop/tips.jsp").forward(request, response);
		}
		request.setAttribute("goodslist",goodslist);
		request.getRequestDispatcher("/shop/classify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
