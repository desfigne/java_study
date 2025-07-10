package chapter07.JAVA0718KbankPv;

public class BankMan {
	
    // 4-1. 싱글톤 인스턴스 생성
	private static BankMan instance = new BankMan();
	
    // 4-2. 생성자 private
	private BankMan() {}
	
    // 4-3. 싱글톤 인스턴스 반환
	public static BankMan getInstance() {
		return instance;
	}

    // 4-4. 출금용지 확인 및 금액 누락 시 고객에게 문의
    public void checkPaper(AccountPaperVo paper, Customer customer) {
    	System.out.println("2. 은행 직원 박보검이 용지를 확인함");
    	System.out.println("   - 이름: " + paper.getName());
    	System.out.println("   - 계좌번호: " + paper.getAccountNumber());
    	System.out.println("   - 비밀번호: " + paper.getPassword());
    	System.out.println("   - 출금 금액: " + paper.getAmount() + "원");
    	System.out.println();
    	
    	// 4-4-1. 출금용지의 금액이 0이면
        if (paper.getAmount() == 0) {
        	// 4-4-2. 고객에게 금액을 물어봄
        	System.out.println("3. 금액이 누락되어 고객에게 금액을 물어봄");
            System.out.println("직원: 출금 금액이 빠져 있습니다. 얼마를 인출하시겠습니까?");
            System.out.println();
            customer.answerAmount(paper);
        }
    }

    // 4-5. 출금 처리
    public void processWithdrawal(AccountPaperVo paper, AccountVo account) {
    	// 4-5-1. 계좌 정보가 일치하는지 확인
        if (account.checkInfo(paper)) {
        	// 4-5-2. 출금 처리
            account.withdraw(paper.getAmount());
            System.out.println("직원: 출금이 완료되었습니다.");
            System.out.println();
        } else {
            System.out.println("직원: 계좌 정보가 일치하지 않습니다.");
            System.out.println();
        }
    }
}
