package coding.test;

/**
 * Program that demonstrates the Euclidean algorithm for computing the greatest common divisor of two positive integers.
 */
public class GCD {

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static void main(String[] args) {
		assert(gcd(51, 34) == 17);
		assert(gcd(51, 81) == 3);
		assert(gcd(51, 0) == 51);
	}

}
