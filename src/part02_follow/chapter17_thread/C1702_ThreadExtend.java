package part02_follow.chapter17_thread;

public class C1702_ThreadExtend extends Thread {
	
	public C1702_ThreadExtend() {
		super("쓰레드1");
	}
	
	@Override
	public void run() {
		
//		// 1에서 10까지 출력
//		for(int i=0; i<=10; i++) {
//			System.out.println(getName() + " -----> " + i);
//		}
		
		// 1에서 10까지 출력
		for(int i=0; i<=10; i++) {
//			sleep(1000); //1초 sleep, 익셉션 발생시 Try catch로 잡아주면 됨
			try {
				sleep(1000);
				System.out.println(getName() + " -----> " + i);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
	}

}
