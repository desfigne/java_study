package chapter09_interface.C0907_Zoo;

import java.util.ArrayList;
import java.util.List;

public class Z04_Zoo {

	public static void main(String[] args) {

//		Z03Lion lion = new Z03Lion(); // 심바, 5
//		lion.sleep();
//		lion.eat();
//		
//		Z02Interface lion2 = new Z03Lion("심바아빠", 10);
//		lion2.sleep();
//		lion2.eat();
		
		List<Z03_Lion> list = new ArrayList<Z03_Lion>(); // 라이언 단일만 리스트에 포함됨
		List<Z02_Interface> list2 = new ArrayList<Z02_Interface>(); // 라이언, 타이거 모두 리스트에 포함됨
		
		Z03_Lion lion1 = new Z03_Lion();
		Z03_Tiger tiger1 = new Z03_Tiger();
		list.add(lion1);
//		list.add(tiger1);  // list는 Z03Lion 클래스 객체만 저장 가능, 리스트 정의는 라이언만 한정되어 있기에 타이거는 안들어감
		
		list2.add(lion1);  // 자동(묵시적) 형변환을 통해 list2에 저장
		list2.add(tiger1); // 자동(묵시적) 형변환을 통해 list2에 저장
		
		list.get(0).sleep();
		
		list2.get(0).sleep();
		list2.get(1).sleep();
		
//		list2.get(1).getName();
//		list2.get(1).getAge();
		
		System.out.print(list2.get(0).getName() + " ");
		System.out.print(list2.get(0).getAge() + " ");
		System.out.print(list2.get(1).getName() + " ");
		System.out.print(list2.get(1).getAge() + "\n");

//		list2.get(0).name; // 인터페이스를 통해서 가져오기 때문에 이름이라는 정보는 없음, 에러 발생
		Z03_Lion lion2 = (Z03_Lion)list2.get(0); // 객체의 저장된 속성(값)은 강제(명시적) 형변환을 통해 진행
		System.out.println("lion2.name --> " + lion2.name);

	}

}
