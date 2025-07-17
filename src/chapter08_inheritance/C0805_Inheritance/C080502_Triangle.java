package chapter08_inheritance.C0805_Inheritance;

public class C080502_Triangle extends C080501_Shape {
	
	String color;
	
	public C080502_Triangle(String color) {
		this.color = color;
	};

	@Override
	public void draw() {
		System.out.println(color + " 삼각형을 그린다.");
	};
	
	@Override
	public double getArea() { return 0.0; }; // 내가 사용하지 않더라도 오버라이드 해야 한다.

}
