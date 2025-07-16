package chapter08_inheritance.C0805_Inheritance;

public class I0502_Rectangle extends I0501_Shape {
	
	String color;
	int width;
	int height;
	
	public I0502_Rectangle(String color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
	};

	@Override
	public void draw() {
		System.out.println(color + " 사각형을 그린다.");
	};
	
	@Override
	public double getArea() {
		return width * height;
	};

}
