package chapter08_inheritance.C0805_Inheritance;

public class C080502_Circle extends C080501_Shape {
	
	String color;
	int radius;
	public static final double PI = 3.14;
	
	public C080502_Circle(String color, int radius) {
		this.color = color;
		this.radius = radius;
	};

	@Override
	public void draw() {
		System.out.println(color + " 원을 그린다.");
	};
	
	@Override
	public double getArea() {
		return PI * radius * radius;
	};

}
