/* [ _ModifiedBinarySearch_01_ ] [ 74. Search a 2D Matrix ]
_______________________________________________________________________________
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following
properties:

NOTE SOME POINTS TO BS
1. always use start+(end-start) to fins mid, start+end will cause an overflow
2. When do you use while (start<end) , when do you use while (start<=end)?
  -->  You use while (start <= end) if you are returning the match from inside the loop.
  -->  You use while (start < end) if you want to exit out of the loop first, and then use the result
        of start or end to return the match.

Logic: One could notice that the input matrix r x c could be considered as a sorted array of length r x c.

                    ↙---c---↘
                1     3     5     6
           r    7     8     9     12
                15    16    18    25


        1  3  5  6  7  8  9  12  15  16  18  25
        ↑              ↓                       ↑
       0th             ↓                     r x c -1
                       ↓
                       ↓
                 5th index in arr => row -> 5/c => 5/4 => 1
                                     col -> 5%c => 5%4 => 1


*/
package _00_Problems_Sorted_By_Patterns;
public class _ModifiedBS_01_Search_2D_Matrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row==0)return false;
        int col = matrix[0].length;
        int start = 0;
        int end = row*col-1;

        while(start<=end){
            int midIndex = (start+end)/2;
            //convert integer mid to row,col: r=mid/col and col= mid%col
            int midValue = matrix[midIndex/col][midIndex%col];
            if(target==midValue)
                return true;

            //check which pointer to move
            if(target<midValue){
                end = midIndex-1;
            }else{
                start = midIndex+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}};

        System.out.println(searchMatrix(matrix, 3));
    }
}
