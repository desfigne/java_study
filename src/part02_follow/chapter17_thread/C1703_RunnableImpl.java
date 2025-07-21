package part02_follow.chapter17_thread;

public class C1703_RunnableImpl implements Runnable{
	
	public C1703_RunnableImpl() { // 임플리먼츠에서는 네임과 겟네임이 없어 이 코드 안에서 선언 후 사용 필요
		
	}
	
	@Override
	public void run() {

//		// 1에서 10까지 출력
//		for(int i=0; i<=10; i++) {
//			System.out.println("Runnable -----> " + i);
//		}
		
		// 1에서 10까지 출력
		for(int i=0; i<=10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("Runnable -----> " + i);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
