package books.dao;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import books.model.Book;


@Repository("bookDao")
public class BookDaoImpl implements BookDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate ;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	Scanner scan = new Scanner(System.in);
		
	

	public void insert() {
		System.out.println("\n id:");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.println("book name:");
		String name = scan.nextLine();
		
		System.out.println("author name:");
		String author = scan.nextLine();
		
		System.out.println("price of book:");
		int price = scan.nextInt();
		
		Book b1 = new Book(id,name,author,price);
		
		String sql = "insert into book values (?,?,?,?)";
		Object[] objects= {b1.getId(),b1.getName(),b1.getAuthor(),b1.getPrice()};

		int no_rows_inserted =	jdbcTemplate.update(sql,objects);
		System.out.println("\nno of rows inserted  is "+ no_rows_inserted);
		
	}

	
	public void delById() {
		System.out.println("\nenter the id of book you want to delete");
		int id = scan.nextInt();
		String sqldel="delete from book where id = ?";
		int noRecordDeleted = jdbcTemplate.update(sqldel,id);
		System.out.println("no of records deleted is " +noRecordDeleted );
		
	}

	public void showtable() {
		String sql = "select * from book";
		List<Book> books = jdbcTemplate.query(sql, new BookRowMapper());
		printStudents(books);
	}
	
	
	private void printStudents(List<Book> books) {
		for(Book b : books) {
			System.out.println(b);
		}
	}

	public void updatePriceById() {
		System.out.println("\n enter the id of the book");
		int id = scan.nextInt();
		System.out.println("enter the updated price");
		int updatePrice = scan.nextInt();
		String sql = "update book set price = ? where id = ?";
		int noRecordUpdated = jdbcTemplate.update(sql,updatePrice,id);
		System.out.println("no of records updated is " +noRecordUpdated );
		
		
	}
}