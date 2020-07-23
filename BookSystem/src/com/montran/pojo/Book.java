
package com.montran.pojo;

public class Book {
	private int bookId;
	private String bookName;
	private double bookPrice;
	public Book(int bookId2, String bookName2, double bookPrice2) {
		bookId = bookId2;
		bookName = bookName2;
		bookPrice = bookPrice2;
	}
	
	public Book() {
		bookId = 0;
		//bookName = bookName2;
		//bookPrice = bookPrice2;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return  "     "+ bookId  +"    "+ bookName  +"     "+ bookPrice+   "     ";
	}
	
	
	
}

