package arrays;

import java.util.*;

/**
 * 1089. Duplicate Zeros(Easy)
 * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * Example 2:
 *
 * Input: arr = [1,2,3]
 * Output: [1,2,3]
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 9
 * Hint-1. This is a great introductory problem for understanding and working with the concept of in-place operations.
 *      The problem statement clearly states that we are to modify the array in-place.
 *      That does not mean we cannot use another array. We just don't have to return anything.
 *
 * Hint-2.  A better way to solve this would be without using additional space.
 *      The only reason the problem statement allows you to make modifications in place is that it hints at avoiding any additional memory.
 * Hint-3. The main problem with not using additional memory is that we might override elements
 *          due to the zero duplication requirement of the problem statement. How do we get around that?
 *
 * Hint 4-  If we had enough space available, we would be able to accommodate all the elements properly.
 *   The new length would be the original length of the array plus the number of zeros. Can we use this information somehow to solve the problem?
 */
public class DuplicateZeros {

    /**
     *  One pass == In place -> using queue to assist us.
     *  Time complexity = O(N) Linear time and space complexity also O(N)
     *  steps -
     *  scan all elements in the array (loop through) {
     *        if the current element is zero then add 2 zeros to the queue
     *        else add the current element to the queue
     *
     *        Then update the current element by pop up element from the queue
     *  }
     *
     */
    public int [] duplicateZerosQueue(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                //add two zero in the queue
                queue.add(0);
                queue.add(0);
            }else{
                queue.add(arr[i]); // add the current element in the queue
            }
            //modify the current element
            Integer first = queue.poll();
            arr[i] = first;
        }
        return arr;
    }
    /**
     * Solve using two pass and one pass
     */


    public static void main(String[] args) {
        DuplicateZeros duplicateZeros = new DuplicateZeros();

        Arrays.stream(duplicateZeros.duplicateZerosQueue(new int[]{1,0,2,3,0,4,5,0})).forEach(System.out::print);
        System.out.println(" ");
        Arrays.stream(duplicateZeros.duplicateZerosQueue(new int[]{1,2,3})).forEach(System.out::print);
    }
}
