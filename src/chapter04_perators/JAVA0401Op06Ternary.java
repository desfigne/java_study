package chapter04_perators;

import java.util.Scanner;

/*
 * 삼항 연산자 : (조건식[비교연산자]) ? 결과1(True) : 결과2(False) ;
 */

public class JAVA0401Op06Ternary {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("점수 > ");
		int score = input.nextInt();
		
		// score가 60점 이상이면 "합격", 이하면 "불합격"임, 해당 결과를 result 변수에 대입함
		String result = (score >= 60) ? "합격" : "불합격";
		System.out.println("result : " + result);
	}

}
