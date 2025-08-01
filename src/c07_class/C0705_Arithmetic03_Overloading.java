package c07_class;

public class C0705_Arithmetic03_Overloading {
	
	// Field
	
	
	// Constructor
	
	
	// Method
	
	// add() 메소드의 오버로딩
	public int add(int x, int y) {
		return x + y;
	}
	public int add(double x, int y) { // 타입이 달라 중복 빨강 표시 없음
		return (int)(x + y);
	}
	public int add(String x, String y) { // add("1", "2")
		int xx = Integer.valueOf(x);
		int yy = Integer.valueOf(y);
		
		return xx + yy;
	}
	
	// 파라미터의 갯수에 상관없이 입력받는 경우 : add(1, 2, 3, 4, 5); add(4, 5, 56, 76, 8, 9, 9);
	// 가변 매개변수를 이용하여 메소드 정의 : ...
	public int add(int ... numbers) {
//		return numbers.length;
		int sum = 0;
		for (int number : numbers) {
			sum += number;  // sum = sum + number
		}
		return sum;
	}
	
	public int add(String ... numbers) {
//		return numbers.length;
		int sum = 0;
		for (String number : numbers) {
			sum += Integer.valueOf(number);  // sum = sum + number
		}
		return sum;
	}
}
