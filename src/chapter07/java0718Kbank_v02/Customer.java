package chapter07.java0718Kbank_v02;

import java.util.Scanner;

public class Customer {
	
	private String name;
	private String accountNumber;
	private String password;
	private int money;
	private AccountPaperVo accountPaper;
	private Scanner scan;
	
	public Customer() {}

	public Customer(String name, String accountNumber, String password, int money) {
		this.name = "[방문고객 : " + name + "]";
		this.accountNumber = accountNumber;
		this.password = password;
		this.money = money;
		this.scan = new Scanner(System.in);
		System.out.println(this.name + " 입장");
	}
	
	/**
	 * 은행직원이 유효성 체크 후 빠진 
	 */
	public AccountPaperVo answer(int checkResult) {
		switch(checkResult) {
		case BankMan.ACCOUNT_NAME:
			System.out.print(this.name + " 고객명 > ");
//			String name = scan.next();
//			accountPaper.setName(name);
			accountPaper.setName(scan.next()); // 이렇게도 가능, 보통 이렇게 줄여서 사용
			break;
			
		case BankMan.ACCOUNT_NUMBER:
			System.out.print(this.name + " 계좌번호 > ");
			accountPaper.setAccountNumber(scan.next());
			
			break;
			
		case BankMan.ACCOUNT_PASSWORD:
			System.out.print(this.name + " 비밀번호 > ");
			accountPaper.setPassword(scan.next());
			
			break;
			
		case BankMan.ACCOUNT_MONEY:
			System.out.print(this.name + " 금액 > ");
			accountPaper.setMoney(scan.nextInt());
			
			break;
		}
		
		return accountPaper;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public AccountPaperVo getAccountPaper() {
		return accountPaper;
	}

	public void setAccountPaper(AccountPaperVo accountPaper) { // 은행 비치용 입출금 용지 가져옴 // 16.
		
		accountPaper.setName(this.name); // < 홍을 통해 주소값이 들어가는게 아님
		accountPaper.setAccountNumber(this.accountNumber);
		accountPaper.setPassword(this.password);
		accountPaper.setMoney(this.money);
		this.accountPaper = accountPaper; // > 홍을 통해 주소값이 들어가도록 선언
		System.out.println(this.name + " 출금 정보 작성 완료");
		System.out.println(this.name + " 은행직원에게 출금용지 전달");
		
//		this.accountPaper = accountPaper;
//		this.accountPaper.setName(this.name);
//		this.accountPaper.setAccountNumber(this.accountNumber);
//		this.accountPaper.setPassword(this.password);
//		this.accountPaper.setMoney(this.money); // this. 는 제일 위 전역변수를 지칭함
	}

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}
	
}
