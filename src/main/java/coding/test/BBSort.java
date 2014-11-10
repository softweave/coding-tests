package coding.test;

import java.util.Random;

public class BBSort {
	
	/**
	 * naive "billiard ball" sort in place - google was not consulted
	 * @param list
	 */
	static void bbsort(int[] list) {
		for (int next = 1; next < list.length; next++) {
			int nextInt = list[next];
			for (int i = 0; i < next; i++) {
				if (nextInt < list[i]) {
					// shift list contents from i through next to the right
					for (int j = next; j > i; j--) {
						list[j] = list[j-1];
					}
					// insert nextInt in its sorted position
					list[i] = nextInt;
					break;
				}
			}
		}
	}
	
	static void print(int[] list) {
		System.out.print(list[0]);
		for (int i = 1; i < list.length; i++)
			System.out.print(", "+list[i]);
		System.out.println();
	}

	public static void main(String[] args) {
		Random gen = new Random();
		
//		int[] list1 = new int[1];
//		for (int i = 0; i < 1; i++)
//			list1[i] = gen.nextInt(10);
//		print(list1);
//		bbsort(list1);
//		print(list1);
		
		int[] list5 = new int[5];
		for (int i = 0; i < 5; i++)
			list5[i] = gen.nextInt(100);
		print(list5);
		bbsort(list5);
		print(list5);
		
		int[] list = new int[1000];
		for (int i = 0; i < 1000; i++)
			list[i] = gen.nextInt();
		long start = System.currentTimeMillis();
		bbsort(list);
		long stop = System.currentTimeMillis();
		System.out.println("bbsort of 1000 ints took "+(stop-start)+" ms");

		list = new int[10000];
		for (int i = 0; i < 10000; i++)
			list[i] = gen.nextInt();
		start = System.currentTimeMillis();
		bbsort(list);
		stop = System.currentTimeMillis();
		System.out.println("bbsort of 10000 ints took "+(stop-start)+" ms");
		
		list = new int[100000];
		for (int i = 0; i < 100000; i++)
			list[i] = gen.nextInt();
		start = System.currentTimeMillis();
		bbsort(list);
		stop = System.currentTimeMillis();
		System.out.println("bbsort of 100000 ints took "+(stop-start)+" ms");
	
	}

}
