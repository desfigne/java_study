package part01_teach.vending_machine_ver2;

import java.util.Scanner;

public class User {
	//이름, 입력을 위한 스캐너 객체
	String name;
	Scanner scan;
	
	public User() {
		scan = new Scanner(System.in);
	}
	
	public String getName() { return name; }
	public Scanner getScan() { return scan; }
}










