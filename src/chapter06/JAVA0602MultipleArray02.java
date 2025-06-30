package chapter06;  
// 패키지 선언: 클래스를 논리적으로 묶어 네임스페이스를 구성합니다.

/**
 * 가변형 2차원 배열(jagged array) 예제
 * - 각 행(row)에 서로 다른 열(column) 길이를 지정해 배열을 생성합니다.
 * - 인덱스 출력과 값 채우기 과정을 통해 구조를 확인합니다.
 */
public class JAVA0602MultipleArray02 {

    public static void main(String[] args) {
        // --- 1. 가변형 배열 생성(jagged array) ---
        // 5행으로 선언하되, 열 길이는 미정 상태로 초기화
        int[][] matrix = new int[5][];
        
        // 각 행마다 다른 길이의 1차원 배열을 할당
        matrix[0] = new int[1];   // 0행: 열 1개
        matrix[1] = new int[2];   // 1행: 열 2개
        matrix[2] = new int[3];   // 2행: 열 3개
        matrix[3] = new int[2];   // 3행: 열 2개
        matrix[4] = new int[1];   // 4행: 열 1개

        // --- 2. 인덱스 구조 출력 ---
        // 각 요소의 [행,열] 인덱스를 확인
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + i + ", " + j + "]\t");
            }
            System.out.println();   // 한 행 출력 후 줄바꿈
            System.out.println();   // 가독성을 위한 빈 줄
        }

        // --- 3. 값 채우기 및 출력 ---
        // count 변수를 이용해 각 요소에 10단위 값을 순차 할당
        int count = 10;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = count;            // 값 할당
                System.out.print(matrix[i][j] + "\t");  
                count += 10;                     // 다음 값 준비
            }
            System.out.println();               // 한 행 출력 후 줄바꿈
            System.out.println();               // 가독성을 위한 빈 줄
        }
    }
}
//
//
//
//  학습 포인트
//
//  1. 가변형 배열(jagged array)
//   - 2차원 배열 선언 시 각 행마다 서로 다른 길이의 1차원 배열을 할당할 수 있습니다.
//   - 메모리 사용이 필요한 만큼만 할당되므로 효율적일 수 있습니다.
//
//  2. 배열의 길이 조회
//   - matrix.length는 행의 개수(5)를 반환합니다.
//   - matrix[i].length는 해당 행 i의 열 길이를 반환합니다.
//
//  3. 중첩 반복문(nested loops)
//   - 이중 for문으로 2차원 배열의 모든 요소에 접근할 수 있습니다.
//   - 첫 번째 for문은 행, 두 번째 for문은 열을 순회합니다.
//
//  4. 값 채우기 전략
//   - count 변수를 통해 규칙적인 값(10,20,30…)을 순차적으로 할당하는 방법을 실습합니다.
//   - 값 초기화와 출력 로직을 함께 구성해 반복문 흐름을 이해합니다.
//
//  5. 출력 가독성
//   - System.out.println() 사이에 빈 줄을 삽입해 구조를 시각적으로 구분합니다.
//   - 탭 문자(\t)로 열 간 간격을 일정하게 맞춥니다.
//
//
//