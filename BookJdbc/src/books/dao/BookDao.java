package books.dao;

import java.util.List;

import books.model.Book;

public interface BookDao {
	public void delById();
	public void showtable();
	public void updatePriceById();
	public void insert();
}