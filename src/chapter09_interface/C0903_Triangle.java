package chapter09_interface;

public class C0903_Triangle extends C0901_Shape implements C0902_Interface {
	
//	String color;
	
	public C0903_Triangle(String color) {
		super(color);
//		this.color = color;
	};

	@Override
	public void draw() {
		System.out.println(color + " 삼각형을 그린다.");
	};
	
	@Override
	public double getArea() { return 0.0; }; // 내가 사용하지 않더라도 오버라이드 해야 한다.

}
