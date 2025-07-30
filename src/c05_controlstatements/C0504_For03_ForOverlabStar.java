package c05_controlstatements;

/*
 [시작]
 * 
 **
 ***
 ****
 *****
 [종료]
 */

public class C0504_For03_ForOverlabStar {

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
