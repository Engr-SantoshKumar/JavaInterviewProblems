/* [ _Heaps_01_ ] [ Kth Smallest Element in a Sorted Matrix ]
_______________________________________________________________________________
Given an n x n matrix where each of the rows and columns are sorted in ascending order,
return the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.PriorityQueue;

public class _Heaps_01_Find_Kth_Smallest_In_Sorted_Matrix {
    public static int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);

        for(int i=0; i< rows; i++) {
            for(int j=0; j< cols; j++) {
                pq.offer(matrix[i][j]);
                if(pq.size() > k) {
                    pq.poll();
                }

            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        int[][] matrix =new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        System.out.println(kthSmallest(matrix,k));
    }
}
