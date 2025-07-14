package chapter08.java0805Inheritance;

public class I02Circle extends I01Shape {
	
	String color;
	int radius;
	public static final double PI = 3.14;
	
	public I02Circle(String color, int radius) {
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
