package chapter08_inheritance.C0805_Inheritance;

abstract public class C080501_Shape {
	
//	public static String color; // <- 이렇게 사용하고자 할 경우 : shape.color, 필드는 자식 클래스에 지정하는걸 권장

	abstract public void draw();
	abstract public double getArea();

}
