package c09_interface.C0908_Drink;

public class Payment {
	
	// Field
	int amount;
	int change;
	
	// Constructor
	public Payment() {
		
	}
	
	// Method
	public void setAmount(int amount) {
//		this.amount = this.amount + amount;
		this.amount += amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public int getChange() {
		return change;
	}
	
//	public void getPayment(int total) {
//		if(amount >= total) {
//			change = amount - total;
//			System.out.println("=> 결제 완료");
//		} else {
//			System.out.println("=> 결제 금액 부족");
//		}
//	}
	
	public boolean getPayment(int total) {
		boolean result = false;
		if(amount >= total) {
			change = amount - total;
			result = true;
		}
		return result;
	}
	
}
