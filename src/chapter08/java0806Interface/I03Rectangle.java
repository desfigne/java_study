package chapter08.java0806Interface;

public class I03Rectangle extends I01Shape implements I06Interface {
	
//	String color;
	int width;
	int height;
	
	public I03Rectangle(String color, int width, int height) {
		super(color);
//		this.color = color;
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
