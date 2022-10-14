package com.bridgelabz.DataStructureAlgorithm;

import java.util.Scanner;

public class InsertionSort {
    static Scanner sc = new Scanner(System.in);
    public void display(int array[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void insertionSort(int array[], int n) {
        for (int i = 1; i < n; i++) {
            int temp = array[i];
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > temp) {
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        InsertionSort InSort = new InsertionSort();

        System.out.println("Number of elements you want for sorting..");
        int size = sc.nextInt();
        System.out.println("Please enter " + size + " element :-");
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Before insertionSort the array elements55 : ");
        InSort.display(array, array.length);
        InSort.insertionSort(array, array.length);
        System.out.println("After insertionSort the array elements : ");
        InSort.display(array, array.length);

    }
}