/* [  ] [ Search a 2D Matrix II ]
_______________________________________________________________________________
Write an efficient algorithm that searches for a target value in an m x n integer matrix.
The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Input: matrix = [[1,   4,   7,   11,   15],
                 [2,   5,   8,   12,   19],
                 [3,   6,   9,   16,   22],
                 [10,  13,  14,  17,   24],
                 [18,  21,  23,  26,   30]],

                 target = 21
Output: true
*/
package _00_Problems_Sorted_By_Patterns;
public class _ModifiedBS_07_Search_2D_Matrix_II {
    /*
    Points to observe: search 21
         ○  As given each rows and cols are sorted
         ○  suppose if we are at right top corner in given e.g which is --> 15
                - 15 < 21, which means there is no way 21 will be in this row as the larges element of this row is 15
                - so discard this row, how row ++
         ○  after row ++ right top corner will have element 19 .. same case as above, row ++
         ○  now we have 22 at topRightCorner
                - now there is a possibility 21 can be in this row
                - but for sure it will be not in this col as min (22) > target(21) so we can do col --
     */

    public static boolean searchMatrix(int[][] matrix, int target) {
        //base cases
        if(matrix.length == 0 || matrix[0].length ==0)
            return false;

        //now what we need to travers matrix from right corner
        int row =0, col = matrix[0].length-1;

        while(row < matrix.length && col >=0){
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] < target) // discarding row are end element is smaller than T
                row++;
            else if(matrix[row][col] > target){ // discarding col are end element is grater than T
                col --;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,   4,   7,   11,   15},
                {2,   5,   8,   12,   18},
                {3,   6,   9,   16,   22},
                {10,  13,  14,  17,   24},
                {18,  21,  23,  26,   30},};

        System.out.println(searchMatrix(matrix, 19));
    }

}
