package coding.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Prints Pascal's triangle to various depths to the console.
 */
public class PascalsTriangle {
	
	static void printTriangle(int depth, boolean emit) {
		System.out.println("\nprintTriangle: print Pascal's Triangle for depth = "+depth);
		if (emit && depth > 0)
			System.out.println(1);
		if (emit && depth > 1)
			System.out.println("1\t1");
		if (depth > 2) {
			final Long one = new Long(1);
			List<Long> prev = new ArrayList<Long>(2);
			prev.add(0, one);
			prev.add(1, one);
			for (int i = 3; i <= depth; i++) {
				
				// create next row of triangle and initialize with ones
				List<Long> next = new ArrayList<Long>(i);
				for (long n = 0; n < i; n++) {
					next.add(one);
				}
				
				// set interior elements of row to be sums of the previous row's elements
				for (int j = 1; j < i - 1; j++) {
					next.set(j, prev.get(j - 1 ) + prev.get(j));
				}
				
				// output next row
				if (emit) {
					for (Long k : next) {
						System.out.print(k);
						System.out.print("\t");
					}
					System.out.println();
				}
				
				prev = next;
			}
		}

	}

	static void printTriangle2(int depth, boolean emit) {
		System.out.println("\nprintTriangle2: print Pascal's Triangle for depth = "+depth);
		if (emit && depth > 0)
			System.out.println(1);
		if (emit && depth > 1)
			System.out.println("1\t1");
		if (depth > 2) {
			long[] prev = new long[depth];
			prev[0] = 1;
			prev[1] = 1;
			
			long[] next = new long[depth];			
			for (long i = 3; i <= depth; i++) {
				
				// create next row of triangle and initialize with ones
				for (int n = 0; n < i; n++) {
					next[n] = 1;
				}
				
				// set interior elements of next row to be sums of the previous row's elements
				for (int j = 1; j < i - 1; j++) {
					next[j] = prev[j - 1] + prev[j];
				}
				
				// output next row
				if (emit) {
					for (int k = 0; k < i; k++) {
						System.out.print(next[k]);
						System.out.print("\t");
					}
					System.out.println();
				}
				
				// next row values become previous row values
				long[] swap = prev;
				prev = next;
				next = swap;
			}
		}
	}
	
	// modified solution from http://wiki.answers.com/Q/Program_to_generate_a_pascal_triangle_using_java
	static void printTriangle3(int depth, boolean emit) {
		System.out.println("\nprintTriangle3: print Pascal's Triangle for depth = "+depth);
		
		long triangle[][] = new long[depth][depth];
		for (int i = 0; i < depth; i++) {
			for (int j = 0; j < depth; j++) {
				triangle[i][j] = 0;
			}
		}
		for (int i = 0; i < depth; i++) {
			triangle[i][0] = 1;
		}
		for (int i = 1; i < depth; i++) {
			for (int j = 1; j < depth; j++) {
				triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
			}
		}
		if (emit) {
			for (int i = 0; i < depth; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(triangle[i][j]);
					System.out.print("\t");
				}
				System.out.println();
			}	
		}
	}
	
	public static void main(String[] args) {
		printTriangle(-24, true);
		printTriangle(1, true);
		printTriangle(2, true);
		
		printTriangle(5, true);
		printTriangle2(5, true);
		printTriangle3(5, true);

		int depth = 5000;
		long start = System.currentTimeMillis();
		printTriangle(depth, false);
		long stop = System.currentTimeMillis();
		System.out.println("printTriangle using ArrayList<Long> took "+(stop-start)+" ms");

		start = System.currentTimeMillis();
		printTriangle2(depth, false);
		stop = System.currentTimeMillis();
		System.out.println("printTriangle2 using long[] took "+(stop-start)+" ms");
		
		start = System.currentTimeMillis();
		printTriangle3(depth, false);
		stop = System.currentTimeMillis();
		System.out.println("printTriangle3 using long[][] took "+(stop-start)+" ms");
	}

}

