package coding.test;

/**
 * The maximum subarray problem is the task of finding the contiguous subarray
 * within a one-dimensional array of numbers (containing at least one positive
 * number) which has the largest sum. 
 * 
 * This application implements two variations of Kadane's linear time algorithm.
 * 
 * See:
 * http://en.wikipedia.org/wiki/Maximum_subarray_problem
 */

public class MaxSubarray {
	

	static int findMaxSubarraySum(final int[] array) {
		int max = 0;
		int maxEndingHere = 0;
		for (int i = 0; i < array.length; i++) {
			int x = array[i];
			if (maxEndingHere + x > 0) {
				maxEndingHere += x;
			} else {
				maxEndingHere = 0;
			}
			if (max < maxEndingHere) {
				max = maxEndingHere;
			}
		}
		return max;
	}

	static int[] findMaxSubarray(final int[] array) {
		int max = 0;
		int maxEndingHere = 0;
		int begin = 0, end = 0, tmp = 0;
		for (int i = 0; i < array.length; i++) {
			int x = array[i];
			if (maxEndingHere <= 0) {
				maxEndingHere = x;
				tmp = i;
			} else {
				maxEndingHere += x;
			}
			if (max < maxEndingHere) {
				max = maxEndingHere;
				begin = tmp;
				end = i;
			}
		}
		int[] subarray = null;
		if (max > 0) {
			subarray = new int[end-begin +1];
			for (int i = begin, j = 0; i <= end; i++, j++)
				subarray[j] = array[i];
		}
		return subarray;
	}

	public static void main(String[] args) {
		int[] array = { 2, 1, -3, 4, -1, 2, 1, -5, 4 };
		
		int max = findMaxSubarraySum(array);
		System.out.println("sum of max subarray: " + max);
		
		int[] subarray = findMaxSubarray(array);
		System.out.print("max subarray: [");
		for (int i = 0; i < subarray.length; i++) {
			if (i > 0)
				System.out.print(", ");
			System.out.print(subarray[i]);
		}
		System.out.println("]");
	}

}
