package chapter08;

public class JAVA0803Animal extends JAVA0801Client{
	
////	String name;
//	int age;

	JAVA0802Person owner;
	String name;
	int age;
	
	public JAVA0803Animal() {
		this("예삐", 3, null);
//		System.out.println("Animal 기본 생성자 호출");
	}
	
	public JAVA0803Animal(String name, int age, JAVA0802Person owner) {
		this.name = name; // 자식의 필드를 없애서 부모 필드를 넣는 것은 권장하지 않고 super()를 이용해 부모 필드에 넣는 것을 권장함
		this.age = age;
		this.owner = owner;
	}
	
	// Sound()
	public void sound() {
		System.out.println(name + " 짖는다."); // 상속받은 부모의 값을 가져온다. 같은 메모리 상에 있어야 접근이 가능함
	}
	
//	public void animalRegister() {
//		System.out.println("접수한다.");
//	}
	
	@Override
	public void register() {
		System.out.println(owner.name + " 고객이 접수한다.");
	}
	
	@Override
	public void payment() {}
	
	// 고객 정보 출력시 owner 정보 포함하고 싶은 경우
	
	@Override
	public void printInfo() { // 부모가 가진 메소드를 똑같은 모습으로 가져옴 - 오버라이딩(Overriding)
		System.out.print("고객(Animal)정보 --> ");
		System.out.print(name + ", ");
		System.out.print(age + ", ");
		System.out.print(owner.name + ", ");
		System.out.print(owner.address + ", ");
		System.out.print(owner.phone + "\n");
	}
	
}
