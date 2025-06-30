package chapter06;

public class ArrayTest05 {
	
	public static void main(String[] args) {
		
		int[] nlist = new int[3];
//		nlist = "1"; // Type mismatch 발생, 정수를 넣어야 하는데 문자열 들어감
//		nlist[0] = "1"; // Type mismatch 발생, 정수를 넣어야 하는데 문자열 들어감
//		nlist[3] = 99; // Runtime시에 ArraIndexOutOfException 발생, 실행 전에는 에러가 안나고 런타임(실행) 후 에러 표시, 배열 에러는 주로 이 현상
		nlist[2] = 99;
		
		System.out.println(nlist.hashCode());
		
//		for(int i=0; i<5; i++) {
//			System.out.println(nlist[i]);
//		}

		for(int i=0; i<nlist.length; i++) {
			System.out.println(nlist[i]);
		}
	}

}
