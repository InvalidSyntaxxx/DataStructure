package bean;

import java.util.ArrayList;

public class UserInfo {
	private Integer id;
    private String logname="";
    private String password="";
    private String phone="";
    private String address="";
    private String realname="";
    private String backNews="«Î ‰»Î–≈œ¢";
    private ArrayList<Integer>carByid;
    private Integer self_order;
    private Integer history_order;
    private String new_old;
    private String self_introduce;
    
    public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
    
    public UserInfo() {
		
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getBackNews() {
		return backNews;
	}
	public void setBackNews(String backNews) {
		this.backNews = backNews;
	}

	 public ArrayList<Integer> getCar() {
			return carByid;
	   } 
    public void Addcar(int id) {
    	carByid.add(id);
    }
	
	public int getself_order() {
		return self_order;
	}

	public void setself_introduce(String introduce) {
		this.self_introduce = introduce;
	}
	public String getself_introduce() {
		return self_introduce;
	}
	public Integer getHistory_order() {
		return history_order;
	}
	public void setHistory_order(Integer history_order) {
		this.history_order = history_order;
	}
	public String getNew_old() {
		return new_old;
	}
	public void setNew_old(String new_old) {
		this.new_old = new_old;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}