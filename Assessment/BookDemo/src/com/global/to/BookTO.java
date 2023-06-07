package com.global.to;

public class BookTO {
	
	private int bookID;
	private int price;
	private int noOfCopiesSold;
	private String authorName;
	private String bookName;
	private String publicationName;
	
	
	public BookTO() {
		
	}
	public BookTO(int bookID, int price, int noOfCopiesSold, String authorName, String bookName, String publicationName) {
		super();
		this.bookID=bookID;
		this.price=price;
		this.noOfCopiesSold=noOfCopiesSold;
		this.authorName=authorName;
		this.bookName=bookName;
		this.publicationName=publicationName;
		
		
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNoOfCopiesSold() {
		return noOfCopiesSold;
	}
	public void setNoOfCopiesSold(int noOfCopiesSold) {
		this.noOfCopiesSold = noOfCopiesSold;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getPublicationName() {
		return publicationName;
	}
	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}
			
}