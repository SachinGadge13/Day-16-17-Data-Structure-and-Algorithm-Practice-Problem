package com.bridgelabz.DataStructureAlgorithm;

import java.util.Scanner;

public class BubbleSort {
    static Scanner sc= new Scanner(System.in);
    public void display(int array[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void bubbleSort(int array[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort sortting = new BubbleSort();

        System.out.println("Number of elements you want for sorting..");
        int size = sc.nextInt();
        System.out.println("Please enter " + size + " element :-");

        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Before Sorting---> ");

        sortting.display(array, array.length);

        sortting.bubbleSort(array, array.length);
        System.out.print("After Sorting---> ");
        sortting.display(array, array.length);
    }
}