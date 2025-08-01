package c13_collectionframework.C1305_com.bookmgm.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import c13_collectionframework.C1305_com.bookmgm.model.Book;

public class Yes24BookRepository implements BookRepository{
	List<Book> library = new ArrayList<Book>();
	
	public Yes24BookRepository() {
		System.out.println("** 예스24 도서관 생성 완료 **");
	}
	
	// 생성 직후 빨간 줄은 리턴 타입으로 선언이 필요해 발생
	@Override
	public boolean insert(Book book) {
		if(book != null) {
			return library.add(book);
		} else {
			return false;
		}
	};
	
	@Override
	public List<Book> selectAll() {
//		return new ArrayList<Book>();
		return library;
	};
	
	@Override
	public Book select(String id) {
		Book book = null;
		
		for(Book b : library) {
//			if(b.getId().equals(id)) book = b; // 모두 돌기 때문에 브레이크를 추가해주는게 더 올바름
			if(b.getId().equals(id)) {
				book = b;
				break;
			}
		}
		
//		return new Book();
		return book;
	};
	
	@Override
	public void update(Book book) {
		int idx = -1;
		int i = 0;
		
		for(Book b : library) {
			if(b.getId().equals(book.getId())) {
				idx = i;
			}
			i++;
		}
		library.set(idx, book);
	};
	
	@Override
	public void remove(String id) {
		Iterator<Book> ie = library.iterator();
		while(ie.hasNext()) {
			Book book = ie.next();
			if(book.getId().equals(id)) ie.remove();
		}
	};
	
	@Override
	public void remove(Book book) {
		Iterator<Book> ie = library.iterator();
		while(ie.hasNext()) {
			Book b = ie.next();
			if(b == book) ie.remove();
		}
	};
	
	@Override
	public int getCount() {
		return library.size();
	};

}
