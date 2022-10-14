package com.bridgelabz.DataStructureAlgorithm;import java.util.Scanner;

/**
 * 1. Array of numbers of given range 2. Takes range from user to find number 3.
 * calculates maximum count of questions 4. Check if the users number is in
 * given range and reduces the range 5. Replaces all the integer in the array to
 * -1 as the number is not in this range
 */

public class FindYourNumber {

	int[] numberArray;
	Scanner scanner;
	int count = 0;
	int ans;
	int N;
	double maxCount = 0;

	/*
	 * Takes range from user
	 */
	void start() {
		scanner = new Scanner(System.in);
		System.out.print("Enter limit N: ");
		N = scanner.nextInt();

		numberArray = new int[N];
		for (int i = 0; i < N; i++) {
			numberArray[i] = i;
		}

		/*
		 * Calculates maximum count of questions
		 */
		maxCount = (Math.log(N) / Math.log(2));
		System.out.println("Number of tries required to guess: " + ((int) maxCount + 1));
		binarySearch(0, N - 1);
	}

	/*
	 * Check if the users number is in given range and reduces the range
	 */
	void binarySearch(int first, int last) {
		if (count < maxCount) {
			int middle = (first + last) / 2;
			count++;
			System.out.println("Is number between " + first + " and " + middle + "?");
			String temp = scanner.next();
			if (temp.equals("y")) {
				change(middle + 1, last);
				binarySearch(first, middle);
			} else if (temp.equals("n")) {
				change(first, middle);
				binarySearch(middle + 1, last);
			}
		} else {
			for (int i : numberArray) {
				if (i != -1) {
					System.out.println("The number is: " + i);
				}
			}
		}
	}

	/*
	 * Replaces all the integer in the array to -1 as the number is not in this
	 * range
	 */
	void change(int first, int last) {
		for (int i = first; i <= last; i++) {
			numberArray[i] = -1;
		}
	}

	public static void main(String[] args) {

		System.out.println("Please enter the option in yes-y and No-n formate");
		/*
		 * Creating object of class
		 */
		FindYourNumber findYourNumber = new FindYourNumber();
		/*
		 * Calling start method
		 */
		findYourNumber.start();
	}
}