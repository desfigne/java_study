package chapter10_outerandinner;

public class C1001_Outer02 {

	public static void main(String[] args) {

		C1001_Outer01 outer = new C1001_Outer01();
		System.out.println("outer.name --> " + outer.name);
		
//		Inner inner = new JAVA1001Outer.Inner(); // 아우터가 없으면 호출이 안됨
		C1001_Outer01.Inner inner = new C1001_Outer01.Inner(); // static이 없어서 메모리에 올라가지 않아 불러올 수 없음
		System.out.println("inner.name --> " + inner.name);
		System.out.println("Outer.Inner.name --> " + C1001_Outer01.Inner.name); // 이너 안의 스트링에 스태틱이 없어 호출 안됨

	}

}