package chapter07_class.C0718_Kbank_v02;

/**
 * 은행에 비치되어 있는 입출금 용지
 */
public class AccountPaperVo {
	
	private String name;
	private String accountNumber;
	private String password;
	private int money;
	private static AccountPaperVo accountPaper = new AccountPaperVo(); // 3.
	
	private AccountPaperVo() {} // 2.
	
	public static void showInfo() { // 17.
//		System.out.print(name + "\t"); 해당 선언이 static이 아니여서 호출 불가
		System.out.println("=============================================");
		System.out.print(accountPaper.getName() + "\t");
		System.out.print(accountPaper.getAccountNumber() + "\t");
		System.out.print(accountPaper.getPassword() + "\t");
		System.out.print(accountPaper.getMoney() + "\n");
		System.out.println("=============================================");
		
	}
	
	public static AccountPaperVo getInstance() { // 4.
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
	
}
