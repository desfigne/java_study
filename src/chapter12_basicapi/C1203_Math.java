package chapter12_basicapi;

public class C1203_Math {

	public static void main(String[] args) {

		System.out.println("Math.abs : " + Math.abs(-100));
		System.out.println("Math.floor : " + Math.floor(123.4567)); // 자체적 반올림은 되어지지 않음
		System.out.println("Math.max : " + Math.max(100, 200));
		System.out.println("Math.min : " + Math.min(100, 200));
		System.out.println("Math.random : " + Math.random());
		System.out.println("Math.random : " + Math.random() * 100); // 정수 2자리 랜덤으로 호출, 0부터 99 사이값
		System.out.println("Math.random : " + Math.floor(Math.random() * 100)); // 정수 2자리 랜덤으로 호출, 0부터 99 사이값
		System.out.println("Math.random : " + (int)Math.floor(Math.random() * 100)); // 정수 2자리 랜덤으로 호출, 0부터 99 사이값
		System.out.println("Math.random : " + Math.round(Math.random() * 100)); // 강사님 내용 확인
		
		// 랜덤으로 쇼핑몰 주문번호 생성할 때 활용

	}

}
