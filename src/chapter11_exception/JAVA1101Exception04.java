package chapter11_exception;

import java.util.Scanner;

/**
 * Exception 객체 생성 > 다른 메소드에게 예외처리를 넘김
 */
public class JAVA1101Exception04 {
	
//	// checkAge 메소드
//	public static void checkAge(int age) {
//		try {
//			if(age < 0) {
//				throw new Exception("나이는 0보다 커야 합니다."); // 일부러 익셉션이 발생하도록 만듬
//			} else {
//				System.out.println("age : " + age);
//			}
//		} catch (Exception e) {
//			System.out.println("age 값은 0보다 커야 합니다.");
//			e.printStackTrace();
//		}
//	}
	
	// checkAge 메소드
	public static void checkAge(int age) throws Exception {
			if(age < 0) {
				throw new Exception("나이는 0보다 커야 합니다."); // 일부러 익셉션이 발생하도록 만듬
			} else {
				System.out.println("age : " + age);
			}
	}

	// throws로 넘겨도 끝인 메인까지만 넘어와서 메인에서 트라이 캐치로 처리
	// 그러나 업무는 자신이 처리하는게 옳음, 넘기는 것은 올바르지 않음
	// 메인으로 거슬러 올라가면 부하가 메인으로 몰리기 때문에 쓰레드가 데드할 수 있어 각각의 해당 메소드에서 바로바로 트라이 캐치로 처리하는 것이 낫고 올바름
	public static void main(String[] args) throws Exception {
		
		// 키보드를 통해 나이를 입력받아 체크함
		Scanner scan = new Scanner(System.in);
		System.out.print("나이 > ");
		int age = scan.nextInt();
		
		try {
			checkAge(age);
		} catch (Exception e) {
			System.out.print("Exception : age는 0보다 커야 합니다.");
		} finally {
			scan.close();
			System.out.println(" -- 프로그램 종료 -- ");
		}
		
	}

}
