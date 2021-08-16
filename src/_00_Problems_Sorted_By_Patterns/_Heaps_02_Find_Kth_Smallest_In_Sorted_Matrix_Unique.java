/* [ _Heaps_01_ ] [ Kth Smallest Element in a Sorted Matrix Unique ]
_______________________________________________________________________________
Given an n x n matrix where each of the rows and columns are sorted in ascending order,
return the kth smallest element in the matrix. (unique)


Input: matrix =     [[1,5,9],
                    [1,10,13],
                    [1,13,15]],
       k = 2
Output: 5
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class _Heaps_02_Find_Kth_Smallest_In_Sorted_Matrix_Unique {
    public static int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        Set<Integer> set = new HashSet<>();
        for(int i=0; i< rows; i++) {
            for(int j=0; j< cols; j++) {
                if(pq.size() < k && !set.contains(matrix[i][j])) {
                    pq.offer(matrix[i][j]);
                    set.add(matrix[i][j]);
                }else {
                    if(!set.contains(matrix[i][j])){
                        pq.offer(matrix[i][j]); //--> adding incoming
                        pq.poll();  // removing top to keep pq size == k
                    }
                }

            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        int[][] matrix =new int[][]{{1,5,9},{1,11,13},{1,13,15}};
        int k = 2;
        System.out.println(kthSmallest(matrix,k));
    }
}

