package chapter11;

public class Test {

	public static void main(String[] args) {
		try {
			test1();	
			System.out.println("4");
		} catch (Exception e) {
			System.out.println("5");
		}
	}
	
	public static void test1() throws Exception{
		try {
			test2();		
			System.out.println("1");
		} catch (NullPointerException e) {
			System.out.println("2");			
		} finally {
			System.out.println("3");		
		}
		throw new Exception();
	}
	
	public static void test2() {
		throw new NullPointerException();
	}

}
