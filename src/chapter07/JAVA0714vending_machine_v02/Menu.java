package chapter07.JAVA0714vending_machine_v02;

public class Menu {
    // 1. 필드 선언: 메뉴 번호(no), 메뉴명(name), 가격(price)
	int no;
	int price;
	String name;

    // 2. 기본 생성자
    public Menu() {
        // 아무 값도 넣지 않고 객체만 생성할 때 사용
    }

    // 3. 모든 필드를 초기화하는 생성자
    public Menu(int no, String name, int price) {
        // 1) 전달받은 값으로 필드 초기화
    	this.no = no;
    	this.name = name;
    	this.price = price;
    }

    // 4. 메뉴 번호 반환하는 getter 메소드
    public int getNo() {
        // 1) no 필드 값 반환
        return no;
    }

    // 5. 메뉴명 반환하는 getter 메소드
    public String getName() {
        // 1) name 필드 값 반환
        return name;
    }

    // 6. 가격 반환하는 getter 메소드
    public int getPrice() {
        // 1) price 필드 값 반환
        return price;
    }
}
