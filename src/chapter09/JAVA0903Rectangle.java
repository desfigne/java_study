package chapter09;

public class JAVA0903Rectangle extends JAVA0901Shape implements JAVA0902Interface {
	
//	String color;
	int width;
	int height;
	
	public JAVA0903Rectangle(String color, int width, int height) {
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
