package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Order;
import utils.DBUtils;


public class  GetAllOrderDao{
	 List<Order> orderlist=new ArrayList<Order>();
	 
	 public List<Order> getorderbylogname(String logname){
	
		try {
    	Connection conn = DBUtils.getConnection();
    	String sql = "select * from allorder where logname=?";
    	PreparedStatement prep = conn.prepareStatement(sql);
    	prep.setString(1, logname);
		ResultSet rst = prep.executeQuery();
		while(rst.next()){
			Order order = new Order();
			order.setDate(rst.getString("date"));
			order.setStatus(rst.getInt("status"));
			order.setPhone(rst.getString("phone"));
			order.setAddress( rst.getString("address"));
			order.setGoods_name(rst.getString("goods_name"));
			order.setLogname(rst.getString("logname"));
			order.setOrder_id(rst.getString("order_id"));
			orderlist.add(order);
		}
		conn.close();
		prep.close();
		rst.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return orderlist;
   }
}
