package bean;

import java.util.Date;

public class Cart {
 private Integer Oid;
 private Date Orderdate;
 private Goodsinfo Goods;
 private int Totalprice;
 private UserInfo user;
 private int quantity=1;
 
 
public Integer getOid() {
	return Oid;
}
public void setOid(Integer oid) {
	Oid = oid;
}
public Date getOrderdate() {
	return Orderdate;
}
public void setOrderdate(Date orderdate) {
	Orderdate = orderdate;
}
public Goodsinfo getGoods() {
	return Goods;
}
public void setGoods(Goodsinfo goods) {
	Goods = goods;
}
public int getTotalprice() {
	return Totalprice;
}
public void setTotalprice(int totalprice) {
	Totalprice = totalprice;
}
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
 
}
