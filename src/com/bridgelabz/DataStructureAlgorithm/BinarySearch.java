package com.bridgelabz.DataStructureAlgorithm;

import java.util.Arrays;

public class BinarySearch {
    public static void binarySearch(String arr[], int first, int last, String key) {

        while (first <= last) {
            int mid = (first + last) / 2;
            if (key.compareTo(arr[mid]) == 0) {
                System.out.println("Element is found at location: " + mid);
                break;
            } else if (key.compareTo(arr[mid]) < 0) {
                last = mid - 1;
                System.out.println("Element is found at location: " + last);
                break;
            } else {
                first = mid + 1;
                System.out.println("Element is found at location: " + first);
                break;
            }


        }

    }

    public static void main(String args[]) {
        String arr[] = { "Pulsar", "Dominar", "Ducati", "RoyalEnfield", "Triumph", "BMW", "Benelli" };
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        String key = "Suzuki";
        int last = arr.length - 1;
        binarySearch(arr, 0, last, key);

    }

}