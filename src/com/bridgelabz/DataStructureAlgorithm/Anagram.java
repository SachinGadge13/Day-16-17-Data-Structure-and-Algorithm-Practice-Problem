package com.bridgelabz.DataStructureAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting the input string from the user
        System.out.print("Enter the First String : ");
        String s1 = scanner.nextLine();

        System.out.print("Enter the second String : ");
        String s2 = scanner.nextLine();

        if (checkAnagram(s1, s2))
            System.out.println(s1 + " and " + s2 + " are Anagrams");
        else
            System.out.println(s1 + " and " + s2 + " are NOT Anagrams");

    }

    public static boolean checkAnagram(String s1, String s2) {
        // Remove all the white space
        s1 = s1.replaceAll("\\s", "");
        s2 = s2.replaceAll("\\s", "");

        // Check if both length matches
        if (s1.length() != s2.length())
            return false;
        else {
            // Convert both Strings into lower case and into Character Array
            char[] arr1 = s1.toLowerCase().toCharArray();
            char[] arr2 = s2.toLowerCase().toCharArray();

            // Sort both Character Array
            Arrays.sort(arr1);
            Arrays.sort(arr2);

            // Check if both arrays are equal
            return (Arrays.equals(arr1, arr2));
        }
    }
}