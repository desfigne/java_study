package chapter07;

public class JAVA0707ScoreMgmSystem01Student {

	// Field : 맴버변수, 전역변수
	String name;
	int kor, eng, math;
//	int tot = kor + eng + math;
//	int avg = tot/3; // 총점을 출력한다.는 동사기 때문에 기능으로 가는게 더 적절함
	
	// Constructor
	public JAVA0707ScoreMgmSystem01Student() {}
	
	// Method
	public int getTot() {
		return kor + eng + math;
	}

	public int getAvg() {
		return (kor + eng + math)/3;
	}
}
