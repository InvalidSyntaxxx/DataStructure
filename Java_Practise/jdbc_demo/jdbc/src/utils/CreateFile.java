package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;

public class CreateFile {

	public static void main(String[] args) {
	     try {
	    	 //store();
			   get();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void store() throws ClassNotFoundException, SQLException, IOException {

	    String url = "jdbc:mysql://localhost:3306/test";
	    String user="root";
		String password="";

	    Class.forName("com.mysql.jdbc.Driver");
	    Connection connection = DriverManager.getConnection(url, user, password);
	    System.out.println("Connecting MySql...");	
	    
	    String sql = "insert into tab_bin values(?,?,?)";
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    preparedStatement.setInt(1, 1);
	    preparedStatement.setString(2, "test.png");
	    /**
	     * 我们需要得到一个Blob
	     * 先把文件变成 byte[]，这里我们使用一个工具类的方法，这个工具类，大家可以在资源下载里下载。
	     * 再使用byte[]创建Blob
	     */
	    //把文件变成byte[]
	    byte[] bytes = IOUtils.toByteArray(new FileInputStream("C://Users/86199/vue-hello/src/assets/logo.png"));
	    Blob blob = new SerialBlob(bytes);
	    preparedStatement.setBlob(3, blob);
	    preparedStatement.execute();
	}
	
	/**
	 * 从数据库中读取 MP3。
	 */
	public static void get() throws ClassNotFoundException, SQLException, IOException {
	    String url = "jdbc:mysql://localhost:3306/test";
	    String user="root";
	  	String password="";
        
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection connection = DriverManager.getConnection(url, user, password);
	    String sql = "select * from tab_bin";
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    ResultSet resultSet = preparedStatement.executeQuery(sql);
	    // 获取resultSet中列为data的数据
	    if (resultSet.next()) {
	    	
	        Blob blob = resultSet.getBlob("data");
	        // 把blob变成硬盘上的文件
	        // 通过blob得到输入流对象
	        // 自己创建输出流对象
	        // 把输入流数据写入到输出流中
	        InputStream inputStream = blob.getBinaryStream();
	        OutputStream out = new FileOutputStream("C://Users/86199/Desktop/傻瓜.jpg");
	        IOUtils.copy(inputStream,out);
	        
	    }
	}

	

}
