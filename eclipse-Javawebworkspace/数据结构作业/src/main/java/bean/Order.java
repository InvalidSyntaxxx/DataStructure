package bean;

import dao.GoodsInfoDao;

public class Order {
private UserInfo user;
private int quantity;
private int totalprice;
private String date;
private Goodsinfo goods;
private int status;//1、为未支付 2、为已支付未发货 3、为已发货为收货  4、为已收货订单完成
private Goodsinfo GoodsByid;
private String order_id;
private String goods_name;
private String phone;
private String address;
private String logname;
private String realname;
private int profit;
public UserInfo getUser() {
	return user;
}
public void setUser(UserInfo user) {
	this.user = user;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getTotalprice() {
	return totalprice;
}
public void setTotalprice(int totalprice) {
	this.totalprice = totalprice;
}
public Goodsinfo getGoods() {
	return goods;
}
public void setGoods(Goodsinfo goods) {
	this.goods = goods;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getDate() {
	return date;
}
public void setDate(String string) {
	this.date = string;
}

public Goodsinfo getGoodsByid() {
	return GoodsByid;
}
public void setGoodsByid(int goods_id) {
	GoodsInfoDao GID=new GoodsInfoDao();
	Goodsinfo list=GID.findByid(goods_id);
	this.GoodsByid=list;
}
public String getOrder_id() {
	return order_id;
}
public void setOrder_id(String order_id) {
	this.order_id = order_id;
}
public String getGoods_name() {
	return goods_name;
}
public void setGoods_name(String goods_name) {
	this.goods_name = goods_name;
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
public String getLogname() {
	return logname;
}
public void setLogname(String logname) {
	this.logname = logname;
}
public String getRealname() {
	return realname;
}
public void setRealname(String realname) {
	this.realname = realname;
}
public int getProfit() {
	return profit;
}
public void setProfit(int profit) {
	this.profit = profit;
}

}
