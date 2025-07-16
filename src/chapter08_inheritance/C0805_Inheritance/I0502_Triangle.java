package chapter08_inheritance.C0805_Inheritance;

public class I0502_Triangle extends I0501_Shape {
	
	String color;
	
	public I0502_Triangle(String color) {
		this.color = color;
	};

	@Override
	public void draw() {
		System.out.println(color + " 삼각형을 그린다.");
	};
	
	@Override
	public double getArea() { return 0.0; }; // 내가 사용하지 않더라도 오버라이드 해야 한다.

}
