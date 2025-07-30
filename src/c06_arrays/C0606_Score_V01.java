package c06_arrays; 
// 패키지 선언: 클래스를 논리적으로 묶어 네임스페이스를 구성합니다.

import java.util.Scanner;     
// Scanner 클래스 임포트: 콘솔 입력(키보드) 처리를 위한 유틸리티

/**
 * 한 학생의 국어, 영어, 수학 점수를 입력받아
 * 총점과 평균을 계산한 뒤 결과를 출력하는 예제입니다.
 * 주석 처리된 다양한 코드 예시들을 포함하여
 * 실습 학습 포인트를 풍부하게 설명합니다.
 */
public class C0606_Score_V01 {

    public static void main(String[] args) {
        // Scanner 객체 생성: System.in(표준 입력) 스트림에서 읽기 위한 도구
        Scanner scan = new Scanner(System.in);

        // 점수 저장 배열 선언:
        // [0]=국어, [1]=영어, [2]=수학, [3]=총점, [4]=평균
        int[] scoreList = new int[5];

        // 학생 이름 저장 변수
        String name;

        // 과목명 배열: 입력 안내나 출력 시 활용
        String[] subjectList = { "국어", "영어", "수학" };

        // --- 1. 데이터 입력 ---
        System.out.print("학생명 > ");
        name = scan.next();  
        // next()는 공백 전까지 문자열 읽음. 공백 포함 이름 지원 시 nextLine() 사용 고려.

        int total = 0;    // 총점 누적 변수
        int average = 0;  // 평균 저장 변수

        // 기본 for문을 이용한 입력·계산 로직
        for (int i = 0; i < scoreList.length; i++) {
            if (i < subjectList.length) {
                // i = 0,1,2 -> 과목 점수 입력 단계
                System.out.print(subjectList[i] + " 점수 > ");
                scoreList[i] = scan.nextInt();   // 점수 입력
                total += scoreList[i];           // 누적 총점 계산
            } else {
                // i = 3 -> 총점·평균 저장 단계
                scoreList[3] = total;  
                average = total / subjectList.length;
                scoreList[4] = average;
                break;  // break를 사용해 빠르게 for문 종료
            }
        }

        // ------------------------------------------------------------------
        // 아래는 실습 중에 제시된 **주석 처리된 코드 예시**입니다.
        // 더 나은 구조나 확장 학습을 위해 복원하고, 학습용 주석을 추가했습니다.
        // ------------------------------------------------------------------

        /*
        // [예시 1] 기존 개별 입력 방식
        // System.out.println("점수 > ");            
        // scoreList[1] = scan.nextInt();          
        // System.out.println("점수 > ");
        // scoreList[2] = scan.nextInt();
        //
        // -- 해설 --
        // 위 코드는 각각 영어, 수학 점수를 개별적으로 입력받는 방식입니다.
        // 반복문을 사용하지 않으면 코드가 중복되고 과목 수가 늘어날수록 확장성이 떨어집니다.
        */

        /*
        // [예시 2] 과목 배열에 '자바' 과목을 추가한 버전
        // String[] subjectList = {"국어", "영어", "수학", "자바"};
        // int[] scoreList = new int[6]; // 자바 과목 추가로 배열 크기 6 필요
        //
        // // 입력 루프 예시
        // for(int i = 0; i < subjectList.length; i++) {
        //     if (i < subjectList.length - 2) {
        //         System.out.print(subjectList[i] + " 점수 > ");
        //         scoreList[i] = scan.nextInt();
        //     } else {
        //         // 총점·평균 계산은 별도로 처리해야 함
        //         break;
        //     }
        // }
        // 
        // // 확장된 출력 헤더
        // System.out.println("학생명\t국어\t영어\t수학\t자바\t총점\t평균");
        //
        // -- 해설 --
        // 과목이 추가되면 반복문의 경계와 총점·평균 저장 위치를 함께 조정해야 합니다.
        // 배열 크기를 동적으로 계산하거나 List 컬렉션을 사용하면 유연성을 높일 수 있습니다.
        */

        scan.close();  // Scanner 자원 반환: 메모리 누수 방지를 위해 반드시 호출

        // --- 2. 결과 출력 ---
        System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
        System.out.print(name + "\t");
        // 향상된 for문: 배열 요소 순회하여 출력
        for (int score : scoreList) {
            System.out.print(score + "\t");
        }
        System.out.println();  // 줄바꿈
    }
}
//
//
//
//	학습 포인트
//
//	1. 반복문 vs. 개별 입력 코드
//	 - 반복문을 활용하면 코드 중복을 줄이고, 과목 수 변경 시 유지보수가 용이합니다.
//	 - 주석 처리된 개별 입력 방식은 소규모 예제에서는 간단하지만, 과목이 많아지면 관리가 어려워집니다.
//	
//	2. 배열 크기 관리
//	 - 과목 개수와 총·평균 저장 공간을 분리해 이해하기 쉽게 설계했습니다.
//	 - 과목 추가 시 배열 크기(new int[subjectList.length + 2])를 계산식으로 지정하면 확장성을 높일 수 있습니다.
//	
//	3. break와 조건문
//	 - break를 통해 불필요한 반복을 조기 종료하며 코드 흐름을 명확히 합니다.
//	 - 조건문으로 입력 단계와 계산 단계를 분리해 가독성을 유지했습니다.
//	
//	4. 자원 관리
//	 - 입력 스트림(Scanner)은 사용 후 반드시 close()하여 자원을 해제해야 합니다.
//	
//	5. 예외 처리 고려
//	 - scan.nextInt() 호출 시 비숫자 입력에 대비해 try-catch(InputMismatchException e)를 추가하면 실무 수준의 안정성을 갖출 수 있습니다.
//	
//	6. 학습용 주석 활용법
//	 - 핵심 키워드, 메서드, 제어문마다 /** 설명 */ 또는 // 주석을 달아 주요 역할을 정리합니다.
//	 - 주석 처리된 코드 예시를 복원해 비교 학습하도록 하면 실습 효과가 증대됩니다.
//
//
//