package com.global.to;

public class ProductTO {

	private int productID;
	private int price;
	private String  productName;
	private String category;
	
	public ProductTO() {
		
	}
	
	public ProductTO(int productID, int price, String productName, String category) {
		this.productID=productID;
		this.price=price;
		this.productName=productName;
		this.category=category;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
