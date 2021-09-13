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
			order.setRealname(rst.getString("realname"));
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
	 public void  ChangeStatus(Integer status,String order_id){
			
			try {

	    	Connection conn = DBUtils.getConnection();
	    	String sql = "update  allorder set status= ?  where order_id=?";
	    	PreparedStatement prep = conn.prepareStatement(sql);
	    	prep.setInt(1, status);
	    	prep.setString(2, order_id);
	    	prep.executeUpdate();        	
	    	 System.out.println(status);
			conn.close();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	   }
	public List<Order> getallorder() {
		try {
	    	Connection conn = DBUtils.getConnection();
	    	String sql = "select * from allorder";
	    	PreparedStatement prep = conn.prepareStatement(sql);
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
				order.setRealname(rst.getString("realname"));
		       order.setProfit(rst.getInt("price"));
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
