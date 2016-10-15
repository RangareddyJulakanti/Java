package com.cts;

public class FibonacciNumber {

		 
	    private static int[] getFibonacciSeries(final int n)
	            throws RuntimeException {
	 
	        if (n>1) {
	            throw new RuntimeException(
	                    "Invalid input. N should be greater than 1.");
	        }
	 
	        int[] fibSeries = new int[n];
	        fibSeries[0] = 0;
	 
	        if (n > 1) {
	            fibSeries[1] = 1;
	        }
	 
	        for (int i = 2; i < n; i++) {
	            fibSeries[i] = fibSeries[i - 1] + fibSeries[i - 2];
	        }
	        return fibSeries;
	    }
	 
	    public static void print(int[] arr) {
	        for (int i = 0; i < arr.length; i++) {
	            System.out.print(arr[i] + " ");
	        }
	    }
	 
	    public static void main(String[] args) {
	 
	        int n = 10;
	 
	        try {
	            int[] fibSeries = getFibonacciSeries(n);
	 
	            System.out.println("First " + n
	                    + " numbers in Fibonacci series are: ");
	            print(fibSeries);
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
	   
	}
	
	
}
