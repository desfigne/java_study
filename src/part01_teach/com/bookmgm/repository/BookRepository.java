package part01_teach.com.bookmgm.repository;

import java.util.List;

import part01_teach.com.bookmgm.model.Book;

public interface BookRepository {
	boolean insert(Book book);
	List<Book> selectAll();
	Book select(String id);
	void update(Book book);
	void remove(String id);
	void remove(Book book);
	int getCount();
}
