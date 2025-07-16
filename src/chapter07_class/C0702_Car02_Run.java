package chapter07_class;

public class C0702_Car02_Run {

	public static void main(String[] args) {

		// 1. 객체 생성
		C0702_Car01 avante = new C0702_Car01();
		C0702_Car01 ev6 = new C0702_Car01();
		
		// 2. 객체 데이터 할당
		avante.name = "아반테";
		avante.company = "현대자동차";
		avante.price = 1000;
		
		ev6.name = "EV6";
		ev6.company = "현대자동차";
		ev6.price = 2000;
		
		// 3. 메소드 호출
		System.out.println("********************************\n");
		System.out.println("\tCar Information\n");
		System.out.println("********************************\n");
		
		// 각 메소드 호출 종료 시 main으로 돌아가는 복귀주소(리턴어드레스)를 갖는다.
		avante.showInfo();
		ev6.showInfo();
		
		System.out.println("\n********************************\n");
		System.out.println("-- main 메소드 종료 --");

	}

}
