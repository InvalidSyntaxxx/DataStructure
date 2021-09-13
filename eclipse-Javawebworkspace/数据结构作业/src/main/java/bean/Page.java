package bean;
 
import dao.UserInfoDao;
 
public class Page {	   
	private int pageNum;//页码数		
	private int pageSize = 6;//每页显示数量,默认为3
	private int pageTotal;//总页数
	private int recordsNum;//总记录数
 
	UserInfoDao userDaoInfo = new UserInfoDao();
		
	public int getPageNum() {
		return pageNum;
	}
 
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
 
	public int getPageSize() {
		return pageSize;
	}
 
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
 
	public int getRecordsNum() {
		return recordsNum;
	}
 
	public void setRecordsNum(int recordsNum) {
		this.recordsNum = recordsNum;
	}
 
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
 
	public int getPageTotal(){
		recordsNum = userDaoInfo.getRecordsNum();
		int mod = recordsNum % pageSize;
		if(mod == 0){
			pageTotal=recordsNum/pageSize;
		}else{
			pageTotal=recordsNum/pageSize+1;
		}
		return pageTotal;
	}	     
}