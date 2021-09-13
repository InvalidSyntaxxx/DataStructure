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
         	String sql = "insert into allorder (logname, phone, address,goods_name,goods_id, price,date,status,order_id,realname) values (?,?, ?, ?, ?, ?,  NOW(),?, ?,?)";
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
         	prep.setString(9, user.getRealname());
         	System.out.println("添加成功！");
         	
         	////////////////让库存和销量发生变化////////
         	String sql2 = " update goods set stock=stock-1  where goods_id=?";
         	PreparedStatement prep2 = conn.prepareStatement(sql2);
         	prep2.setInt(1, goods.getId());
        	String sql3 = " update goods set quantity_of_sale=quantity_of_sale+1  where goods_id=?";
         	PreparedStatement prep3 = conn.prepareStatement(sql3);
         	prep3.setInt(1, goods.getId());
         	
         	prep.executeUpdate();
         	prep.close();
         	
        	prep2.executeUpdate();
         	prep2.close();
         	
        	prep3.executeUpdate();
         	prep3.close();
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
