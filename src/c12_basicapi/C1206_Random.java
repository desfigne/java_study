package c12_basicapi;

import java.util.Random;

public class C1206_Random {

	public static void main(String[] args) {

		Random random = new Random();
		System.out.println(random.nextInt());
		System.out.println(random.nextFloat());
		System.out.println(random.nextDouble());
		System.out.println((int)random.nextLong(1000, 9999));
		
	}

}
