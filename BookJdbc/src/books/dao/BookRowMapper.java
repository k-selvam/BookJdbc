package books.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import books.model.Book;


public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String author = rs.getString("author");
		int price = rs.getInt("price");
		Book newBook = new Book(id,name,author,price);

		return newBook;
	}



}