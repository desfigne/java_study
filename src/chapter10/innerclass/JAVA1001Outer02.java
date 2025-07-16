package chapter10.innerclass;

public class JAVA1001Outer02 {

	public static void main(String[] args) {

		JAVA1001Outer01 outer = new JAVA1001Outer01();
		System.out.println("outer.name --> " + outer.name);
		
//		Inner inner = new JAVA1001Outer.Inner(); // 아우터가 없으면 호출이 안됨
		JAVA1001Outer01.Inner inner = new JAVA1001Outer01.Inner(); // static이 없어서 메모리에 올라가지 않아 불러올 수 없음
		System.out.println("inner.name --> " + inner.name);
		System.out.println("Outer.Inner.name --> " + JAVA1001Outer01.Inner.name); // 이너 안의 스트링에 스태틱이 없어 호출 안됨

	}

}
