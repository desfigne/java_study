package chapter07.JAVA0718KbankPv;

public class AccountVo {

    // 3-1. 계좌주 이름
	private String name;

    // 3-2. 계좌번호
    private String accountNumber;

    // 3-3. 비밀번호
	private int password;

    // 3-4. 잔액
    private int balance;

    // 3-5. 생성자: 계좌 정보 초기화
    public AccountVo(String name, String accountNumber, int password, int balance) {
    	this.name = name;
    	this.accountNumber = accountNumber;
    	this.password = password;
    	this.balance = balance;
    }

    // 3-6. 출금용지와 정보 일치 여부 확인
    public boolean checkInfo(AccountPaperVo paper) {
    	System.out.println("5. 은행 직원이 계좌 정보를 검증함");
    	System.out.println("   - 계좌주 이름 확인: " + this.name + " vs " + paper.getName());
    	System.out.println("   - 계좌번호 확인: " + this.accountNumber + " vs " + paper.getAccountNumber());
    	System.out.println("   - 비밀번호 확인: " + this.password + " vs " + paper.getPassword());
    	
    	// 3-6-1. 이름, 계좌번호, 비밀번호 모두 일치해야 true
    	boolean isMatch = this.name.equals(paper.getName()) &&
    		   this.accountNumber.equals(paper.getAccountNumber()) &&
    		   this.password == paper.getPassword();
    	
    	if (isMatch) {
    		System.out.println("   → 계좌 정보 일치 확인됨");
    	} else {
    		System.out.println("   → 계좌 정보 불일치");
    	}
    	System.out.println();
    	
    	return isMatch;
    }
    
    // 3-7. 출금 처리 (잔액 차감)
    public void withdraw(int amount) {
    	System.out.println("6. 출금 처리를 하고, 잔액을 업데이트함");
    	System.out.println("   - 출금 전 잔액: " + String.format("%,d", this.balance) + "원");
    	
    	// 3-7-1. 출금 금액만큼 잔액 차감
    	this.balance -= amount;
    	
    	System.out.println("   - 출금 금액: " + String.format("%,d", amount) + "원");
    	System.out.println("   - 출금 후 잔액: " + String.format("%,d", this.balance) + "원");
    	System.out.println();
    }
    
    // 3-8. 잔액 조회
	public int getBalance() {
		return balance;
	}
}
