package com.bridgelabz.DataStructureAlgorithm;/**
 * Program for permutation of the String using Iterative method and Recursive
 * method
 *
 */
public class Permutation {

	/**
	 * method to swap two characters in character array
	 * 
	 * @param chars - character array for String
	 * @param i     - value for row iteration
	 * @param j     - value for column iteration
	 */
	static void swap(char chars[], int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;

	}

	/**
	 * REcursive function to generate all permutations of a string
	 * 
	 * @param chars        - array of string
	 * @param currentIndex - variable for current index of char array
	 */
	public static void permutation(char chars[], int currentIndex) {
		if (currentIndex == chars.length - 1) {
			System.out.println(String.valueOf(chars));
		}
		for (int i = currentIndex; i < chars.length; i++) {
			swap(chars, currentIndex, i);
			permutation(chars, currentIndex + 1);
			swap(chars, currentIndex, i);
		}
	}

	public static void findPermutation(String str) {
		if (str == null || str.length() == 0) {
			return;
		}
		permutation(str.toCharArray(), 0);
	}

	/**
	 * Generate all permutations of a string
	 */
	public static void main(String[] args) {
		String str = "ABC";
		findPermutation(str);
	}

}