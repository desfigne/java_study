package chapter09_interface;

public class JAVA0905ObjectTypeCasting {

	public static void main(String[] args) {

		JAVA0903Circle yellowC = new JAVA0903Circle("노랑", 1);
		JAVA0903Rectangle blueR = new JAVA0903Rectangle("파랑", 1, 2);
		JAVA0901Shape s = new JAVA0903Circle("초록색", 2); // 자동(묵시적) 형변환
//		I04Rectangle t = new Circle("초록색", 2); // 사각형 안에는 서클이 포함되어 있지 않음
		// 부모의 내용을 물려받고 확장되는 형태이다보니 자식 클래스가 더 큼
		// 자식의 주소값으로 들어가서 호출된 부분만 활성화시킴, 나머지 자식 안의 내용은 호출되지 않아 엑세스 할 수 없음
//		I03Circle cs = s;
		JAVA0903Circle cs = (JAVA0903Circle)s; // 강제(명시적) 형변환 O
		
		JAVA0901Shape s2 = new JAVA0901Shape("빨강"); // 쉐입으로 스택에 생성되고 쉐입만 구성됨
//		I03Circle cs2 = (I03Circle)s2; // 강제(명시적) 형변환 X / s2 = 쉐입 안에는 서클에 해당하는 내용이 없어 에러가 발생됨
//		I04Rectangle r = (I04Rectangle)s; // 강제(명시적) 형변환 X / 생성된 같은 모습의 자식만 가능, s = 쉐입 안에는 사각형에 해당하는 내용이 없어 에러가 발생됨
		
		// > 위의 내용들은 모두 문법적으로 개념은 가능하지만 사용하지는 않음
		
		
		
		// < 아래 내용들은 인터페이스를 통해 자식의 모습으로 객체를 구현하는 것을 권장 (실무에서 사용)
		
		JAVA0902Interface si = new JAVA0903Circle("코랄", 1);
		si.draw(); // 인터페이스 안의 draw()가 아닌 자식인 Circle의 draw()가 호출됨
		System.out.println(si.getArea());
		System.out.println();
		JAVA0903Circle cs3 = (JAVA0903Circle)si;
		cs3.draw();
		System.out.println(cs3.getArea()); // 객체지향은 데이터가 중심이 아니라 메소드의 흐름으로 진행을 지향
		
		
		cs.draw();
//		cs2.draw();
		
		yellowC.draw();
		blueR.draw(); // draw에 접근 가능
//		s.draw(); // Shape 클래스는 draw() 메소드를 정의하지 않음, draw에 접근 불가
//		s.color; // 프로텍티드로 인해 접근 불가가 아닌 이클립스가 단순 호출은 의미가 없다 알리며 빨간 줄 표시됨
		System.out.println(s.color);
		
		// 상속받은 인터페이스 통한 객체 생성 - 사각형, 삼각형 : 인터페이스 기반 설계
		JAVA0902Interface si2 = new JAVA0903Rectangle("파란색", 10, 11);
		JAVA0902Interface si3 = new JAVA0903Triangle("민트색");
		// (추상 메소드)	-- 다형성 구현 --	(상속받아 오버라이딩)
		// 위의 추상 메소드를 상속받아 오버라이딩하는 것이 객체지향의 다형성
		// 위의 구조로 코드를 짜야 아주 정확함, api에 이런 구조로 짜여있음
		
		si2.draw();
		si3.draw();
		
	}

}
