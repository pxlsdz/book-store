package entity;

public class Order {
int orderid,userid,pay;
double price;
String name,address,time;
public Order(int userid,String name,String address,int pay,String time,double price) {
	super();
	this.userid=userid;
	this.name=name;
	this.address=address;
	this.pay=pay;
	this.time=time;
	this.price=price;
}
public Order() {
}

public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public int getPay() {
	return pay;
}
public void setPay(int pay) {
	this.pay = pay;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}


}
