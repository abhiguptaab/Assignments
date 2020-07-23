package com.montran.main;
import java.util.*;

import com.montran.pojo.Book;
import com.montran.util.BookUtil;
public class BookMain {

	public static void main(String[] args) {
		
		
		int bookId;
		String bookName;
		double bookPrice;
		int bookSpace; // Size of Book Array]
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Number of Books Space");
		bookSpace = sc.nextInt();
		BookUtil bookutil = new BookUtil(bookSpace);
		
		System.out.println("No Books Present right Now");
		int userchoice;
		
		while(true){
			System.out.println("-------Menu------");
			System.out.println("1. Add Single Book");
			System.out.println("2. Add Multiple Books");
			System.out.println("3. Update existing Book");
			System.out.println("4. Delete existing Book");
			System.out.println("5. Print Single Book Details");
			System.out.println("6. Exit");
			
			System.out.println("Enter Your Choice");
			userchoice = sc.nextInt();
			
			switch (userchoice) {
			case 1:
				System.out.println("Accept Bookid");
				bookId = sc.nextInt();
				System.out.println("Accept Name");
				bookName = sc.nextLine();
				bookName = sc.nextLine();
				System.out.println("Accept price");
				bookPrice = sc.nextDouble();
				Book book = new Book(bookId, bookName, bookPrice);
				bookutil.addNewBook(book);
				break;
			case 2:
				System.out.println("How Many Books Do You Want to add?");
				int numberAddBook = sc.nextInt();
				for(int i=0; i<numberAddBook; i++) {
					System.out.println("Accept  id");
					bookId = sc.nextInt();
					System.out.println("Accept Name");
					bookName = sc.nextLine();
					bookName =sc.nextLine();
					System.out.println("Accept  price");
					bookPrice = sc.nextDouble();
					Book[] books = new Book[numberAddBook];
					books[i] = new Book(bookId, bookName, bookPrice);
					bookutil.addAllBooks(books);
				}
				break;
			
			case 3:
				System.out.println("Accept Bookid from user");
				int bookid = sc.nextInt();
				Book checkbook = bookutil.getBookbyBookId(bookid);
				if(checkbook == null) {
					System.out.println("Book is not present");
				}
				System.out.println("Accept new Bookid");
				int newbookId = sc.nextInt();
				System.out.println("Accept new name");
				String newbookName = sc.nextLine();
				sc.nextLine();
				System.out.println("Accept new  price");
				double newbookPrice = sc.nextDouble();
				//Book book = new Book(bookId, bookName, bookPrice);
				bookutil.updateBook(newbookId, newbookName, newbookPrice);
					
				break;
				
				
			case 4:
				System.out.println("Accept Bookid from user");
				int bookiddelete = sc.nextInt();
				Book checkbookid = bookutil.getBookbyBookId(bookiddelete);
				if(checkbookid == null) {
					System.out.println("Book is not resent");
				}
				
				bookutil.deleteBook(bookiddelete);
				//Book book = new Book(bookId, bookName, bookPrice);
				//bookutil.updateBook(newbookId, newbookName, newbookPrice);
				break;
				
			case 5:
				System.out.println("Accept Bookid from user");
				int bookidshow = sc.nextInt();
				Book bookidcheck = bookutil.getBookbyBookId(bookidshow);
				System.out.println(bookidcheck);
				if(bookidcheck == null) {
					System.out.println("Book is not resent");
				}
				//System.out.println("Accept new Bookid, na");
				//int newbookIdshow = sc.nextInt();
				//bookutil.getBookbyBookId(newbookIdshow);
				//Book book = new Book(bookId, bookName, bookPrice);
				//bookutil.updateBook(newbookId, newbookName, newbookPrice);
				break;
				//break;
				
			case 6:
				break;
				
			default:
				System.out.println("Invalid Choice");
			}
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" Book Table ");
			System.out.println("   Book ID    +   book name    +    book price");
			System.out.println("------------------------------------------------");
			
			Book[] showbooks = bookutil.getAllBooks();
			for(int i=0; i<showbooks.length; i++) {
				if(showbooks[i] != null)
				{
					System.out.println(showbooks[i]);
				}
					
			}
			
			
			System.out.println("Do you want to continue yes/ no?");
			String choice = sc.next();
			if(choice == "no")
				break;
		}// End of while
		
		System.out.println();

	}

}
