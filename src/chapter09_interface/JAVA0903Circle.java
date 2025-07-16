package chapter09_interface;

public class JAVA0903Circle extends JAVA0901Shape implements JAVA0902Interface { // 상속은 단일만 가능하며 클래스만 가능
	
//	String color;
	int radius;
	public static final double PI = 3.14;
	
	public JAVA0903Circle(String color, int radius) {
		super(color);
//		this.color = color;
		this.radius = radius;
	};

	@Override
	public void draw() {
		System.out.println(color + " 원을 그린다.");
	}
	
	@Override
	public double getArea() {
		return PI * radius * radius;
	}

}
