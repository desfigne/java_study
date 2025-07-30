package c09_interface;

public class C0903_Circle extends C0901_Shape implements C0902_Interface { // 상속은 단일만 가능하며 클래스만 가능
	
//	String color;
	int radius;
	public static final double PI = 3.14;
	
	public C0903_Circle(String color, int radius) {
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
