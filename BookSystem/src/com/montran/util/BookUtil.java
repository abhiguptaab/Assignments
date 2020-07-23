package com.montran.util;

import com.montran.pojo.Book;

public class BookUtil {

	private Book[] books;
	public int index = 0;
	public int maxBookNo;
	
	public BookUtil(int numberOfBooks) {
		books = new Book[numberOfBooks];
		maxBookNo = numberOfBooks;
	}
	
	public boolean addNewBook(Book book) {
		
		if(index >= 0 && index < maxBookNo) {
			books[index] = book;
			index++;
			return true;
		}
		
		return false;
	}
	
	public boolean addAllBooks(Book[] bookadd) {
		for(int i=0 ; i < bookadd.length; i++) {
			books[index] = bookadd[i];
			index++;
		}
		return true;
	}
	
	
	public boolean updateBook(int Bookid, String newName, double newPrice) {
		boolean bookfound = false;
		for(int i =0 ; i<books.length; i++) {
				if(books[i] != null&&books[i].getBookId() == Bookid) {
					bookfound = true;System.out.println(bookfound);
					books[i].setBookId(Bookid);
					books[i].setBookName(newName);
					books[i].setBookPrice(newPrice);
					break;	
			}
		}
		if(bookfound == true)
			return true;
		return false;
	}
	
	public boolean deleteBook(int Bookid) {
		boolean bookfound = false;
		for(int i =0 ; i<books.length; i++) {
			if(books[i].getBookId() == Bookid && books[i] != null) {
				bookfound = true;
				books[i] = null;
				--index;
				break;
			}
		}
		if(bookfound == true)
			return true;
		
		return false;
	}
	
	public Book getBookbyBookId(int Bookid) {
		boolean bookfound = false;
		Book book = new Book();
		//book = null;
		//int i =0;
		for(int i =0 ; i<books.length; i++) {
		//while(i< books.length){
			if(books[i] != null && books[i].getBookId() == Bookid ) {
				bookfound = true;
				book = books[i];
				break;
			}
			//if(books[i] != null)
				//i++;
		}// End of while
		
		if(bookfound == true)
			return book;
		
		return null;
	}
	
	public Book[] getAllBooks() {
		return books;
	}
}
