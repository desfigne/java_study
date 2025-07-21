package part02_follow.chapter07_class;

public class C0706_SSMS_V0301_Student {

	// Field : 맴버변수, 전역변수
	String name;
	int kor, eng, math;
//	int tot = kor + eng + math;
//	int avg = tot/3; // 총점을 출력한다.는 동사기 때문에 기능으로 가는게 더 적절함
	// 여러 값을 받을 수 있도록 일반화 필요;
	
	// Constructor
	public C0706_SSMS_V0301_Student() {}
	
	// Method
	public int getTot() {
		return kor + eng + math;
	}

	public int getAvg() {
		return (kor + eng + math)/3;
	}
}
