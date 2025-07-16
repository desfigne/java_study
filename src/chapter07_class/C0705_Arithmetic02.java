package chapter07_class;

public class C0705_Arithmetic02 {

	public static void main(String[] args) {

		C0705_Arithmetic01 arithmetic = new C0705_Arithmetic01();
		C0705_Arithmetic03_Overloading arithmetic_ol = new C0705_Arithmetic03_Overloading();

		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add(10, 20));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add(3.14, 10));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add("100", "200"));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add(1,2,3,4,5,6,7,8,9,10));
		System.out.println("arithmetic_ol.add = " + arithmetic_ol.add("1","2","3","4","5","6","7","8","9","10"));
		
		System.out.println("----------------------------------------");
//		arithmetic.add(10, 20);
//		arithmetic.sub(10, 20);
//		arithmetic.mul(10, 20);
//		arithmetic.div(10, 20);
//		arithmetic.mod(10, 20); // 안나옴	
		
		int add = arithmetic.add(10.7, 20.8);
		int sub = arithmetic.sub(100, 20);
		double mul = arithmetic.mul(3.14, 10); // 결과는 실수 값
		int div = arithmetic.div(10, 20);
		int mod = arithmetic.mod(10, 20);
		
		System.out.println("add = " + add);
		System.out.println("sub = " + sub);
		System.out.println("mul = " + mul);
		System.out.println("div = " + div);
		System.out.println("mod = " + mod);

	}

}
