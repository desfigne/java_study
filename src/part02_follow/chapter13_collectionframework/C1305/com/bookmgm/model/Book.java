package part02_follow.chapter13_collectionframework.C1305.com.bookmgm.model;

public class Book {
	private String id;
	private String name;
	private String author;
	private int price;
	
	// 생성자 생략, 기본 생성자 사용됨
	
	// getter, setter 설정
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
