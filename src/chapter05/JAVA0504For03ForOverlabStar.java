package chapter05;

/*
 [시작]
 * 
 **
 ***
 ****
 *****
 [종료]
 */

public class JAVA0504For03ForOverlabStar {

	public static void main(String[] args) {
				
		for(int k=1; k<=10; k++) { // 행
			for(int m=1; m<=k; m++) { // 열
//				if(k >= m) System.out.print("*");
				if(k >= m) System.out.print("🍕");
			}
			
			System.out.println();
		}

	}

}
