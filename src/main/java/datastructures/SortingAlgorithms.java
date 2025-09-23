package datastructures;

import java.util.Arrays;

public class SortingAlgorithms {

    /**
     * Bubble Sort Algorithm
     * The algorithm works by repeatedly stepping through the list to be sorted,
     * comparing each pair of adjacent items and swapping them if they are in the wrong order.
     * The pass through the list is repeated until no swaps are needed, which means the list
     * is sorted.
     * 
     * @param arr the array to be sorted
     */
    public static void bubbleSort(int[] arr) {

        //This algorithm brings the least number to the front of the array
        // with each iteration of the inner loop
        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                if(arr[i]>arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * Selection Sort Algorithm
     * The algorithm works by dividing the array into a sorted and unsorted part.
     * The sorted part is built up from left to right, and the smallest element from the unsorted part
     * is selected and swapped with the leftmost unsorted element, moving the boundary between the
     * sorted and unsorted parts one position to the right.
     * 
     * @param array the array to be sorted
     */
    public static void selectionSort(int[] array) {
        // Outer loop: Iterate through all elements in the array
        for (int i = 0; i < array.length; i++) {

            // Initialize minIndex to store the index of the element at index i
            int minIndex = i;

            // Inner loop: Iterate through the remaining unsorted elements
            for (int j = i + 1; j < array.length; j++) {

                // Check if the current element is smaller than the element at minIndex
                if (array[j] < array[minIndex]) {

                    // Update minIndex with the index of the new smallest element found
                    minIndex = j;
                }
            }

            // Check if the smallest element found is not already in its correct position
            if (i != minIndex) {

                // Swap the smallest element found with the element at the current boundary
                // Store the element at the current boundary in a temporary variable
                int temp = array[i];

                // Move the smallest element found to its correct position in the sorted part
                array[i] = array[minIndex];

                // Move the element previously at the boundary to the position of the smallest element
                array[minIndex] = temp;
            }
        }
    }

    public static void insertionSort(int[] array) {
        // Outer loop: Iterate through all elements in the array, starting from the second element
        for (int i = 1; i < array.length; i++) {

            // Store the first element in the unsorted part of the array in a temporary variable
            int temp = array[i];

            // Initialize j to store the index of the last element in the sorted part of the array
            int j = i - 1;

            // Inner loop: Check whether the temporary value should be inserted in the sorted part
            while (j > -1 && temp < array[j]) {

                // Shift the element at index j one position to the right in the sorted part
                array[j+1] = array[j];

                // Assign the temporary value to the element at the index j
                array[j] = temp;

                // Decrement j to move towards the beginning of the sorted part of the array
                j--;
            }
        }
    }

    //MERGE SORT
    public static int[] mergeSort(int[] array) {
        // Base case: If the input array has only one element, it
        // is already sorted, so return the array as is.
        if (array.length == 1) return array;

        // Find the middle index of the array by dividing its length by 2.
        int midIndex = array.length/2;

        // Recursively call the mergeSort method on the left half of the array.
        // The Arrays.copyOfRange method is used to create a new array containing
        // the elements from index 0 (inclusive) to the middle index (exclusive).
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));

        // Recursively call the mergeSort method on the right half of the array.
        // The Arrays.copyOfRange method is used to create a new array containing the
        // elements from the middle index (inclusive) to the end of the array (exclusive).
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        // Merge the two sorted halves (left and right) using the merge method,
        // and return the resulting sorted array.
        return merge(left, right);
    }

    public static int[] merge(int[] array1, int[] array2) {
        // Create a new combined array with a size equal to the sum
        // of the lengths of the input arrays
        int[] combined = new int[array1.length + array2.length];

        // Initialize index, i, and j to keep track of positions
        // in combined, array1, and array2 respectively
        int index = 0;
        int i = 0;
        int j = 0;

        // Merge elements from both arrays until one of them reaches its end
        while (i < array1.length && j < array2.length) {
            // If the current element in array1 is smaller, add it to the combined array
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                index++;
                i++;
            } else {
                // Otherwise, add the current element from array2 to the combined array
                combined[index] = array2[j];
                index++;
                j++;
            }
        }

        // If there are remaining elements in array1, add them to the combined array
        while (i < array1.length) {
            combined[index] = array1[i];
            index++;
            i++;
        }

        // If there are remaining elements in array2, add them to the combined array
        while (j < array2.length) {
            combined[index] = array2[j];
            index++;
            j++;
        }

        // Return the final merged and sorted combined array
        return combined;
    }

    //QUICK SORT
    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length-1);
    }

    public static void quickSortHelper(int[] arr, int start, int end) {
        if(start<end) {
            int pivot = pivot(arr,start,end);
            quickSortHelper(arr,start,pivot);
            quickSortHelper(arr,pivot+1,end);
        }
    }

    public static void main(String[] args) {

        int[] myArray = {4,2,6,5,1,3};
        bubbleSort(myArray);
        System.out.println(Arrays.toString(myArray));
        myArray = new int[]{5,7,9,10,1,3,4,2};
        selectionSort(myArray);
        System.out.println(Arrays.toString(myArray));
        myArray = new int[]{0,5,7,9,8,1,3,4,2,6,10};
        insertionSort(myArray);
        System.out.println(Arrays.toString(myArray));

        int[] originalArray = {3,1,4,2};
        int [] sortedArray = mergeSort(originalArray);
        System.out.println( "Original Array: " + Arrays.toString( originalArray ) );
        System.out.println( "\nSorted Array: " + Arrays.toString( sortedArray ) );

        myArray = new int[]{4,6,1,7,3,2,5};
        quickSort(myArray);
        System.out.println( "After Quick Sort: "+Arrays.toString( myArray ) );
    }
}
