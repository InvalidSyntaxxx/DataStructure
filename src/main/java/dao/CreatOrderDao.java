package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import bean.Goodsinfo;
import bean.Order;
import bean.UserInfo;
import common.GetRandomString;
import utils.DBUtils;

public class CreatOrderDao {
    public void CreatOrderDao(UserInfo user,Goodsinfo goods) {
    	GetRandomString Random=new GetRandomString();
    	 try {
         	Connection conn = DBUtils.getConnection();
         	String sql = "insert into allorder (logname, phone, address,goods_name,goods_id, price,date,status,order_id) values (?, ?, ?, ?, ?, ?, NOW(), ?,?)";
         	PreparedStatement prep = conn.prepareStatement(sql);
         	prep.setString(1, user.getLogname());
         	prep.setString(2, user.getPhone());
         	prep.setString(3, user.getAddress());
         	prep.setString(4, goods.getName());
         	prep.setInt(5, goods.getId());
         	prep.setInt(6, goods.getPrice());
//         	prep.setObject(7,  new Date(System.currentTimeMillis()));
         	prep.setInt(7, 1);//默认未支付
         	prep.setString(8, Random.Random(8));
         	System.out.println("添加成功！");
         	prep.executeUpdate();
         	prep.close();
         	conn.close();
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
    }
    public void setStatus(int status,Order order) {
    	try {
    		Connection conn = DBUtils.getConnection();
    		String sql = " update order set status=? where order_id=?";
         	PreparedStatement prep = conn.prepareStatement(sql);
         	prep.setInt(1, status);
         	prep.setString(2, order.getOrder_id());
         	prep.executeUpdate();
         	prep.close();
         	conn.close();
    	}catch (Exception e) {
 			e.printStackTrace();
 		}
    }
}
