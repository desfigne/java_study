package part02_follow.chapter12_basicapi;

public class C1202_String02_Buffer {

	public static void main(String[] args) {

		String str = "홍길동"; // 주소값 x100(가칭)
		str = str + "은 자바를"; // 주소값 x200(가칭)으로 새로 생성, 접합연산자
		str = str + " 열심히 공부한다."; // 주소값x300(가칭)으로 새로 생성
		System.out.println(str);
		
		// 스트링버퍼는 새로 생성하지 않고 기존 주소값에 스트링 배열이 요청한 수만큼(디폴트 16) 생성되어 계속 유지되면서 채워지는 구조
		// 실제 내용이 들어가는게 아닌 주소값이 들어감
		
		StringBuffer sb = new StringBuffer(); // 디폴트값 16개
		sb.append("홍길동");
		sb.append("은 자바를");
		sb.append(" 열심히 공부한다.");
		System.out.println(sb.capacity());
		System.out.println(sb.toString());
		System.out.println(sb);

	}

}
