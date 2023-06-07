package com.global.to;

public class OrderTO {
	private String orderid;
	private String userid;
	private String productid;
	private String date;
	
	public OrderTO() {
		
	}
	
	public OrderTO(String orderid, String userid, String productid, String date) {
		this.orderid=orderid;
		this.userid=userid;
		this.productid=productid;
		this.date=date;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
