package bean;

public class Goodsinfo {
	private Integer id;
    private String name;
    private Integer price;
    private Integer pictureID; 
    private String detail;
    private Integer stock;
    private Integer sale;
	private String classify;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getPictureID() {
		return pictureID;
	}
	public void setPictureID(Integer pictureID) {
		this.pictureID = pictureID;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getSale() {
		return sale;
	}
	public void setSale(Integer sale) {
		this.sale = sale;
	}
	public void setClassify(String classify) {
		this.classify=classify;
		
	}
	public String getClassify() {
		return classify;
	}

}
