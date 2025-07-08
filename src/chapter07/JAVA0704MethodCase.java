package chapter07;

public class JAVA0704MethodCase {
	// Field
	
	
	// Constructor
	// 리턴타입 X, 매개변수 X
    public void method1() {
        System.out.println("method1 --> 리턴타입 X, 매개변수 X");
    }
	
    // 리턴타입 O, 매개변수 X
    public int method2() {
	    int num1 = 10;
	    int num2 = 20;
	    
	    return num1+num2;  // 리턴 처리안하면 무조건 에러
	}
	
    // 리턴타입 X, 매개변수 O : 매개변수의 타입과 갯수에 따라 메소드 오버로딩(Overloading) 구현이 가능
    public void method3(int num1, int num2) {
        System.out.println("method3 --> " + (num1 + num2));
    }
	
    public void method3(String name) {
    	System.out.println("method3 --> " + name);
    }
    
    //리턴타입 O, 매개변수 O
	public int method4(int num1, int num2) {
	   return num1 + num2;
    }
		
	public String method4(String name) {
	   return name;
    }
	
	// Main Method
	public static void main(String[] args) {
		JAVA0704MethodCase mc = new JAVA0704MethodCase();
		mc.method1();
		int sum = mc.method2();
		mc.method2(); // 단순이 30이라는 버퍼값으로 유지 후 종료됨
//        System.out.println("method2 --> " + mc.method2());
        System.out.println("method2 --> " + sum);
        
        mc.method3(10, 20);
		mc.method3("홍길동");
		
		System.out.println("method4 --> " + mc.method4(10, 20));
		System.out.println("method4 --> " + mc.method4("홍길동"));
		
	}
}
