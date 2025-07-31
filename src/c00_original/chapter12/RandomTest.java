package chapter12;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random random = new Random();
//		random.setSeed(1);
		System.out.println(random.nextInt(100));
		System.out.println(random.nextFloat());
		System.out.println(random.nextDouble());
		System.out.println((int)random.nextLong(1001, 9999));
	}

}
