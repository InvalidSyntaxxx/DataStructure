package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Page;
import bean.UserInfo;
import utils.DBUtils;
 
public class UserInfoDao {
	
	List<UserInfo> userList = new ArrayList<UserInfo>();
	private UserInfo user; 	  

	 public void addUserInfo(Integer id,String logname, String realname, String phone,String address, String self_introduce) {
		 try {
        	Connection conn = DBUtils.getConnection();
        	String sql = "insert into user (logname, realname , phone, address, self_introduce,id) values (?, ?, ?, ?, ?,?)";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setString(1, logname);
        	prep.setString(2, realname);
        	prep.setString(3, phone);
        	prep.setString(4, address);
        	prep.setString(5, self_introduce);
        	prep.setInt(6,id);
        	System.out.println("添加成功！");
        	prep.executeUpdate();
        	prep.close();
        	conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	 
	public UserInfo selectUserInfo(int id){
		UserInfo user = null;
		Connection con = null;
		PreparedStatement prep = null;
		ResultSet rst = null;
		try {
			con=DBUtils.getConnection();
			String sql = "select * from user where id =?";
			prep = con.prepareStatement(sql);
			prep.setInt(1, id);
			rst = prep.executeQuery();
			while(rst.next()){
				user = new UserInfo();
				user.setId(rst.getInt("id"));
				user.setLogname(rst.getString("logname"));
				user.setPassword(rst.getString("password"));
				user.setRealname(rst.getString("realname"));
				user.setPhone(rst.getString("phone"));
				user.setAddress( rst.getString("address"));
				user.setself_introduce(rst.getString("self_introduce"));
				user.setHistory_order(rst.getInt("history_order"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}	
 	
	 public void updateUserInfo(Integer id, String logname, String password,String realname,String address, String self_introduce, String phone) {
		 try {

			Connection conn = DBUtils.getConnection();
			String sql = "update user set logname= ?, realname = ?, phone= ?, address= ?, self_introduce= ? ,password= ? where id= ?";
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
		 
	 public void deleteUserInfo(Integer id) {
		 try {
			Connection conn = DBUtils.getConnection();
			PreparedStatement prep = conn.prepareStatement("delete from user where id=?");
			prep.setInt(1, id);
			prep.executeUpdate();
			prep.close();
        	conn.close();
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	 
	 public List<UserInfo> findAll(){
		try {
	    	Connection conn = DBUtils.getConnection();
	    	String sql = "select * from user";
	    	PreparedStatement prep = conn.prepareStatement(sql);
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				int history_order=rst.getInt("history_order");//设置新老用户，打广告做基础！！
				user = new UserInfo();
				user.setId(rst.getInt("id"));
				user.setLogname(rst.getString("logname"));
				user.setRealname(rst.getString("realname"));
				user.setPassword(rst.getString("password"));
				user.setPhone(rst.getString("phone"));
				user.setAddress( rst.getString("address"));
				user.setself_introduce(rst.getString("self_introduce"));
				user.setHistory_order(rst.getInt("history_order"));
				if(history_order>10) {
					user.setNew_old("老用户");
				}else {
					user.setNew_old("新用户");
				}
				userList.add(user);
			}
			conn.close();
			prep.close();
			rst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return userList;
	}
	public UserInfo finduserByrealname(String realname){
		UserInfo user=new UserInfo();
		try {
			Connection conn = DBUtils.getConnection();
	    	String sql = "select * from user where realname=?";
	    	PreparedStatement prep = conn.prepareStatement(sql);
	    	prep.setString(1, realname); 
	    	ResultSet rst = prep.executeQuery();
	    	while(rst.next()) {
	    		user = new UserInfo();
	    		user.setId(rst.getInt("id"));
				user.setLogname(rst.getString("logname"));
				user.setRealname(rst.getString("realname"));
				user.setPhone(rst.getString("phone"));
				user.setAddress( rst.getString("address"));
				user.setself_introduce(rst.getString("self_introduce"));
				user.setHistory_order(rst.getInt("history_order"));
	    	}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return user;
	}
	public List<UserInfo> finduserBylogname(String logname){
		List<UserInfo> userList=new ArrayList<UserInfo>();
		try {
			Connection conn = DBUtils.getConnection();
	    	String sql = "select * from user where logname=?";
	    	PreparedStatement prep = conn.prepareStatement(sql);
	    	prep.setString(1, logname); 
	    	ResultSet rst = prep.executeQuery();
	    	while(rst.next()) {
	    		user = new UserInfo();
	    		user.setId(rst.getInt("id"));
				user.setLogname(rst.getString("logname"));
				user.setRealname(rst.getString("realname"));
				user.setPhone(rst.getString("phone"));
				user.setAddress( rst.getString("address"));
				user.setself_introduce(rst.getString("self_introduce"));
				user.setHistory_order(rst.getInt("history_order"));
				userList.add(user);
	    	}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return userList;
	}
	
	
	//分页查找
		public List<UserInfo> findByPageNum(Page page){
			int begin = (page.getPageNum()-1)*page.getPageSize();
			 System.out.println(page.getPageNum());
			 System.out.println(page.getPageSize());
	          System.out.println(page.getRecordsNum());
			try {
		    	Connection conn = DBUtils.getConnection();
		    	String sql = "select * from user order by id limit ?,? ";
		    	PreparedStatement prep = conn.prepareStatement(sql);
				prep.setInt(1, begin); 
				prep.setInt(2, page.getPageSize());
				
				ResultSet rst = prep.executeQuery();
				while(rst.next()){
					user = new UserInfo();
					int history_order=rst.getInt("history_order");
		    		user.setId(rst.getInt("id"));
					user.setLogname(rst.getString("logname"));
					user.setRealname(rst.getString("realname"));
					user.setPhone(rst.getString("phone"));
					user.setAddress( rst.getString("address"));
					user.setself_introduce(rst.getString("self_introduce"));
					user.setHistory_order(rst.getInt("history_order"));
					userList.add(user);
					if(history_order>10) {
						user.setNew_old("老用户");
					}else {
						user.setNew_old("新用户");
					}
					userList.add(user);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userList;
		}
		
		//获取总记录数量
		public int getRecordsNum(){
			Connection con = null;
			PreparedStatement ps=null;
			ResultSet rs = null;
			int recordsNum = 0;
			try {
				con = DBUtils.getConnection();
				String sql = "select count(*) count from user"; //获得表中记录数
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					recordsNum = rs.getInt("count");
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return recordsNum;
		}
		public UserInfo login(String logname,String password) throws Exception {

			Connection connection = DBUtils.getConnection();
			String sql = "SELECT * FROM user WHERE logname = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, logname);
			ResultSet rst = statement.executeQuery();
			UserInfo user=null;
			while (rst.next()) {
			    user = new UserInfo();
			    user.setPassword(rst.getString("logname"));
			    user.setPassword(rst.getString("password"));
				user.setId(rst.getInt("id"));
				System.out.println(user.getLogname()==null);
			}
			if(user!=null&&!user.getPassword().equals(password)) {
			 System.out.print("密码错误");
			  user=null;
			}
			DBUtils.close(rst, statement, connection);
			return user;
		}
		public int register(UserInfo user) throws SQLException{
			Connection connection = DBUtils.getConnection();
			String sql = "INSERT INTO user (logname,password) VALUES (?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getLogname());
			statement.setString(2, user.getPassword());
			int row = statement.executeUpdate();
			DBUtils.close(null, statement, connection);
			return row;
		}
		/////////////////////////////////////////////////////
		
		public UserInfo findByUsername(String username){
			UserInfo user = null;       
			Connection conn = null;
			    	
	        try {
	        	conn = DBUtils.getConnection();

	        	PreparedStatement prep = conn.prepareStatement("select * from user where username=?");
				prep.setString(1, username);
				ResultSet rst = prep.executeQuery();	
				if(rst.next()){
					System.out.println(rst.getInt("id"));
					user = new UserInfo();
					user.setId(rst.getInt("id"));
					user.setLogname(username);
					user.setPassword(rst.getString("pwd"));
					user.setRealname(rst.getString("name"));
				}			
			} catch (Exception e) {			
				e.printStackTrace();
			}
			return user;	
		}

}
