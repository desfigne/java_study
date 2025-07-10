package chapter07.JAVA0718KbankPv;

public class KBBank {

	public static void main(String[] args) {
		
		System.out.println("=== 🏛💰 은행 출금 시스템 시뮬레이션 🏛💰 ===");
		System.out.println("[시작]");
		System.out.println();
		
        // 5-1. 고객 객체 생성 (홍길동)
        Customer customer = new Customer("홍길동", "123-456", 4321);
		
        // 5-2. 계좌 객체 생성 (홍길동, 500만원)
        AccountVo account = new AccountVo("홍길동", "123-456", 4321, 5000000);
		
        // 5-3. 고객이 출금용지 작성 (금액 미입력)
        AccountPaperVo paper = customer.writeAccountPaper();
		
        // 5-4. 은행 직원(싱글톤) 객체 가져오기
        BankMan staff = BankMan.getInstance();
		
        // 5-5. 직원이 출금용지 확인, 금액 누락 시 문의
        staff.checkPaper(paper, customer);
		
        // 5-6. 직원이 출금 처리
        staff.processWithdrawal(paper, account);
		
        // 5-7. 고객이 출금 금액과 잔액 확인
        System.out.println("7. 고객이 잔액을 확인하고 퇴장함");
        System.out.println("고객: 출금액 = " + String.format("%,d", paper.getAmount()) + "원");
        System.out.println("고객: 남은 잔액 = " + String.format("%,d", account.getBalance()) + "원");
        System.out.println();
        
        // 5-8. 시뮬레이션 종료
        System.out.println("[종료]");
        System.out.println("=== 시뮬레이션 완료 ===");
	}
}
