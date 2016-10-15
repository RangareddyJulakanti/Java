package com.cts;

public class SecondLargestNumberFinder {

	private static int findSecondLargestNumber(int[] arr) {
		int len = arr.length;

		if (len < 2)
			throw new RuntimeException("Array length is less than 2.");

		int l1, l2;
		l1 = l2 = arr[0];

		for (int i = 1; i < len; i++) {
			if (arr[i] > l1) {
				l2 = l1;
				l1 = arr[i];
			} else if (arr[i] > l2) {
				l2 = arr[i];
			}
		}

		if (l1 == l2)
			throw new RuntimeException(
					"There is no second largest element in the array.");

		return l2;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 7, 3, 4,9, 8, 6, 6,10, 11, 5 };

		try {
			System.out.println("Second largest number is: "
					+ findSecondLargestNumber(arr));
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
