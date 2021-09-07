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
		String password="WANGchen0809.";

	    Class.forName("com.mysql.jdbc.Driver");
	    Connection connection = DriverManager.getConnection(url, user, password);
	    System.out.println("Connecting MySql...");	
	    
	    String sql = "insert into tab_bin values(?,?,?)";
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    preparedStatement.setInt(1, 1);
	    preparedStatement.setString(2, "test.png");
	    /**
	     * ������Ҫ�õ�һ��Blob
	     * �Ȱ��ļ���� byte[]����������ʹ��һ��������ķ�������������࣬��ҿ�������Դ���������ء�
	     * ��ʹ��byte[]����Blob
	     */
	    //���ļ����byte[]
	    byte[] bytes = IOUtils.toByteArray(new FileInputStream("C://Users/86199/vue-hello/src/assets/logo.png"));
	    Blob blob = new SerialBlob(bytes);
	    preparedStatement.setBlob(3, blob);
	    preparedStatement.execute();
	}
	
	/**
	 * �����ݿ��ж�ȡ MP3��
	 */
	public static void get() throws ClassNotFoundException, SQLException, IOException {
	    String url = "jdbc:mysql://localhost:3306/test";
	    String user="root";
	  	String password="WANGchen0809.";
        
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection connection = DriverManager.getConnection(url, user, password);
	    String sql = "select * from tab_bin";
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    ResultSet resultSet = preparedStatement.executeQuery(sql);
	    // ��ȡresultSet����Ϊdata������
	    if (resultSet.next()) {
	    	
	        Blob blob = resultSet.getBlob("data");
	        // ��blob���Ӳ���ϵ��ļ�
	        // ͨ��blob�õ�����������
	        // �Լ��������������
	        // ������������д�뵽�������
	        InputStream inputStream = blob.getBinaryStream();
	        OutputStream out = new FileOutputStream("C://Users/86199/Desktop/��.jpg");
	        IOUtils.copy(inputStream,out);
	        
	    }
	}

	

}