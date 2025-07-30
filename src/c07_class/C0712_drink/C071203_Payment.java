package c07_class.C0712_drink;

public class C071203_Payment {
	
	// Field
	int amount;
	int change;
	
	// Constructor
	public C071203_Payment() {
		
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
