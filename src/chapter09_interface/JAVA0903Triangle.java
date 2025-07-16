package chapter09_interface;

public class JAVA0903Triangle extends JAVA0901Shape implements JAVA0902Interface {
	
//	String color;
	
	public JAVA0903Triangle(String color) {
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
