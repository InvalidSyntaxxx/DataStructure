package controller.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Cart;
import bean.Goodsinfo;
import bean.Order;
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
		UserInfoDao user=new UserInfoDao();
		List<UserInfo> userlist=new ArrayList<UserInfo>();
		userlist=user.finduserBylogname(userlogname);
		
		if(userlist==null) {
			request.setAttribute("BackNews", "����δ��½Ŷ�ף����¼���ڽ��в���");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		UserInfo user1=userlist.get(0);
		int goods_id=Integer.parseInt(request.getParameter("goods_id"));
		GoodsInfoDao gd=new GoodsInfoDao();
		Goodsinfo goods=gd.findByid(goods_id);
		System.out.println("���ҳɹ�");
		CreatOrderDao COD=new CreatOrderDao();
		COD.CreatOrderDao(user1, goods);
		user1.setBackNews("����ɹ���л����֧�֣�");
		request.setAttribute("BackNews", "����ɹ�����л����֧��");
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
