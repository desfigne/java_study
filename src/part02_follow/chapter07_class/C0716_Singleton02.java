package part02_follow.chapter07_class;

public class C0716_Singleton02 {

	public static void main(String[] args) {

		// Field
		
		
		// Constructor
//		JAVA0716Singleton singleton = new JAVA0716Singleton(); // 기본 생성자가 private으로 접근제어 됨
		
		C0716_Singleton01 singleton = C0716_Singleton01.getInstance();
		singleton.setName("싱글톤");
		System.out.println("name : " + singleton.getName());
		
		// Method
		

	}

}
