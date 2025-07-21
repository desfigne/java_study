package part02_follow.chapter04_perators;

/*
 * 증감 연산자 : ++, --
 */

public class C0401_Op04_Increment {

	public static void main(String[] args) {
		int number = 10;
		
		System.out.println(++number); //11
		System.out.println(number++); //프린트는 11, 메모리에는 12
		System.out.println(number); //12
		
		System.out.println(--number); //11
		System.out.println(number--); //프린트는 11, 메모리에는 10
		System.out.println(number); //10

	}

}
