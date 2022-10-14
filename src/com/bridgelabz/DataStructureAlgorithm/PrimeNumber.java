package com.bridgelabz.DataStructureAlgorithm;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println("Prime numbers range of 0 - 1000 Numbers");
        int i, j, k;	// declaring variables
        for (i = 2; i < 1000; i++) {
            k = 0;
            for (j = 2; j < i; j++) {
                if (i % j == 0) {
                    k = 1;
                    break;
                }
            }
            if (k == 0) {
                System.out.println(i);
            }
        }

    }

}