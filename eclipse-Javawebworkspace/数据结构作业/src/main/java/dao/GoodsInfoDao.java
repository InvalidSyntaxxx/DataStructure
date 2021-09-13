package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Goodsinfo;
import utils.DBUtils;

public class GoodsInfoDao {
	
	private Goodsinfo goods; 	  
	
	 public void addGoodsInfo(Integer id,String name, Integer price, String detail,Integer stock,String classify) {
		 try {
        	Connection conn = DBUtils.getConnection();
        	String sql = "insert into goods (goods_id, goods_name , price, detail,stock,classify) values (?, ?, ?, ?, ?,?)";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setLong(1, id);
        	prep.setString(2, name);
        	prep.setLong(3, price);
        	prep.setString(4, detail);
        	prep.setLong(5, stock);
        	prep.setString(6, classify);
        	System.out.println("耶紗撹孔��");
        	prep.executeUpdate();
        	prep.close();
        	conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	 
	public Goodsinfo selectGoodsinfo(int id){
		Goodsinfo goods = null;
		Connection con = null;
		PreparedStatement prep = null;
		ResultSet rst = null;
		try {
			con=DBUtils.getConnection();
			String sql = "select * from goods where goods_id =?";
			prep = con.prepareStatement(sql);
			prep.setInt(1, id);
			rst = prep.executeQuery();
			while(rst.next()){
				goods = new Goodsinfo();
				goods.setId(rst.getInt("goods_id"));
				goods.setName(rst.getString("goods_name"));
				goods.setPrice(rst.getInt("price"));
				goods.setDetail(rst.getString("detail"));
				goods.setStock(rst.getInt("stock"));
				goods.setSale( rst.getInt("quantity_of_sale"));
				goods.setClassify(rst.getString("classify"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goods;
	}	
 	
	 public void updateGoodsInfo(Integer id, String name, Integer price,Integer stock,String detail) {
		 try {

			Connection conn = DBUtils.getConnection();
			String sql = "update goods set stock= ?, goods_name = ?, price= ?, detail= ? where goods_id= ?";
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setLong(1, stock);
        	prep.setString(2, name);
        	prep.setLong(3, price);
        	prep.setString(4, detail);
            prep.setInt(5, id);
        	prep.executeUpdate();        	
        	prep.close();
        	conn.close();
        	
		} catch (Exception e) {	
			e.printStackTrace();
		} 
	}
		 ///////////////////////////////////////////////////////////////////////////
	 public void deleteGoodsInfo(Integer id) {
		 try {
			Connection conn = DBUtils.getConnection();
			PreparedStatement prep = conn.prepareStatement("delete from goods where goods_id=?");
			prep.setInt(1, id);
			prep.executeUpdate();
			prep.close();
        	conn.close();
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	 
	 public List<Goodsinfo> findAll(){
		 List<Goodsinfo> GoodsList = new ArrayList<Goodsinfo>();
		try {
	    	Connection conn = DBUtils.getConnection();
	    	String sql = "select * from goods";
	    	PreparedStatement prep = conn.prepareStatement(sql);
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				
				goods = new Goodsinfo();
				goods.setId(rst.getInt("goods_id"));
				goods.setName(rst.getString("goods_name"));
				goods.setPrice(rst.getInt("price"));
				goods.setDetail(rst.getString("detail"));
				goods.setStock(rst.getInt("stock"));
				goods.setSale( rst.getInt("quantity_of_sale"));
				goods.setClassify(rst.getString("classify"));
				GoodsList.add(goods);
			}
			conn.close();
			prep.close();
			rst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return GoodsList;
	}
	public List<Goodsinfo> findByname(String name){
		List<Goodsinfo> GoodsList = new ArrayList<Goodsinfo>();
		try {
			System.out.print(name);
			Connection conn = DBUtils.getConnection();
	    	String sql = "select * from goods where detail like ? ";
	    	PreparedStatement prep = conn.prepareStatement(sql);
	    	prep.setString(1, "%"+name+"%"); 
	    	ResultSet rst = prep.executeQuery();
	    	while(rst.next()) {
	    		goods = new Goodsinfo();
	    		goods.setId(rst.getInt("goods_id"));
				goods.setName(rst.getString("goods_name"));
				goods.setPrice(rst.getInt("price"));
				goods.setDetail(rst.getString("detail"));
				goods.setStock(rst.getInt("stock"));
				goods.setSale( rst.getInt("quantity_of_sale"));
				goods.setClassify(rst.getString("classify"));
				GoodsList.add(goods);
	    	}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return GoodsList;
	}
	public Goodsinfo findByid(int id){
		Goodsinfo goods = new Goodsinfo();
		try {
			System.out.print(id);
			Connection conn = DBUtils.getConnection();
	    	String sql = "select * from goods where goods_id=? ";
	    	PreparedStatement prep = conn.prepareStatement(sql);
	    	prep.setInt(1, id); 
	    	ResultSet rst = prep.executeQuery();
	    	while(rst.next()) {
	    		goods = new Goodsinfo();
	    		goods.setId(rst.getInt("goods_id"));
				goods.setName(rst.getString("goods_name"));
				goods.setPrice(rst.getInt("price"));
				goods.setDetail(rst.getString("detail"));
				goods.setStock(rst.getInt("stock"));
				goods.setSale( rst.getInt("quantity_of_sale"));
				goods.setClassify(rst.getString("classify"));
	    	}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return goods;
	}

	public List<Goodsinfo> findByClassify(String classify){
		List<Goodsinfo> goodslist = new ArrayList<Goodsinfo>();
		 System.out.println(classify);
		try {
			Connection conn = DBUtils.getConnection();
	    	String sql = "select * from goods where classify=? ";
	    	PreparedStatement prep = conn.prepareStatement(sql);
	    	prep.setString(1,classify); 
	    	ResultSet rst = prep.executeQuery();
	    	System.out.println("！！！！！！！！！！！！！！！！！！！！！！");
	    	while(rst.next()) {
	    		goods = new Goodsinfo();
	    		goods.setId(rst.getInt("goods_id"));
				goods.setName(rst.getString("goods_name"));
				goods.setPrice(rst.getInt("price"));
				goods.setDetail(rst.getString("detail"));
				goods.setStock(rst.getInt("stock"));
				goods.setSale( rst.getInt("quantity_of_sale"));
				goods.setClassify(rst.getString("classify"));
				goodslist.add(goods);
				System.out.println(goods.getDetail());
	    	}
	}catch (Exception e) {
		e.printStackTrace();
	}
		for(Goodsinfo gs:goodslist) {
			 System.out.println(gs.getClassify());
		}
  
		return goodslist;
	}


	public void updateGoodsInfo(Integer id, String logname, String password, String realname, String address,
			String self_introduce, String phone) {
		
		 try {

				Connection conn = DBUtils.getConnection();
				String sql = "update goods set goods_name= ?, price = ?, classify= ?, detail= ?, stock= ? ,quantity_of_sale= ? where id= ?";
				PreparedStatement prep = conn.prepareStatement(sql);
	        	prep.setString(1, logname);
				prep.setString(2, realname);
	        	prep.setString(3, phone);
	        	prep.setString(4, address);
	        	prep.setString(5, self_introduce);
	        	prep.setString(6, password);
	        	prep.setInt(7, id);
	        	prep.executeUpdate();        	
	        	prep.close();
	        	conn.close();
			} catch (Exception e) {	
				e.printStackTrace();
			} 
		
	}
}
