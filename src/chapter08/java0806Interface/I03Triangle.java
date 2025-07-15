package chapter08.java0806Interface;

public class I03Triangle extends I01Shape implements I02Interface {
	
//	String color;
	
	public I03Triangle(String color) {
		super(color);
//		this.color = color;
	};

	@Override
	public void draw() {
		System.out.println(color + " 삼각형을 그린다.");
	};
	
	@Override
	public double getArea() { return 0.0; }; // 내가 사용하지 않더라도 오버라이드 해야 한다.

}
