package chapter09_interface;

public class JAVA0904Inheritance {

	public static void main(String[] args) {
		
//		I02Circle redC = new I02Circle("빨강색"); // 추가된 파라미터 반영해야 오류 사라짐
//		I02Circle blueC = new I02Circle("파랑색");
//		I03Rectangle yellowR = new I03Rectangle("노랑색");
//		I03Rectangle greenR = new I03Rectangle("초록색");
//		I04Triangle orangeT = new I04Triangle("주황색");
		
		JAVA0903Circle redC = new JAVA0903Circle("빨강색", 12);
		JAVA0903Circle blueC = new JAVA0903Circle("파랑색", 11);
		JAVA0903Rectangle yellowR = new JAVA0903Rectangle("노랑색", 10, 12);
		JAVA0903Rectangle greenR = new JAVA0903Rectangle("초록색", 11, 13);
		JAVA0903Triangle orangeT = new JAVA0903Triangle("주황색");
		
		redC.draw();
		System.out.println("redC.getArea : " + redC.getArea());
		
		blueC.draw();
		System.out.println("blueC.getArea : " + blueC.getArea());
		
		yellowR.draw();
		System.out.println("yellowR.getArea : " + yellowR.getArea());
		
		greenR.draw();
		System.out.println("greenR.getArea : " + greenR.getArea());
		
		orangeT.draw();
		System.out.println("orangeT.getArea : " + orangeT.getArea());
		

	}

}
