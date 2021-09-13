package controller.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Goodsinfo;
import bean.UserInfo;
import dao.CreatOrderDao;
import dao.GoodsInfoDao;
import dao.UserInfoDao;



@WebServlet("/BuyGoodsServlet")
public class BuyGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userlogname=(String)request.getSession().getAttribute("userlogname");
		if(userlogname==null) {
			request.setAttribute("BackNews", "您还未登陆哦亲，请登录后在进行操作");
			request.getRequestDispatcher("shop/tips.jsp").forward(request, response);
		}
		UserInfoDao user=new UserInfoDao();
		List<UserInfo> userlist=new ArrayList<UserInfo>();
		userlist=user.finduserBylogname(userlogname);
		
		
		UserInfo user1=userlist.get(0);
		int goods_id=Integer.parseInt(request.getParameter("goods_id"));
		GoodsInfoDao gd=new GoodsInfoDao();
		Goodsinfo goods=gd.findByid(goods_id);
		if(goods.getStock()<=0) {
			request.setAttribute("BackNews", "该商品太火热了已经被抢空啦，请您再看看其他商品吧！");
		    request.getRequestDispatcher("shop/tips.jsp").forward(request, response);
		    return;
		}
		System.out.println("查找成功");
		CreatOrderDao COD=new CreatOrderDao();
		COD.CreatOrderDao(user1, goods);
		request.setAttribute("BackNews", "下单成功！感谢您的支持，请前往我的订单进行支付吧。");
	    request.getRequestDispatcher("shop/tips.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
