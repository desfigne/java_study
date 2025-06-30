package chapter06;

public class F061Array02 {

	public static void main(String[] args) {
		
//		// names 문자열 변수 선언 및 생성
//		String[] names;
//		String names2[];
//		
//		names = new String[3];
//		names2 = new String[5];
//		
//		int[] scores = new int[10];
//		int scores2[] = new int[3];
//		int scores3[] = { 10, 20, 30 };
//		String[] names3 = { "홍길동" , "홍길순" };
		
		String names[];
		String[] names2;
		
		names = new String[2];
		names2 = new String[5];
		names[0] = "홍길동";
		
		int[] scores = new int[3];
		scores[0] = 100;
		scores[1] = 200;
		scores[2] = 300;  // 1차원 배열
		int scores2[] = new int[3];
		int scores3[] = { 10, 20 };
		
		names[1] = "이순신";
		
		System.out.println(scores); // 주소값이 해시코드로 변환되어 표시됨
		System.out.println(names[0]);
		System.out.println(names2[0]);
		System.out.println(scores[0]);
		System.out.println(scores2[0]);
		System.out.println(scores3[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		
		// 주소값의 위치는 무조건 0번지부터 1번지 ... 식으로 순서가 정해짐 (모든 언어가 동일함)
		// heap 영역에서는 null(초기화[값])을 자동으로 부여
		// 시작 주소가 0, 마지막 번호는 크기의 -1
		// 클래스값은 숫자가 아닌 null 값으로 초기화됨
		
	}

}
