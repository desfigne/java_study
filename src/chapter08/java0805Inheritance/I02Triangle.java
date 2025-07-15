package chapter08.java0805Inheritance;

public class I02Triangle extends I01Shape {
	
	String color;
	
	public I02Triangle(String color) {
		this.color = color;
	};

	@Override
	public void draw() {
		System.out.println(color + " 삼각형을 그린다.");
	};
	
	@Override
	public double getArea() { return 0.0; }; // 내가 사용하지 않더라도 오버라이드 해야 한다.

}
