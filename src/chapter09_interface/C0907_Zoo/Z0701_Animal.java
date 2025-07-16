package chapter09_interface.C0907_Zoo;

/**
 * 동물의 공통적인 속성
 * name, age
 */
public class Z0701_Animal implements Z0702_Interface {
	
	String name;
	int age;
	
	public Z0701_Animal() {}
	
	public Z0701_Animal(String name, int age) {
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
