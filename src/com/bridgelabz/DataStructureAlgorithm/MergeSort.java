package com.bridgelabz.DataStructureAlgorithm;
/**
 * Program for merge sort of the array list
 * it will divide array in 2 parts and compare elements of array and sort them 
 */
public class MergeSort {

	/*
	 * Instance Variables
	 */
	int array[];
	int tempMergeArr[];
	int length;

	public static void main(String[] args) {
		/**
		 * Input array
		 */
		int inputArr[] = { 50, 35, 13, 55, 16, 91, 25 };
		/**
		 * object of MergeSort class to call sort method
		 */
		MergeSort ms = new MergeSort();
		/**
		 * passed array in sort method to sort array
		 */
		ms.sort(inputArr);
		/**
		 * Print the array
		 */
		for (int i : inputArr) {
			System.out.println(i + " ");
		}
	}

	/**
	 * Method to sort elements
	 * 
	 * @param inputArr - input array
	 */
	public void sort(int inputArr[]) {
		this.array = inputArr;
		this.length = inputArr.length;
		this.tempMergeArr = new int[length]; // temporary array
		divideArray(0, length - 1);
	}

	/**
	 * method to divide array to get middle of the array using recursive method
	 * 
	 * @param lowerIndex  - starting index
	 * @param higherIndex - ending index
	 */
	public void divideArray(int lowerIndex, int higherIndex) {
		if (lowerIndex < higherIndex) {
			/**
			 * getting middle of the array
			 */
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// it will sort the left side of array using recursion
			divideArray(lowerIndex, middle);

			// It will sort right side of array using recursion method
			divideArray(middle + 1, higherIndex);
			/**
			 * mergeArray Method to merge the array
			 */
			mergeArray(lowerIndex, middle, higherIndex);
		}
	}

	/**
	 * Method for merge the array after sorting  
	 * @param lowerIndex - starting element
	 * @param middle - middle element
	 * @param higherIndex - end element
	 */
	public void mergeArray(int lowerIndex, int middle, int higherIndex) {
		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergeArr[i] = array[i];
		}

		/**
		 * temporary variable for not changing original array
		 */
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			/**
			 * Check if tempMergeArr[i] value is small then insert that small value in array
			 * and increment i
			 */
			if (tempMergeArr[i] <= tempMergeArr[j]) {
				array[k] = tempMergeArr[i];
				i++;
			}
			/**
			 * Check if tempMergeArr[j] value is small then insert that small value in array
			 * and increment j
			 */
			else {
				array[k] = tempMergeArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergeArr[i];
			k++;
			i++;
		}
	}
}