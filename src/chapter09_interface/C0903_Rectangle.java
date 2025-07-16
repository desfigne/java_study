package chapter09_interface;

public class C0903_Rectangle extends C0901_Shape implements C0902_Interface {
	
//	String color;
	int width;
	int height;
	
	public C0903_Rectangle(String color, int width, int height) {
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
