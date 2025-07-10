package chapter07.JAVA0718KbankPv;

public class Customer {

    // 2-1. 고객 이름
	private String name;
	
    // 2-2. 계좌번호
	private String accountNumber;

    // 2-3. 비밀번호
	private int password;

    // 2-4. 생성자: 고객 정보 초기화
	public Customer(String name, String accountNumber, int password) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.password = password;
	}

    // 2-5. 출금용지 작성 (금액은 미입력)
	public AccountPaperVo writeAccountPaper() {
		
		System.out.println("1. 고객 " + this.name + "이 출금용지에 이름, 계좌번호, 비밀번호를 작성함");
		
		// 2-5-1. 출금용지 객체 생성
		AccountPaperVo paper = new AccountPaperVo();
		
		// 2-5-2. 이름 작성
		paper.setName(this.name);
		
		// 2-5-3. 계좌번호 작성
		paper.setAccountNumber(this.accountNumber);
		
		// 2-5-4. 비밀번호 작성
		paper.setPassword(this.password);
		
		// 2-5-5. 금액은 아직 입력 안함
		System.out.println("   - 이름: " + this.name);
		System.out.println("   - 계좌번호: " + this.accountNumber);
		System.out.println("   - 비밀번호: " + this.password);
		System.out.println("   - 금액: 미입력");
		System.out.println();
		
		return paper;
	}

    // 2-6. 직원이 금액을 물어보면 답변
	public void answerAmount(AccountPaperVo paper) {
		// 2-6-1. 100만원 입력
		System.out.println("4. 고객이 100만원이라 응답함");
		paper.setAmount(1000000);
		System.out.println("   - 출금 금액: 1,000,000원");
		System.out.println();
	}
}
