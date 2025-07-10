package chapter07.JAVA0718KbankPv;

public class KBBank {

    public static void main(String[] args) {
        System.out.println("=== 🏛💰 은행 출금 시스템 시뮬레이션 🏛💰 ===");
        System.out.println("[시작]\n");

        // 1) 고객 객체 생성 (홍길동)
        Customer customer = new Customer("홍길동", "123-456", 4321);
        System.out.println("1. 고객 객체 생성 완료 → name=" + customer.getName()
                           + ", accountNumber=" + customer.getAccountNumber()
                           + ", password=" + customer.getPassword() + "\n");

        // 2) 계좌 객체 생성 (잔액 5,000,000원)
        AccountVo account = new AccountVo("홍길동", "123-456", 4321, 5000000);
        System.out.println("2. 계좌 객체 생성 완료 → balance=" 
                           + String.format("%,d", account.getBalance()) + "원\n");

        // 3) 고객이 출금용지 작성 (금액 미입력)
        AccountPaperVo paper = customer.writeAccountPaper();
        System.out.println("3. 출금용지 작성 완료 → name=" + paper.getName()
                           + ", accountNumber=" + paper.getAccountNumber()
                           + ", password=" + paper.getPassword()
                           + ", amount=" + paper.getAmount() + "원\n");

        // 4) 은행 직원(싱글톤) 객체 가져오기
        BankMan staff = BankMan.getInstance();
        System.out.println("4. BankMan 인스턴스 획득 → " + staff + "\n");

        // 5) 직원이 출금용지 확인, 금액 누락 시 문의
        staff.checkPaper(paper, customer);
        System.out.println("   → 확인 후 paper.getAmount()=" 
                           + paper.getAmount() + "원\n");

        // 6) 직원이 출금 처리
        staff.processWithdrawal(paper, account);
        System.out.println("   → 처리 후 account.getBalance()=" 
                           + String.format("%,d", account.getBalance()) + "원\n");

        // 7) 고객이 출금 금액과 잔액 확인
        System.out.println("7. 고객이 최종 확인");
        System.out.println("   출금액 = " + String.format("%,d", paper.getAmount()) + "원");
        System.out.println("   남은 잔액 = " + String.format("%,d", account.getBalance()) + "원\n");

        System.out.println("[종료]");
        System.out.println("=== 시뮬레이션 완료 ===");
    }
}
