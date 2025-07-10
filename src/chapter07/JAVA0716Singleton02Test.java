package chapter07;

public class JAVA0716Singleton02Test {

	public static void main(String[] args) {

		// Field
		
		
		// Constructor
//		JAVA0716Singleton singleton = new JAVA0716Singleton(); // 기본 생성자가 private으로 접근제어 됨
		
		JAVA0716Singleton singleton = JAVA0716Singleton.getInstance();
		singleton.setName("싱글톤");
		System.out.println("name : " + singleton.getName());
		
		// Method
		

	}

}
