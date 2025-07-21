package part02_follow.chapter07_class;

import java.util.Scanner;

public class C0799_DrinkOrderOOP_V0104_OrderSystem {
    private C0799_DrinkOrderOOP_V0101_Menu[] menus = {
        new C0799_DrinkOrderOOP_V0101_Menu("☕ 아메리카노", 2800),
        new C0799_DrinkOrderOOP_V0101_Menu("🍵 바닐라 라떼", 3500),
        new C0799_DrinkOrderOOP_V0101_Menu("🥤 딸기 쉐이크", 4000)
    };

    public void run() {
        Scanner sc = new Scanner(System.in);

        // 메뉴 출력
        System.out.println("=== 메뉴판 ===");
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%d. %s - %,d원\n", i + 1, menus[i].getName(), menus[i].getPrice());
        }

        // 주문
        C0799_DrinkOrderOOP_V0101_Menu selectedMenu = null;
        while (true) {
            System.out.print("\n주문할 메뉴 번호 입력> ");
            String input = sc.nextLine();
            try {
                int menuNo = Integer.parseInt(input);
                if (menuNo < 1 || menuNo > menus.length) {
                    System.out.println("준비중 입니다.\n");
                    continue;
                }
                selectedMenu = menus[menuNo - 1];
                break;
            } catch (NumberFormatException e) {
                System.out.println("올바르지 않은 입력값 입니다.\n");
            }
        }

        C0799_DrinkOrderOOP_V0102_Order order = new C0799_DrinkOrderOOP_V0102_Order(selectedMenu, 1); // 수량 1로 고정
        System.out.printf("=> 주문 메뉴 : %s, 결제 예정 금액 : %,d원\n\n", order.getMenu().getName(), order.getTotalPrice());

        // 결제
        C0799_DrinkOrderOOP_V0103_Payment payment = new C0799_DrinkOrderOOP_V0103_Payment(order.getTotalPrice());
        payment.processPayment(sc);

        System.out.println("[종료]");
        System.out.println("이용해주셔서 감사합니다.");
        sc.close();
    }

    public static void main(String[] args) {
        new C0799_DrinkOrderOOP_V0104_OrderSystem().run();
    }
}
