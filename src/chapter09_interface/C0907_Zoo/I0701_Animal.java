package chapter09_interface.C0907_Zoo;

/**
 * 동물의 공통적인 속성
 * name, age
 */
public class I0701_Animal implements I0702_Interface {
	
	String name;
	int age;
	
	public I0701_Animal() {}
	
	public I0701_Animal(String name, int age) {
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
