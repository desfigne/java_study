package c06_arrays;  
// 패키지 선언: 클래스를 논리적으로 묶어 네임스페이스를 구성합니다.

/**
 * 배열 참조 변수 선언 및 초기화 실습 예제
 * - 지역변수(int[] arrInt)는 선언만 하면 JVM이 자동 초기화하지 않으므로
 *   사용 전에 반드시 명시적으로 초기화해야 합니다.
 * - 참조형 변수에 null을 할당하면 “참조 없음(무효 주소)” 상태가 됩니다.
 */
public class C0601_Array01 {

    public static void main(String[] args) {
        // --- 1. 배열 참조 변수 선언만 한 경우 ---
        int[] arrInt;               // 선언만 된 배열: JVM이 초기화하지 않음
        // System.out.println(arrInt); 
        // ↑ 컴파일 오류: arrInt가 초기화되지 않음
        
        // --- 2. 배열 참조 변수를 null로 초기화한 경우 ---
        int arrInt2[] = null;       // null 할당: 유효한 배열 주소가 아님
        // System.out.println(arrInt2.length);
        // ↑ 런타임 오류: NullPointerException 발생
        
        // null 상태 참조 출력
        System.out.println("arrInt2 = " + arrInt2);
        // 출력: arrInt2 = null
        
        // --- 3. 배열 사용 전 올바른 초기화 방법 ---
        // 3-1) new 연산자로 크기 지정하여 초기화
        arrInt = new int[3];       
        // 배열 요소는 기본형 int이므로 0으로 자동 초기화됨
        
        // 3-2) 리터럴 초기화
        // arrInt = new int[] {10, 20, 30};
        
        // 초기화 후 안전한 사용
        System.out.println("arrInt.length = " + arrInt.length);
        for (int i = 0; i < arrInt.length; i++) {
            System.out.println("arrInt[" + i + "] = " + arrInt[i]);
        }
    }
}
//
//
//
//  학습 포인트
//
//  1. 지역변수 선언만 한 배열은 초기화되지 않아 사용 불가(컴파일 오류).
//
//  2. null 참조는 “참조 없음” 상태로, length나 요소 접근 시 NullPointerException 발생.
//
//  3. 배열 사용 전 반드시 new 연산자 또는 리터럴로 초기화해야 함.
//
//  4. new int[N] 선언 시 기본형 배열 요소는 0(숫자), false(논리), null(참조) 등 타입별 기본값으로 자동 초기화됨.
//
//  5. 안전한 배열 사용을 위해 선언과 동시에 초기화하거나, length 속성으로 순회하며 요소에 접근하세요.
//
//
//