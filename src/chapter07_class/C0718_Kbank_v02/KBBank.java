package chapter07_class.C0718_Kbank_v02;

public class KBBank {

	public static void main(String[] args) {
		
		BankSystem kbsystem = new BankSystem("KB"); // 8.
		
		AccountPaperVo accountPaper = AccountPaperVo.getInstance();  // 1. - 4.
//		System.out.println(accountPaper.getName()); // null 값이 나오는지 테스트용
//		AccountPaperVo.showInfo();
		
		BankMan staffPark = new BankMan("박보검", kbsystem); // 5. 은행직원 생성시 고객리스트 정보 가짐 // 12.
		
		// 13.은행직원 -> 고객정보 리스트 출력
//		staffPark.kbsystem.showAccountList();
		staffPark.getKbsystem().showAccountList();
//		-------------------
//				BankSystem.
		
		Customer hong = new Customer("홍길동", "kb-1234", null, 0); // 14.
		boolean validateFlag = true;
		hong.setAccountPaper(accountPaper); // 15.
//		hong.getAccountPaper().showInfo(); // 이클립스에서 유용하지 못함을 안내해줌
//		AccountPaperVo.showInfo(); // 18.
		
		// 은행 직원이 고객의 용지를 받는다.
		staffPark.setAccountPaper(hong.getAccountPaper()); // 20.
		staffPark.validateCheck(); // 고객에게 전달받은 출금용지에 빈값이 있는지 체크
//		hong.answer(staffPark.checkResult);
		while(validateFlag) {
			if(staffPark.validateCheck(hong.answer(staffPark.checkResult))) {
				validateFlag = false;
			}
		}
		
		staffPark.processWithdrawal();
		
		kbsystem.confirmBalance(hong.getAccountPaper()); // ATM(은행 시스템)을 이용하여 잔액을 확인
	}
}
