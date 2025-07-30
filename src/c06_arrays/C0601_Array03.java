package c06_arrays;  
// 패키지 선언: 클래스를 논리적으로 묶어 네임스페이스를 구성합니다.

public class C0601_Array03 {
    // 클래스 선언: 배열 사용의 효율성을 학습하기 위한 예제

    public static void main(String[] args) {
        // --- 1. 개별 변수에 값 저장 (비효율 예시) ---
        // 스택에 5개의 변수를 각각 선언하므로 메모리 사용이 비효율적입니다.
        int n1 = 1;
        int n2 = 2;
        int n3 = 3;
        int n4 = 4;
        int n5 = 5;

        // 개별 출력 (주석 처리된 원본)
//      System.out.println(n1);
//      System.out.println(n2);
//      System.out.println(n3);
//      System.out.println(n4);
//      System.out.println(n5);

        // --- 2. 배열 선언 후 수동 초기화 (부분 복원 예시) ---
        // int[] numbers = new int[5];  // 스택에 배열 참조 1개만 저장
        // 배열 요소 기본값: 0
//      System.out.println(numbers[0]);  // 0
//      ...
//      numbers[0] = 1;
//      numbers[1] = 2;
//      ...
//      System.out.println(numbers[4]);  // 5

        // --- 3. for문을 이용한 배열 초기화 (부분 복원 예시) ---
        // int[] numbers = new int[5];
//      for (int i = 0; i < 5; i++) {
//          numbers[i] = i + 1;  // numbers[0]=1, ..., numbers[4]=5
//      }
//      // 출력 (기본값 0 → 초기화 전)
//      System.out.println(numbers[0]);
//      ...

        // --- 4. 확장 예시: 크기 100 배열 초기화 & 출력 (주석 복원 예시) ---
        // int[] numbers = new int[100];
        // // 데이터 저장
        // for (int i = 0; i < 100; i++) {
        //     numbers[i] += i;  // 인덱스 값을 누적
        // }
        // // 데이터 출력
        // for (int i = 0; i < 100; i++) {
        //     System.out.println(numbers[i]);
        // }

        // --- 5. 최종 구현: length 사용으로 유연성 확보 ---
        // 배열 길이를 length 속성으로 참조하여 크기 변경에 자동 대응
        int[] numbers = new int[200];  // 배열 길이 200

        // 데이터 저장: 각 요소에 인덱스 값을 더함
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] += i;  
            // numbers[i] = numbers[i] + i;
            // 초기값 0에 인덱스 값 i를 누적 → numbers[i] == i
        }

        // 데이터 출력: 배열 길이만큼 순회
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
    }
}
//
//
//
// 학습 포인트
//  1. 개별 변수 vs. 배열
//   - 개별 변수 선언은 메모리 사용이 비효율적이며, 유지보수도 어렵습니다.
//   - 배열을 사용하면 변수 개수를 줄이고 반복문으로 일괄 처리할 수 있어 효율적입니다.
//
//  2. 배열 기본값
//   - new int[N] 선언 시 요소는 모두 0으로 자동 초기화됩니다.
//
//  3. for문과 length 활용
//   - for (int i = 0; i < numbers.length; i++) 구조를 사용하면
//     배열 크기를 변경해도 반복문을 수정할 필요가 없습니다.
//
//  4. 누적 연산 방식
//   - numbers[i] += i; 문법을 통해 기존 값에 인덱스 값을 더하는 연산을 간결하게 표현합니다.
//
//  5. 가독성 있는 출력
//   - 출력 시 배열 인덱스와 값을 함께 표시하여 디버깅 및 학습 이해도를 높입니다.
//
//
//