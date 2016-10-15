package com.cts;

public class ReverseString {

	public static void main(String[] args) {
		String originalString="Ranga";
		String reverseString;
		char[] originalChars=originalString.toCharArray();
		char[] reversechars=new char[originalString.length()];
		int size=originalString.length();
		System.out.println(size);
		for(int i=0;i<size;i++)
		{
			reversechars[i]=originalChars[(size-1-i)];
		}
		reverseString=new String(reversechars);
		System.out.println("reverseString  : "+reverseString);
		
		System.out.println(originalString.substring(3,5));
	}
}
   