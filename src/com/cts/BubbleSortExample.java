package com.cts;

public class BubbleSortExample {

	public static void main(String[] args) {

		int array[] = { 10,9,8,7,6,5,4,3,2,1};
		int n = array.length;
		
		System.out.println("Before Sorting: ");
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " , ");
		}

		int tmp;
		for (int i = 0; i < (n - 1); i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}

		System.out.println("\nAfter Sorting: ");

		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " , ");
		}
	}
	
}
