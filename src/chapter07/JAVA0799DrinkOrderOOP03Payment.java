package chapter07;

import java.util.Scanner;

public class JAVA0799DrinkOrderOOP03Payment {
    private int totalPrice;

    public JAVA0799DrinkOrderOOP03Payment(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int processPayment(Scanner sc) {
        int paid = 0;
        while (paid < totalPrice) {
            System.out.print("결제할 금액 입력> ");
            String input = sc.nextLine();
            try {
                int money = Integer.parseInt(input);
                paid += money;
                System.out.printf("총 입금 금액 : %,d\n", paid);
                if (paid < totalPrice) {
                    System.out.println("=> 금액이 부족합니다. 다시 입력해주세요.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("올바르지 않은 입력값 입니다.\n");
            }
        }
        System.out.printf("=> 결제 완료! 잔돈: %,d원\n\n", paid - totalPrice);
        return paid - totalPrice;
    }
}
