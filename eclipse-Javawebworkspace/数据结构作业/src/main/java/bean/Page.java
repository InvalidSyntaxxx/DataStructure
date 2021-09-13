package bean;
 
import dao.UserInfoDao;
 
public class Page {	   
	private int pageNum;//ҳ����		
	private int pageSize = 6;//ÿҳ��ʾ����,Ĭ��Ϊ3
	private int pageTotal;//��ҳ��
	private int recordsNum;//�ܼ�¼��
 
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