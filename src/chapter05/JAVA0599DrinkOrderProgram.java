package chapter05;

import java.util.Scanner;

public class JAVA0599DrinkOrderProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 메뉴 데이터
        String[] menuNames = {"☕ 아메리카노", "🍵 바닐라 라떼", "🥤 딸기 쉐이크"};
        int[] menuPrices = {2800, 3500, 4000};

        int menuNo = 0;
        int price = 0;

        // 메뉴 출력 및 주문
        while (true) {
            System.out.println("=== 메뉴판 ===");
            for (int i = 0; i < menuNames.length; i++) {
                System.out.printf("%d. %s - %,d원\n", i + 1, menuNames[i], menuPrices[i]);
            }
            System.out.print("\n주문할 메뉴 번호 입력> ");
            String input = sc.nextLine();

            try {
                menuNo = Integer.parseInt(input);
                if (menuNo < 1 || menuNo > menuNames.length) {
                    System.out.println("준비중 입니다.\n");
                    continue;
                }
                price = menuPrices[menuNo - 1];
                System.out.printf("=> 주문 메뉴 : %s, 결제 예정 금액 : %,d원\n\n", menuNames[menuNo - 1], price);
                break;
            } catch (NumberFormatException e) {
                System.out.println("올바르지 않은 입력값 입니다.\n");
            }
        }

        // 결제
        int total = 0;
        while (true) {
            System.out.print("결제할 금액 입력> ");
            String input = sc.nextLine();

            try {
                int pay = Integer.parseInt(input);
                total += pay;
                System.out.printf("총 입금 금액 : %,d\n", total);
                if (total < price) {
                    System.out.println("=> 금액이 부족합니다. 다시 입력해주세요.\n");
                } else {
                    System.out.printf("=> 결제 완료! 잔돈: %,d원\n\n", total - price);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("올바르지 않은 입력값 입니다.\n");
            }
        }

        System.out.println("[종료]");
        System.out.println("이용해주셔서 감사합니다.");
        sc.close();
    }
}
