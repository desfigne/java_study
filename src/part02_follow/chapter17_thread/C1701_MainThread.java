package part02_follow.chapter17_thread;

public class C1701_MainThread {

	public static void main(String[] args) { // Main Thread
		
		// 1에서 10까지 정수 출력
		for(int i=0; i<=10; i++) {
			System.out.println(i);
		}
		
		C1702_ThreadExtend te = new C1702_ThreadExtend(); // te thread : 독립된 실행 - 메인 쓰레드의 간섭을 받지 않고 각자 실행 후 종료
		te.start(); // 02 쓰레드의 run()을 실행하도록 함
		
//		C1703_RunnableImpl ri = new C1703_RunnableImpl(); // start가 나오지 않음
		Thread t = new Thread(new C1703_RunnableImpl()); // t thread : 독립된 실행 - 메인 쓰레드의 간섭을 받지 않고 각자 실행 후 종료
		t.start();
		
		// 메인 쓰레드와 별개로 각각의 쓰레드에게 책상을 주고 일하고 퇴근하라함
		
		System.out.println("-- Main 메소드 종료 --"); // 메인 쓰레드가 종료되도 독립적인 쓰레드는 작동 완료 후 종료됨, 프로그램이 2개 돈 것과 같은 개념
		
	}

}
