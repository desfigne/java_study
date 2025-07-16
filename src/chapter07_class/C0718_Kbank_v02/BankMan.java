package chapter07_class.C0718_Kbank_v02;

/**
 * 은행 직원 클래스
 */
public class BankMan {
	
	String name;
	int checkResult;
	private AccountPaperVo accountPaper; // 공유되는 이름과 동일하게 유지
	private AccountVo[] accountList;
	private BankSystem kbsystem; // 10.
	
	public static final int ACCOUNT_NAME = 1;
	public static final int ACCOUNT_NUMBER = 2;
	public static final int ACCOUNT_PASSWORD = 3;
	public static final int ACCOUNT_MONEY = 4;

	public BankMan() {} // 6.

	public BankMan(String name, BankSystem kbsystem) { // 7. //11.
		this.name = "[은행직원 : " + name + "]";
		this.kbsystem = kbsystem;
		System.out.println(this.name + " 업무시작");
	}
	
	/**
	 * 고객의 출금정보 유효성 체크 결과에 따라 질문
	 */
	public void ask(int status) {
		System.out.println(this.name + " 출금용지에 기재된 고객 정보에 대한 유효성 체크를 진행한다.");
		switch(status) {
			case ACCOUNT_NAME:
				System.out.println(this.name + " 이름이 일치하지 않습니다, 다시 입력해주세요.");
				checkResult = ACCOUNT_NAME;
				break;
			case ACCOUNT_NUMBER:
				System.out.println(this.name + " 계좌번호가 일치하지 않습니다, 다시 입력해주세요.");
				checkResult = ACCOUNT_NUMBER;
				break;
			case ACCOUNT_PASSWORD:
				System.out.println(this.name + " 비밀번호가 일치하지 않습니다, 다시 입력해주세요.");
				checkResult = ACCOUNT_PASSWORD;
				break;
			case ACCOUNT_MONEY:
				System.out.println(this.name + " 금액이 일치하지 않습니다, 다시 입력해주세요.");
				checkResult = ACCOUNT_MONEY;
				break;
		}
	}
	
	/**
	 * 고객의 출금정보 유효성 체크 : 고객에게 전달받은 출금용지에 빈값이 있는지 체크
	 */
	public void validateCheck() {
		if(accountPaper.getName() == null) { // 주소값을 비교할 때는 이렇게 진행
//		if(accountPaper.getName().equals(null)) { // 둘다 스트링이라 동작하지만 일반 객체일 경우 에러
			ask(ACCOUNT_NAME);
		}
		else if(accountPaper.getAccountNumber() == null) {
			ask(ACCOUNT_NUMBER);
		}
		else if(accountPaper.getPassword() == null) {
			ask(ACCOUNT_PASSWORD);
		}
		else if(accountPaper.getMoney() == 0) {
			ask(ACCOUNT_MONEY);
		}
		else {
			// 모두 입력되어 있음
		}
	}
	
	/**
	 * 다시 고객의 출금정보 유효성 체크 : 고객에게 전달받은 출금용지에 빈값이 있는지 체크
	 */
	public boolean validateCheck(AccountPaperVo updateAccountPaper) {
		boolean result = false;
		System.out.println(this.name + " 다시 출금용지에 기재된 고객 정보에 대한 유효성 체크를 재진행한다.");
		
		this.accountPaper = updateAccountPaper;
		
		if(accountPaper.getName() == null) { // 주소값을 비교할 때는 이렇게 진행
//		if(accountPaper.getName().equals(null)) { // 둘다 스트링이라 동작하지만 일반 객체일 경우 에러
			ask(ACCOUNT_NAME);
		}
		else if(accountPaper.getAccountNumber() == null) {
			ask(ACCOUNT_NUMBER);
		}
		else if(accountPaper.getPassword() == null) {
			ask(ACCOUNT_PASSWORD);
		}
		else if(accountPaper.getMoney() == 0) {
			ask(ACCOUNT_MONEY);
		}
		else {
			// 모두 입력되어 있음
			System.out.println("모두 입력이 완료되었습니다.");
			result = true;
		}
		return result;
	}
	
	/**
	 * 출금 요청 처리
	 */
	public void processWithdrawal() {
		System.out.println(this.name + " 출금요청 처리가 진행 중입니다. 잠시 기다려주세요.");
		// 고객계정 검색 - BankSystem > 잔고 - 금액
		int accountIdx = kbsystem.searchAccount(accountPaper);
		if(accountIdx != -1) {
			AccountVo account = kbsystem.accountList[accountIdx];
			if(account.getBalance() >= accountPaper.getMoney()) {
				// 출금 진행
				int money = account.getBalance() - accountPaper.getMoney();
				account.setBalance(money);
				kbsystem.accountList[accountIdx] = account;
				
				processCompleted();
			} else {
				System.out.println(this.name + " 잔액이 부족합니다.");
			}
		} else {
			// 고객 정보가 일치하지 않음
			System.out.println(this.name + " 계좌정보가 일치하지 않습니다, 확인 후 다시 진행해주세요.");
		}
	}
	
	/**
	 * 
	 */
	public void processCompleted() {
		System.out.println(this.name +" 출금 처리가 완료되었습니다.");
		System.out.println(this.name +" 출금액은 " + accountPaper.getMoney() + "입니다.");
	}

	public AccountPaperVo getAccountPaper() {
		return accountPaper;
	}

	public void setAccountPaper(AccountPaperVo accountPaper) {
		this.accountPaper = accountPaper;
		System.out.println(this.name +" 방문고객에게 출금용지 받음");
	}

	public AccountVo[] getAccountList() {
		return accountList;
	}

	public void setAccountList(AccountVo[] accountList) {
		this.accountList = accountList;
	}

	public BankSystem getKbsystem() {
		return kbsystem;
	}

	public void setKbsystem(BankSystem kbsystem) {
		this.kbsystem = kbsystem;
	}
	
}
