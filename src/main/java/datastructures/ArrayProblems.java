package datastructures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class ArrayProblems {

    /**
     * This method removes all occurrences of the element 'k' from the array 'nums'.
     * It uses a two-pointer technique to achieve this in O(n) time complexity.
     * The first pointer (readPointer) traverses the array, while the second pointer (writePointer)
     * keeps track of the position to write the next non-'k' element.
     * After processing, it returns a new array containing only the elements that are not equal to 'k'.
     * 
     * The algorithm works as follows:
     * 1. Initialize a write pointer at the start of the array.
     * 2. Iterate through the array with a read pointer.
     * 3. For each element, check if it is equal to 'k'.
     * 4. If it is not equal to 'k', write it at the position of the write pointer and increment the write pointer.
     * 5. After the loop, return a copy of the array from the start to the write pointer.
     * 
     * @param nums the input array from which elements equal to 'k' need to be removed
     * @param k the element to be removed from the array
     * @return a new array containing all elements of 'nums' except those equal to 'k'
     */
    public static int[] removeElements(int[] nums, int k) {
        // Check if the array is empty. If so, return 0.
        if (nums.length == 0) {
            return null;
        }

        // Initialize the write pointer at the first index.
        int writePointer = 0;

        // Loop through the array starting from the first element.
        for (int readPointer=0; readPointer<nums.length;readPointer++)
            // If the current element is not equal to k
            // Write it at the position of the write pointer.
            // Move the writePointer forward
            if (nums[readPointer] != k) {
                nums[writePointer++] = nums[readPointer];
            }

        // Return a copy of the array until the writePointer.
        // This would be the array without the element 'k'
        return Arrays.copyOfRange(nums,0, writePointer);
    }

    /**
     * This method removes duplicates from a sorted array in-place.
     * It uses a two-pointer technique to achieve this in O(n) time complexity.
     * The first pointer (readPointer) traverses the array, while the second pointer (writePointer)
     * keeps track of the position to write the next unique element.
     * After processing, it returns a new array containing only the unique elements.
     * 
     * The algorithm works as follows:
     * 1. Check if the array is empty. If so, return null.
     * 2. Initialize a write pointer at the first index.
     * 3. Loop through the array starting from the second element.
     * 4. For each element, check if it is different from the previous element.
     * 5. If it is different, write it at the position of the write pointer
     *    and increment the write pointer.
     * 6. After the loop, return a copy of the array from the start to the write pointer.
     * 
     * @param nums the input sorted array from which duplicates need to be removed
     * @return a new array containing all unique elements of 'nums'
     */
    public static int[] removeDuplicates(int[] nums) {
        // Check if the array is empty. If so, return 0.
        if (nums.length == 0) {
            return null;
        }

        // Initialize the write pointer at the first index.
        int writePointer = 1;

        // Loop through the array starting from the second element.
        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            // If the current element isn't a duplicate of the previous one
            if (nums[readPointer] != nums[readPointer - 1]) {
                // Write it at the position of the write pointer.
                nums[writePointer] = nums[readPointer];
                // Then, move the write pointer one step forward.
                writePointer++;
            }
        }

        // Return a copy of the array until the writePointer.
        return Arrays.copyOfRange(nums,0, writePointer);
    }

    /**
     * This method rotates an array to the right by 'k' positions.
     * It uses a three-step reversal algorithm to achieve this in O(n) time complexity.
     * The algorithm works as follows:
     * 1. Reverse the first n-k elements.
     * 2. Reverse the last k elements.
     * 3. Reverse the entire array.
     * 
     * @param nums the input array to be rotated
     * @param k the number of positions to rotate the array
     */
    public static void rotate(int[] nums, int k) {
        k = k%nums.length; //cases where k>arr.length
        int n = nums.length;
        // Swap numbers from 0 till n-k-1 iteratively
        reverse(nums, 0, n-k-1);
        // Swap numbers from n-k till end of the array
        reverse(nums, n-k, n-1);
        // Swap numbers from 0 till end of the array
        reverse(nums, 0, n-1);
    }

    /**
     * This helper method reverses a portion of the array from 'start' to 'end'.
     * It uses a two-pointer technique to swap elements until the pointers meet.
     * 
     * The algorithm works as follows:
     * 1. Initialize two pointers: one at the start index and one at the end index.
     * 2. While the start pointer is less than the end pointer:
     *   - Swap the elements at the start and end pointers.
     *   - Move the start pointer one step forward and the end pointer one step backward.
     *  This effectively reverses the elements in the specified range.
     * 
     * @param nums the input array
     * @param start the starting index of the portion to be reversed
     * @param end the ending index of the portion to be reversed
     */
    private static void reverse(int[] nums, int start, int end) {
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * This method finds the k-th maximum element in an array using a min-heap.
     * It maintains a min-heap of size 'k' to keep track of the k largest elements.
     * The algorithm works as follows:
     * 1. Initialize a min-heap.
     * 2. Iterate through each element in the array:
     *   - Add the element to the min-heap.
     *   - If the size of the min-heap exceeds 'k', remove the smallest element (the root of the min-heap).
     * 3. After processing all elements, the root of the min-heap will be the k-th maximum element.
     * 
     * @param arr the input array from which the k-th maximum element needs to be found
     * @param k the position of the maximum element to find (1-based index)
     * @return the k-th maximum element in the array
     */
    public static int findKthMaximumElement(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int j : arr) {
            minHeap.add(j);

            if(minHeap.size()>k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    /**
     * This method finds the k-th minimum element in an array using a max-heap.
     * It maintains a max-heap of size 'k' to keep track of the k smallest elements.
     * The algorithm works as follows:
     * 1. Initialize a max-heap.
     * 2. Iterate through each element in the array:
     *   - Add the element to the max-heap.
     *   - If the size of the max-heap exceeds 'k', remove the largest element (the root of the max-heap).
     * 3. After processing all elements, the root of the max-heap will be the k-th minimum element. 
     * 
     * @param arr the input array from which the k-th minimum element needs to be found
     * @param k the position of the minimum element to find (1-based index)
     * @return the k-th minimum element in the array
     */
    public static int findKthMinimumElement(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int j : arr) {
            maxHeap.add(j);

            if(maxHeap.size()>k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    // Driver code
    public static void main(String[] args) {
        int[] a = { 3, 9, 2, 3, 1, 7, 2, 3, 5 };
        int k = 3;
        a = removeElements(a, k);
        System.out.println(Arrays.toString(a));

        int[] dupArray = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        a = removeDuplicates(dupArray);
        System.out.println(Arrays.toString(a));

        int[] array = {1,2,3,4,5,6,7,8,9};
        rotate(array, k);
        System.out.println(Arrays.toString(array));

        int[] arr = {10,3,4,9,8,6,11,2,1};
        System.out.println(findKthMaximumElement(arr, 3));
        System.out.println(findKthMinimumElement(arr, 4));

    }
}
