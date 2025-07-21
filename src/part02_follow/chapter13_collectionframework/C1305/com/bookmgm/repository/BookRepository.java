package part02_follow.chapter13_collectionframework.C1305.com.bookmgm.repository;

import java.util.List;

import part02_follow.chapter13_collectionframework.C1305.com.bookmgm.model.Book;

public interface BookRepository {
	boolean insert(Book book); // 모델부터 만듬
	List<Book> selectAll();
	Book select(String id);
	void update(Book book);
	void remove(String no);
	void remove(Book book);
	int getCount();
}
