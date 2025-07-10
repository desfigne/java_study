package chapter07;

/*
 * 싱글톤 디자인 패턴 적용
 */
public class JAVA0716Singleton {
	
	// Field
	private static JAVA0716Singleton singleton = new JAVA0716Singleton();
	private String name;
	
	// Constructor : new Singleton();
	private JAVA0716Singleton() {
		
	}
	
	// Method
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static JAVA0716Singleton getInstance() { // 객체 생성 없이 호출하는 방법 : static
		return singleton;
	}

}
