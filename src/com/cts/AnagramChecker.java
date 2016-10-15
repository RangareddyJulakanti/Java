package com.cts;

import java.util.Arrays;

public class AnagramChecker {

	private static boolean isAnagram(String str1, String str2) {

		// If string lengths are not same, the strings are not anagrams.
		if (str1.length() != str2.length()) {
			return false;
		}

		// Sort characters of both the strings.
		str1 = sortCharacters(str1);
		str2 = sortCharacters(str2);

		// After sorting if strings are equal then they are anagrams.
		return str1.equals(str2);
	}

	private static String sortCharacters(String str) {
		char[] charArray = str.toLowerCase().toCharArray();
		Arrays.sort(charArray);
		return String.valueOf(charArray);
	}

	public static void main(String[] args) {
		String str1 = "Robin";
		String str2 = "binro";
		if (isAnagram(str1, str2)) {
			System.out.println(str2 + " is anagram of " + str1);
		} else {
			System.out.println("Strings are not anagrams.");
		}
	}
}