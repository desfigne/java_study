package c12_basicapi;

public class C1202_String01 {
	
	public static void main(String[] args) {
		
		String name1 = "홍길동"; // 기본 데이터 타입으로 사용, 컨스턴스 풀에 상수로 정의됨
		String name2 = new String("홍길동"); // new 로 힙에 생성, 주소값을 비교하는 것과 같음, 값을 가져오려면 이퀄스 사용 필요
		String num = String.valueOf(123);
		name2 = "Welcome to JAVA";
		String name3 = "W-elcome to JAVA";
		String[] sname2 = name2.split("-");
		String[] sname3 = name3.split("-");
		
		String phone = "010-1234-5678";
		String subject = "java,css,html,mysql";
		String[] phones = phone.split("-");           // < 분리할 경우
		String[] subjects = subject.split(",");       // >
		
//		String jphone = String.join(",", phones);     // < 반대로 사용할 경우 조인 사용
		String jphone = String.join("-", phones);     // >
		
		System.out.println(subject.contains("dddd")); // 포함되어 있지 않다면 펄스
		System.out.println(subject.contains("html")); // 포함되어 있다면 트루
		System.out.println(jphone);
		System.out.println(subjects[0]); // java
		System.out.println(phones[0]); // 010
		System.out.println(sname2[0]);
		System.out.println(sname3[0]);
		System.out.println(name2.substring(7, 10)); // 7, 8, 9까지만 나옴
//		System.out.println(name2.substring(7)); // 0번지부터 카운트해 7번지 배열부터 호출
		System.out.println(name2.length());
		System.out.println(name2.toUpperCase());
		System.out.println(name2.toLowerCase());
		System.out.println(num+10); // 123 + 10으로 133이 되어야 하나 123이 문자이기 때문에 12310 이렇게 표시됨
		System.out.println(name1.hashCode());
		System.out.println(System.identityHashCode(name1));
		
		System.out.println(name2.hashCode());
		System.out.println(System.identityHashCode(name2));
		
		if(name1 == name2) System.out.println("동일");
		else System.out.println("다름");

		if(name1.equals(name2)) System.out.println("동일");
		else System.out.println("다름");
	}

}
