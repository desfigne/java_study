package part02_follow.chapter06_arrays;  
// 패키지 선언: 클래스를 논리적으로 묶어 네임스페이스를 구성합니다.

import java.util.Scanner;  
// Scanner 클래스 임포트: 사용자 입력(키보드) 처리를 위한 유틸리티

/**
 * 배열 객체 생성 및 참조 구조 실습 예제
 * - 기본형 배열, 리터럴 초기화 배열, 참조형 배열 생성을 학습합니다.
 * - Call by value(값 복사)와 Call by reference(주소 복사) 차이를 확인합니다.
 */
public class C0601_Array04 {

    public static void main(String[] args) {
        // --- 1. 다양한 타입의 배열 선언 및 초기화 ---
        int[] numberList = new int[5];  
        // 기본형(int) 배열 생성: 길이 5, 기본값 0
        
        String[] nameList = { "홍길동", "홍길순", "김유신" };  
        // 리터럴 초기화된 String 배열: 길이 3, 지정한 문자열로 초기화
        
        boolean[] flagList = new boolean[2];  
        // boolean 배열 생성: 길이 2, 기본값 false

        // --- 2. 참조형 객체 배열 생성 및 Scanner 객체 저장 ---
        // Scanner 객체를 3개 저장할 배열 선언
        Scanner[] scanList = new Scanner[3];  
        
        // 각 요소에 Scanner 객체 생성 후 주소 저장
        scanList[0] = new Scanner(System.in);  
        scanList[1] = new Scanner(System.in);
        scanList[2] = new Scanner(System.in);

        // 배열 길이 출력: 배열.length로 길이 확인
        System.out.println("numberList.length = " + numberList.length);
        System.out.println("nameList.length   = " + nameList.length);
        System.out.println("flagList.length   = " + flagList.length);
        System.out.println("scanList.length   = " + scanList.length);

        // Scanner 참조 주소 출력: toString()이나 hashCode()로 객체 식별
        System.out.println("scanList[0] = " + scanList[0]);
        System.out.println("scanList[1] = " + scanList[1]);
        System.out.println("scanList[2] = " + scanList[2]);

        // ------------------------------------------------------------------
        // 아래는 실습 중에 제시된 **주석 처리된 코드 예시**입니다.
        // 메모리 구조 이해를 돕기 위해 복원하고, 학습용 주석을 추가했습니다.
        // ------------------------------------------------------------------
	
        /*
        // [메모리 모델] JVM 메모리 구조
        // 1) Stack: scanList 변수(참조 배열) 생성
        // 2) Heap : scanList 크기(3)만큼 Scanner 참조 공간 생성
        // 3) Heap : 각 scanList[i]에 new Scanner(System.in) 객체 주소 저장
        //
        // -- 해설 --
        // 참조 복사(Call by reference): 배열 요소에 다른 인덱스의 참조를 대입하면
        // 두 요소가 같은 객체를 참조하게 됩니다.
        */
        
        // --- 4. Call by reference 예시 ---
        // swap 방식이 아닌 참조 복사
        scanList[0] = scanList[2];
        // 이제 scanList[0]과 scanList[2]는 동일한 Scanner 객체 참조

        System.out.println("After reference assignment:");
        System.out.println("scanList[0].hashCode() = " + scanList[0].hashCode());
        System.out.println("scanList[1].hashCode() = " + scanList[1].hashCode());
        System.out.println("scanList[2].hashCode() = " + scanList[2].hashCode());

        // --- 5. 기본형 배열에서 값 복사 예시(Call by value) ---
        int[] nList = new int[3];  
        nList[0] = 10;
        nList[1] = 20;
        nList[2] = 30;

        // 값 복사: 오른쪽 값을 왼쪽 요소에 직접 대입
        nList[0] = nList[2];
        // 이제 nList[0]에는 nList[2]의 값(30)이 저장됨

        // hashCode()는 참조형 객체 메서드이므로 기본형 배열 요소에 호출 불가
        // System.out.println(nList[0].hashCode()); // 컴파일 에러

        // --- 6. 배열 요소 출력 ---
        System.out.println("nList[0] = " + nList[0]);
        System.out.println("nList[1] = " + nList[1]);
        System.out.println("nList[2] = " + nList[2]);

        // --- 7. 자원 해제 ---
        // Scanner는 close() 호출로 자원 반환
        scanList[1].close();
        scanList[2].close();
        // scanList[0]과 scanList[2]는 동일 객체이므로 중복 호출 주의
    }
}
//
//
//
//  학습 포인트
//
//  1. 배열 선언 및 초기화 방법
//   - new T[length] vs. 리터럴 초기화 { ... } 차이 이해
//
//  2. 기본형(int) vs. 참조형(Scanner) 배열
//   - 기본형 배열 요소는 값 자체를 저장(Call by value)
//   - 참조형 배열 요소는 객체 주소를 저장(Call by reference)
//
//  3. Call by value vs. Call by reference
//   - 값 복사는 데이터 자체를 복사, 주소 복사는 참조만 복사
//
//  4. 배열 길이 및 요소 접근
//   - 배열.length 속성으로 안전한 반복문 작성
//
//  5. 자원 관리
//   - Scanner 객체 사용 후 반드시 close()로 자원 반환
//
//
//