package chapter07;

public class JAVA0704SMS01Student {

	// Field : 맴버변수, 전역변수
	String name;
	int kor, eng, math;
	
	// Constructor
	public JAVA0704SMS01Student() {}
	
	// Method
	public int getTot() {
		return kor + eng + math;
	}

	public int getAvg() {
		return (kor + eng + math)/3;
	}
}
