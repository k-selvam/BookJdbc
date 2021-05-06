package books;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import books.dao.BookDao;
import books.dao.BookDaoImpl;
import books.model.Book;

public class TestBooks {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("books.xml");
		BookDao bookDao = (BookDao) context.getBean("bookDao");
		
		System.out.println("Welcome to books \n");
		boolean flag = true;
		while(flag) {
			Scanner scan = new Scanner(System.in);
			System.out.print("\n\nselect 1.insert a book, 2.delete a book by id ,3.show the books table ,4. update the price of the book by Id ,0.to quit : ");
			int choice = scan.nextInt() ;
			switch (choice) {
			case 1: {
				bookDao.insert();
				break;
			}
			
			case 2:{
				bookDao.delById();
				break;
			}
			
			case 3:{
				bookDao.showtable();
				break;
			}
			
			case 4:{
				bookDao.updatePriceById();
				break;
			}
			
			case 0:{
				System.out.println("\nNo Action performed");
				flag = false;
				break;
			}
			
			default:
				System.out.println("\nInvalid Choice\nEnter correct option");
			}
		}
	}
}