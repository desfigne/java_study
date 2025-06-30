package chapter06;

public class ArrayTest03 {

	public static void main(String[] args) {

		// 1에서 5까지의 데이터를 저장 후 순서대로 출력 > 스택에 저장 5개, 스택에 변수가 남아있어 효율성 측면에서 안좋음
		
		int n1 = 1;
		int n2 = 2;
		int n3 = 3;
		int n4 = 4;
		int n5 = 5;
		
//		System.out.println(n1);
//		System.out.println(n2);
//		System.out.println(n3);
//		System.out.println(n4);
//		System.out.println(n5);
		
//		int[] numbers = new int [5]; // 스택에 저장은 1개만 저장

//		System.out.println(numbers[0]);
//		System.out.println(numbers[1]);
//		System.out.println(numbers[2]);
//		System.out.println(numbers[3]);
//		System.out.println(numbers[4]); // 출력하면 초기화값 0 표시됨
		
//		numbers[0] = 1;
//		numbers[1] = 2;
//		numbers[2] = 3;
//		numbers[3] = 4;
//		numbers[4] = 5;
		
//		System.out.println(numbers[0]);
//		System.out.println(numbers[1]);
//		System.out.println(numbers[2]);
//		System.out.println(numbers[3]);
//		System.out.println(numbers[4]); // 출력하면 초기화값 0 표시됨
		
		// 정확하게 값을 알고 있는 상태이므로 for 문을 사용
		
//		for (int i = 0; i < 5; i++) {
//			numbers[i] = i + 1; // numbers[0] = 1; ...
//		}
//		
//		System.out.println(numbers[0]);
//		System.out.println(numbers[1]);
//		System.out.println(numbers[2]);
//		System.out.println(numbers[3]);
//		System.out.println(numbers[4]); // 출력하면 초기화값 0 표시됨
		
		
//		int[] numbers = new int [100];
//
//		// 데이터 저장
//		for (int i = 0; i < 100; i++) {
//			numbers[i] += i;
//		}
//		
//		// 데이터 출력
//		for (int i = 0; i < 100; i++) { // for 블럭 안의 정의라 겹치지 않아 에러 나지 않음
//			System.out.println(numbers[i]);
//		}
		
		
		int[] numbers = new int [200]; // 배열의 전체 크기 : 변수명.length

		// 데이터 저장
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] += i;
		}
		
		// 데이터 출력
		for (int i = 0; i < numbers.length; i++) { // for 블럭 안의 정의라 겹치지 않아 에러 나지 않음
			System.out.println(numbers[i]);
		}
		
	}

}
