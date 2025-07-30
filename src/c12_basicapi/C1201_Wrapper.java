package c12_basicapi;

public class C1201_Wrapper {
	
	public static void main(String[] args) {
		
		int num1 = 100;
		Integer num2 = new Integer(num1); // Deprecated, 앞으로 사용하지 않을 예정으로 권장하지 않는 표시
		Integer num3 = Integer.valueOf(num1); // 권장함
		int num4 = Integer.parseInt("123");
		double dnum = Double.valueOf("123.60");

		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(dnum);
		
	}

}
