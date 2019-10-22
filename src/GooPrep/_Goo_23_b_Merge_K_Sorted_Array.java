/**
[23 -B] [Merge K Sorted Arrays in Java ]
-----------------------------------------------------------------------------------------------------
PROBLEM STATEMENT: Merge k sorted array and return it as one sorted list. Analyze and describe its complexity.
TIME COMPLEXITY: This problem can be solved by using a heap. The time complexity is kn * log(K),
where n is the total number of elements and k is the number of arrays.
 */
package GooPrep;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _Goo_23_b_Merge_K_Sorted_Array {
    public static int[] mergeKSortedArray(int[][] arr) {

        PriorityQueue<pqNodes> pq = new PriorityQueue<>((a,b) -> a.value -b.value);
        int resultSize =0;

        //Step 1: add fist element from each array to pq also get the size of each array to store result
        for(int i =0; i<arr.length; i++){
            resultSize+=arr[i].length;

            if(arr[i].length >0){
                pq.add(new pqNodes(i, 0, arr[i][0] ));
            }
        }

        int[] result = new int[resultSize];

        // Step 2: remove the node from pq add to result and also add the next element of removed element's array to pq
        for(int i =0; !pq.isEmpty(); i++){
            pqNodes n = pq.poll();
            result [i] = n.value;

            // add next element to pq
            int nextIndex = n.index +1 ; //current index + 1
            if(nextIndex < arr[n.array].length){//check if its the last element
                pq.add(new pqNodes(n.array, nextIndex, arr[n.array][nextIndex]));
            }
        }
       return result;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };

        int[] result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
        System.out.println(Arrays.toString(result));
    }

    //node class for priorityQueue with Comparable to compare its self to other pqNodes
    static class pqNodes {
        int array;
        int index;
        int value;

        public pqNodes(int array, int index, int value){
            this.array = array;
            this.index = index;
            this.value = value;
        }
    }

}


