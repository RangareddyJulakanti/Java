package com.cts;

public class FibonacciNumberFinder1 {

	public static void main(String[] args) {
		System.out.println("Nth Fibonacci number : " + fib(5));
	}

	private static int fib(int n) 
	{
		int a = 0;
		int b = 1;
		for (int i = 2; i <= n; i++) 
		{
			int temp = a;
			a = a + b;
			b = temp;
		}
		return a;
	}
}
