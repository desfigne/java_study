package chapter06_arrays;  
// 패키지 선언: 클래스를 논리적으로 묶어 네임스페이스를 구성합니다.

public class JAVA0601Array02 {
    // 클래스 선언: 1차원 배열 선언 방식 및 기본 동작을 실습하는 예제

    public static void main(String[] args) {
        // --- 1. 배열 선언 문법 비교 ---
        // String[] names;    // 권장: 타입[] 변수명
        // String names2[];   // 가능하나 가독성 측면에서 권장하지 않음
        String names[];      // 배열 참조 변수 선언
        String[] names2;     // 배열 참조 변수 선언

        // --- 2. 배열 생성(크기 할당) ---
        names = new String[2];   // 길이 2인 String 배열 생성 (요소는 null로 초기화)
        names2 = new String[5];  // 길이 5인 String 배열 생성

        // --- 3. 배열 요소에 값 할당 ---
        names[0] = "홍길동";     // 첫 번째 요소에 문자열 저장
        names[1] = "이순신";     // 두 번째 요소에 문자열 저장

        // --- 4. 기본형 배열 선언 및 초기화 ---
        int[] scores    = new int[3];       // 길이 3인 int 배열 생성 (요소는 0으로 초기화)
        int scores2[]   = new int[3];       // 동일한 선언 방식
        int scores3[]   = { 10, 20 };       // 리터럴 초기화: 길이 2, 값 10,20 설정

        // 기본형 배열 요소에 값 할당
        scores[0] = 100;
        scores[1] = 200;
        scores[2] = 300;

        // --- 5. 배열 정보 및 요소 출력 ---
        System.out.println("scores 배열 객체: " + scores);
        // toString() 호출 시 배열 참조 주소(해시코드) 형태로 출력됨

        System.out.println("names[0]   = " + names[0]);
        System.out.println("names2[0]  = " + names2[0]);
        // names2 요소는 초기값 null

        System.out.println("scores[0]  = " + scores[0]);
        System.out.println("scores2[0] = " + scores2[0]);
        // scores2 요소는 초기값 0

        System.out.println("scores3[0] = " + scores3[0]);
        System.out.println("scores[1]  = " + scores[1]);
        System.out.println("scores[2]  = " + scores[2]);

        // --- 6. 배열 내부 동작 해설 ---
        /*
        // 1) 선언된 배열의 시작 인덱스는 0, 마지막 인덱스는 length-1입니다.
        // 2) 참조형 배열 요소는 기본값 null로 초기화됩니다.
        // 3) 기본형 배열 요소는 타입별 기본값(숫자→0, boolean→false)으로 초기화됩니다.
        // 4) 배열 객체를 println()에 전달하면 toString()이 아닌 
        //    "[타입@해시코드]" 형식의 참조 정보가 출력됩니다.
        */
    }
}
//
//
//
//  학습 포인트
//
//  1. 배열 선언 문법
//   - 타입[] 변수명 vs. 변수명[]: 가독성 및 일관성 고려하여 전자를 권장합니다.
//
//  2. 배열 생성 시 초기값
//   - 참조형은 null, 숫자형은 0으로 자동 초기화됩니다.
//
//  3. 배열 참조 출력
//   - System.out.println(배열) → "[타입@해시코드]" 형태로 표시됨.
//
//  4. 인덱스 범위 관리
//   - 유효 인덱스: 0 ≤ i < 배열.length; 벗어나면 ArrayIndexOutOfBoundsException 발생.
//
//  5. 선언과 초기화 분리 vs. 리터럴 초기화
//   - new T[n] 방식: 동적 크기 지정 가능
//   - { ... } 리터럴: 선언과 동시에 값 지정, 크기 고정
//
//
//