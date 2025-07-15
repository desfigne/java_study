package chapter09.java0908Drink;

public interface Menu { // 인터페이스도 상속 가능해서 익스텐즈 추가 가능
	
	int getNo(); // 상속 받기 때문에 퍼블릭을 제외해도 됨
	String getName();
	int getPrice();
	
}
