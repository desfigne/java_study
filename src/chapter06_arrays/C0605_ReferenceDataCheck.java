package chapter06_arrays;  
// 패키지 선언: 클래스를 논리적으로 묶어 네임스페이스를 구성합니다.

import java.util.Scanner;  
// Scanner 클래스 임포트: 키보드 입력 처리를 위한 유틸리티

/**
 * 기본형(primitive)과 참조형(reference) 데이터의 메모리 구조 및 비교 방식을 실습하는 예제입니다.
 * - 기본형 변수는 스택(stack)에 값을 직접 저장합니다.
 * - 참조형 변수는 힙(heap) 또는 문자열 상수 풀(constant pool)의 객체 주소를 저장합니다.
 */
public class C0605_ReferenceDataCheck {

    public static void main(String[] args) {

        // --- 1. 기본형 데이터(Primitive Type) ---
        // 스택에 값 10을 직접 저장
        int a = 10;                                // 기본형 정수 변수 선언
        int b = 10;                                // 기본형 정수 변수 선언

        // --- 2. 참조형 데이터(Reference Type, String 리터럴) ---
        // 문자열 리터럴은 상수 풀(Constant Pool)에 한 번만 저장
        String str1 = "홍길동";                     // 상수 풀에 저장된 객체 참조
        String str2 = "홍길동";                     // str1과 동일한 상수 풀 주소 참조
        String str3 = "홍길똥";                     // 다른 문자열이므로 별도 상수 풀에 저장

        // (예시) 기본형 값 출력 비교
        // System.out.println(a + " == " + b);     // 주석 처리된 기본형 비교 예시

        // 참조형 주소 비교: System.identityHashCode()로 실제 메모리 주소 기반 해시코드 확인
        System.out.println(System.identityHashCode(str1));  
        System.out.println(System.identityHashCode(str2));  
        System.out.println(System.identityHashCode(str3));  

        System.out.println(" a == b : " + (a == b));  
        System.out.println(" str1 == str2 : " + (str1 == str2));  

        // --- 3. 참조형 데이터(Reference Type, new 연산자 사용) ---
        // new 키워드로 매번 힙(heap)에 새로운 String 객체 생성
        String strObj1 = new String("홍길동");        // 힙에 새 객체 생성
        String strObj2 = new String("홍길동");        // 또 다른 객체 생성

        // (예시) hashCode() vs identityHashCode()
//      System.out.println(strObj1.hashCode());      // 내용 기반 해시코드 출력 예시
//      System.out.println(strObj2.hashCode());      // 내용 기반 해시코드 출력 예시

        System.out.println(System.identityHashCode(strObj1));  
        System.out.println(System.identityHashCode(strObj2));  

        System.out.println(" strObj1 == strObj2 : " + (strObj1 == strObj2));  
        System.out.println(" strObj1.equals(strObj2) : " + strObj1.equals(strObj2));  

        // --- 4. 참조 재할당(Reference Reassignment) ---
        // strObj1이 상수 풀의 str1을 참조하도록 변경
        strObj1 = str1;                            
        System.out.println(strObj1);               
        System.out.println(System.identityHashCode(strObj1));  

        // --- 5. Scanner를 이용한 사용자 입력 비교 ---
        Scanner scan = new Scanner(System.in);     // Scanner 객체 생성: 표준 입력(키보드)
        System.out.print("문자열 입력 > ");          
        String sdata = scan.next();               // next()는 공백 전까지 읽음

        System.out.println(sdata);                 
        System.out.println(" sdata == str1 : " + (sdata == str1));  
        System.out.println(" sdata.equals(str1) : " + sdata.equals(str1));  
        System.out.println(" str1.equals(sdata) : " + str1.equals(sdata));  

        scan.close();                             // Scanner 자원 반환
    }
}
//
//
//
//  학습 포인트
//
//  1. 기본형 vs 참조형 저장 구조
//   - 기본형(primitive)은 스택에 값 자체를 저장합니다.
//   - 참조형(reference)은 힙 또는 상수 풀의 객체 주소를 스택에 저장합니다.
//
//  2. 문자열 리터럴 상수 풀
//   - 동일한 문자열 리터럴은 한 번만 생성되어 모든 변수가 같은 풀 주소를 참조합니다.
//   - new String()은 항상 새로운 힙 객체를 생성합니다.
//
//  3. 비교 연산자 차이
//   - '==' 연산자는 기본형 값 비교, 참조형 주소 비교에 사용됩니다.
//   - equals() 메서드는 객체 내용(값) 비교에 사용됩니다.
//   - hashCode()는 객체 내용 기반 해시코드, identityHashCode()는 실제 메모리 주소 기반 해시코드입니다.
//
//  4. 참조 재할당
//   - 변수에 다른 객체의 주소를 할당하면 두 변수가 같은 객체를 참조합니다.
//
//  5. 사용자 입력 비교
//   - Scanner.next()로 받은 문자열은 상수 풀이 아닌 힙 객체이므로 '==' 비교는 false가 될 수 있습니다.
//   - 문자열 비교는 항상 equals()를 사용해야 합니다.
//
//  6. 자원 관리 및 예외 처리 고려
//   - Scanner 사용 후 close()로 자원을 반환해야 합니다.
//   - scan.nextInt(), scan.next() 호출 시 InputMismatchException을 try-catch로 처리하면 안정성이 높아집니다.
//
//
//