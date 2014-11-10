package coding.test;

import java.util.Random;

/**
 *  
 * Write a method to generate a random number between 1 and 7, 
 * given method rand5() that generates a random number between 1 and 5.
 *
 */

public class RandNumberInRange {
	
	static int rand5() {
		Random generator = new Random();
		return generator.nextInt(5) + 1;
	}
	
	static int rand7() {
		while (true) {
			int candidate = 5 * (rand5() - 1) + rand5(); // random value between 1 and 25
			if (candidate <= 21) {
				candidate %= 7;
				return candidate + 1;
			}
		}
	}

	public static void main(String[] args) {
		
		int[] result = new int[7];
		for (int i = 0; i < 7000; i++)
			result[rand7() - 1] += 1;
		
		System.out.print("distribution of 7000 rand7 values: [");
		for (int i = 0; i < result.length; i++) {
			if (i > 0)
				System.out.print(", ");
			System.out.print(result[i]);
		}
		System.out.println("]");

	}

}
