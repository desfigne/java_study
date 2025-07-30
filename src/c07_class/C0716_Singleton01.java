package c07_class;

/*
 * 싱글톤 디자인 패턴 적용
 */
public class C0716_Singleton01 {
	
	// Field
	private static C0716_Singleton01 singleton = new C0716_Singleton01();
	private String name;
	
	// Constructor : new Singleton();
	private C0716_Singleton01() {
		
	}
	
	// Method
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static C0716_Singleton01 getInstance() { // 객체 생성 없이 호출하는 방법 : static
		return singleton;
	}

}
