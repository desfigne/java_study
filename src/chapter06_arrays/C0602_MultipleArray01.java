package chapter06_arrays;  
// 패키지 선언: 클래스를 논리적으로 묶어 네임스페이스를 구성합니다.

/**
 * 2차원 배열 생성 및 순회 예제
 * - case01: 고정 크기(3×3) 배열에 특정 요소만 값 할당
 * - case02: 가변형 배열 선언 후 각 행에 동일 크기 배열 할당
 * - case03: 초기화 블록을 이용한 선언 및 값 할당
 */
public class C0602_MultipleArray01 {

    public static void main(String[] args) {
        // --- case01. 고정 크기 3×3 배열 생성 및 일부 값 할당 ---
        // 3행 3열 크기의 2차원 배열 선언 (모든 요소 기본값 0)
        int[][] matrix = new int[3][3];
        matrix[0][0] = 10;   // [0,0] 위치에 값 10 할당
        matrix[2][1] = 50;   // [2,1] 위치에 값 50 할당

        System.out.println("---- case01: 고정 크기 배열 ----");
        // 배열 구조와 값 확인을 위한 순회
        for (int i = 0; i < matrix.length; i++) {
            // matrix.length = 행의 개수(3)
            for (int j = 0; j < matrix[i].length; j++) {
                // matrix[i].length = 각 행의 열 개수(3)
                System.out.print(" [" + i + ", " + j + "] = " + matrix[i][j] + "\t");
                // 탭(\t)으로 열 간격 조정
            }
            System.out.println();  // 한 행 출력 후 줄바꿈
        }
        System.out.println();  // 가독성을 위한 빈 줄

        // --- case02. 가변형 배열 선언 후 각 행에 배열 할당 ---
        // 3행으로 선언하되 열 길이는 미정 상태
        int[][] matrix2 = new int[3][];
        // 각 행마다 동일 크기(3열) 배열을 새로 할당
        matrix2[0] = new int[3];
        matrix2[1] = new int[3];
        matrix2[2] = new int[3];
        // 모든 요소는 기본값 0

        System.out.println("---- case02: 가변형 배열 + 동일 크기 할당 ----");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(" [" + i + ", " + j + "] = " + matrix2[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        // --- case03. 초기화 블록을 이용한 배열 선언 및 값 할당 ---
        // 선언과 동시에 값까지 설정 (3×3 배열)
        int[][] matrix3 = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };

        System.out.println("---- case03: 초기화 블록 배열 ----");
        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[i].length; j++) {
                System.out.print(" [" + i + ", " + j + "] = " + matrix3[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
//
//
//
//  학습 포인트
//
//  1. 2차원 배열 선언 방법 비교
//   - new int[3][3]: 고정된 행·열 크기 배열 생성
//   - new int[3][]  : 가변형 배열 선언 후 각 행에 별도 배열 할당
//   - {{...}}       : 초기화 블록으로 선언과 동시에 요소 값 지정
//
//  2. 배열 길이 조회
//   - matrix.length      : 1차원 배열(행)의 길이
//   - matrix[i].length   : 2차원 배열 각 행의 열 길이
//
//  3. 중첩 반복문(nested loops) 순회
//   - 외부 for문: 행 인덱스(i)를 순회
//   - 내부 for문: 열 인덱스(j)를 순회
//
//  4. 기본값 이해
//   - int 타입 배열 요소는 초기값 0으로 자동 설정됩니다.
//   - 필요한 요소만 선택적으로 값 할당 가능
//
//  5. 출력 가독성
//   - System.out.print()와 탭(\t) 사용으로 열 맞춤
//   - System.out.println()으로 줄바꿈 및 빈 줄 활용
//
//
//