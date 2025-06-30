package chapter06;

import java.util.Scanner;

/*
 * 학생 한명의 국어, 영어, 수학 점수를 입력받아 출력하는 로직
 */

public class F066ScoreV01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int[] scoreList = new int[5];
		String name = null;
		String[] subjectList = {"국어", "영어", "수학"};
		
		// 1. 데이터 입력
		System.out.println("학생명 > ");
		name = scan.next();

		int tot = 0;
		int avg = 0;
		
		for(int i = 0; i < scoreList.length; i++) {
			if (i < scoreList.length-2) {
				System.out.print(subjectList[i] + " 점수 > ");
				scoreList[i] = scan.nextInt();
				tot += scoreList[i];
				
			} else {
				scoreList[scoreList.length-2] = tot; // scoreList[0] + scoreList[1] + scoreList[2];
				scoreList[scoreList.length-1] = avg = tot/subjectList.length; // (scoreList[0] + scoreList[1] + scoreList[2])/3;
				i = scoreList.length; // 종료 시점을 잡아주거나 브레이크 선언하면 빠져나옴, break;
			}
		}
		
//		System.out.println("점수 > ");
//		scoreList[1] = scan.nextInt();
//		
//		System.out.println("점수 > ");
//		scoreList[2] = scan.nextInt();
		
		// 2. 데이터 출력 : 학생명, 점수(국어, 영어, 수학)
		System.out.println("학생명\t\t국어\t영어\t수학\t총점\t평균");
		System.out.print(name +"\t\t");
		for(int score : scoreList) {
			System.out.print(score + "\t");
		}
		
	}

}

//package chapter06;
//
//import java.util.Scanner;
//
///*
// * 학생 한명의 국어, 영어, 수학 점수를 입력받아 출력하는 로직
// */
//
//public class ScoreTestVer1 {
//
//	public static void main(String[] args) {
//		
//		Scanner scan = new Scanner(System.in);
//
//		int[] scoreList = new int[5];
//		String[] subjectList = {"국어", "영어", "수학", "자바"};
//		
//		// 1. 데이터 입력
//		System.out.println("학생명 > ");
//		name = scan.next();
//
//		for(int i = 0; i < subjectList.length; i++) {
//			if (i < subjectList.length-2) {
//				System.out.print(subjectList[i] + " 점수 > ");
//				scoreList[i] = scan.nextInt();
//			} else {
//				break;
//			}
//		}
//		
////		System.out.println("점수 > ");
////		scoreList[1] = scan.nextInt();
////		
////		System.out.println("점수 > ");
////		scoreList[2] = scan.nextInt();
//		
//		// 2. 데이터 출력 : 학생명, 점수(국어, 영어, 수학 자바, 총점, 평균)
//		System.out.println("학생명\t\t국어\t영어\t수학\t자바\t총점\t평균");
//		System.out.print(name +"\t\t");
//		for(int score : scoreList) {
//			System.out.print(score + "\t");
//		}
//		
//	}
//
//}

