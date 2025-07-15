package chapter08.java0807Zoo;

/**
 * 동물의 공통적인 속성
 * name, age
 */
public class Z01Animal implements Z02Interface {
	
	String name;
	int age;
	
	public Z01Animal() {}
	
	public Z01Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void sleep() {
		System.out.println(name + "가(이) 잠을 잔다.");
	}

	@Override
	public void eat() {
		System.out.println(name + "가(이) 먹는다.");
	}

}
