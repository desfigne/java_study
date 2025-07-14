package chapter08.java0806Interface;

public class I04Rectangle extends I01Shape implements I02Interface {
	
//	String color;
	int width;
	int height;
	
	public I04Rectangle(String color, int width, int height) {
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
