package chapter07_class.C0717_javadoc;

/**
 * JavaDoc 문서를 생성하는 클래스입니다.
 * 이클립스 최상단 메뉴 (Project) > (Generate Javadoc..)으로 진입
 */

public class C071701_JavaDoc01 {
	
	private String name;
	private int age;
	
	/**
	 * 기본 생성자입니다.
	 */
	public C071701_JavaDoc01() {}
	
	/**
	 * 문자열 타입의 name 파라미터를 받아 객체를 생성합니다.
	 * @param name 이름
	 */
	public C071701_JavaDoc01(String name) {
		this.name = name;
	}
	
	/**
	 * 문자열 타입의 name, 정수형 타입의 age 파라미터를 받아 객체를 생성합니다.
	 * @param name 이름
	 * @param age  나이
	 */
	public C071701_JavaDoc01(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * 문자열 타입의 이름을 반환합니다.
	 * @return name 이름
	 */
	public String getName() {
		return name;
	}

	/**
	 * 문자열 타입의 이름을 받아 맴버변수 name을 초기화합니다.
	 * @param name 이름
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 정수 타입의 나이를 반환합니다.
	 * @return age 나이
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 정수 타입의 나이를 받아 맴버변수 age를 초기화합니다.
	 * @return age 나이
	 */
	public void setAge(int age) {
		this.age = age;
	}

	
}
