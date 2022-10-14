package com.bridgelabz.DataStructureAlgorithm;

import java.util.Scanner;

public class Palindrome {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number:");
        int num = sc.nextInt();
        int c = 0;
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                c++; // increment counter when the reminder is 0
            }
        }

        if (c == 1) {

            int temp = num;
            int rev = 0;
            int digit;
            while (temp > 0) {

                digit = temp % 10;
                rev = rev * 10 + digit;
                temp = temp / 10;
            }
            if (rev == num) {
                System.out.println(num + " is Prime number as well as a palindrome");
            } else {
                System.out.println(num + " is a prime number but not a palindrome");
            }
        } else {
            System.out.println("Given number is not a prime number");
        }
    }
}