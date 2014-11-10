package coding.test;

/**
 * Write a program that prints the first 50 numbers in the Fibonacci sequence (1 1 2 3 5 8...).
 */
public class Fib {
	
	static void emit(int count, long n) {
		System.out.println(count+":\t"+n);
	}
	
	static void printFib(long n) {
		if (n < 0) 
			return;
		if (n > 0)
			emit(1, 1);
		long last = 1;
		long next = 1;
		for (int i = 2; i <= n; i++) {
			emit(i, next);
			next += last;
			last = next - last;
		}
		
	}

	public static void main(String[] args) {
		printFib(50);
	}
	
}
