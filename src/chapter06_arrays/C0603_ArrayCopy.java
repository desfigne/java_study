package chapter06_arrays;  
// 패키지 선언: 클래스를 논리적으로 묶어 네임스페이스를 구성합니다.

import java.util.Arrays;  
// Arrays 클래스 임포트: 배열 조작을 위한 유틸리티

/**
 * 배열 복사 실습 예제
 * - for문, System.arraycopy(), Arrays.copyOf() 세 가지 방법을 비교합니다.
 */
public class C0603_ArrayCopy {

    public static void main(String[] args) {
        // --- 1) for문을 이용한 배열 복사 ---
        int[] arrInt  = {1, 2, 3};        // 원본 배열 선언 및 초기화
        int[] arrInt2 = new int[5];       // 복제용 배열 선언 (길이 5)

        for (int i = 0; i < arrInt.length; i++) {
            // 인덱스를 이용해 각 요소를 직접 복사
            arrInt2[i] = arrInt[i];
        }

        // 복사된 arrInt2 출력
        System.out.print("for문 복사 결과: ");
        for (int i = 0; i < arrInt2.length; i++) {
            System.out.print(arrInt2[i] + "\t");
        }
        System.out.println();  // 줄바꿈

        // --- 2) System.arraycopy()를 이용한 배열 복사 ---
        int[] arrInt3 = new int[3];       // 복제용 배열 선언 (길이 3)
        // System.arraycopy(src, srcPos, dest, destPos, length)
        System.arraycopy(arrInt, 0, arrInt3, 0, arrInt.length);

        // 복사된 arrInt3 출력
        System.out.print("System.arraycopy 결과: ");
        for (int num : arrInt3) {
            System.out.print(num + "\t");
        }
        System.out.println();  // 줄바꿈

        // --- 3) Arrays.copyOf()를 이용한 배열 복사 ---
        // Arrays.copyOf(original, newLength)
        int[] arrInt4 = Arrays.copyOf(arrInt, arrInt.length);

        // 복사된 arrInt4 출력
        System.out.print("Arrays.copyOf 결과: ");
        for (int num : arrInt4) {
            System.out.print(num + "\t");
        }
        System.out.println();  // 줄바꿈

        // ------------------------------------------------------------------
        // [예시 A] Arrays.copyOf()로 길이를 늘릴 경우
        // int[] arrInt5 = Arrays.copyOf(arrInt, 5);
        // // 출력: 1    2    3    0    0
        // // 새로 늘어난 요소는 기본값(0)으로 채워집니다.
        //
        // [예시 B] Arrays.copyOfRange()로 부분 복사
        // int[] slice = Arrays.copyOfRange(arrInt, 1, 3);  // 인덱스 1~2 복사
        // // 출력: 2    3
        // ------------------------------------------------------------------
    }
}
//
//
//
//  학습 포인트
//
//  1. for문 복사
//   - 인덱스 관리를 직접 해야 해 코드가 길어질 수 있습니다.
//
//  2. System.arraycopy()
//   - 네이티브 메서드로 내부 최적화되어 빠르지만,
//     파라미터가 많아 가독성이 다소 떨어질 수 있습니다.
//
//  3. Arrays.copyOf()/copyOfRange()
//   - 코드가 간결하며 내부적으로 System.arraycopy()를 사용합니다.
//
//  4. 배열 길이 불일치 처리
//   - 복사 길이가 원본보다 크면 남는 요소는 기본값으로 채우고,
//     작으면 초과 요소는 잘려나갑니다.
//
//  5. 얕은 복사 주의
//   - 객체 배열이나 다차원 배열 복사 시 내부 객체는 동일 참조를 유지합니다.
//
//
//