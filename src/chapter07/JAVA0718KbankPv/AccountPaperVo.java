package chapter07.JAVA0718KbankPv;

public class AccountPaperVo {

    // 1-1. 고객 이름
	private String name;
	
    // 1-2. 계좌번호
    private String accountNumber;

    // 1-3. 출금 금액 (초기엔 0일 수 있음)
	private int amount;

    // 1-4. 비밀번호
	private int password;

    // 1-5. 각 필드에 대한 getter/setter
	public String getName() { return name; }
	public String getAccountNumber() { return accountNumber; }
	public int getAmount() { return amount; }
	public int getPassword() { return password; }
	
	public void setName(String name) { this.name = name; }
	public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
	public void setAmount(int amount) { this.amount = amount; }
	public void setPassword(int password) { this.password = password; }
}
