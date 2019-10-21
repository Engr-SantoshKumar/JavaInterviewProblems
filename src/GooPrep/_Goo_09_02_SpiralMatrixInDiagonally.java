/** 09 _02 [Spiral Matrix Diagonally ]
 -------------------------------------------------------------------------------------------------------
 * Q: Write a function that takes in a matrix and outputs it in spiral order. Eg,
 *          1   2   3   4
 *          5   6   7   8
 *          9   10  11  12
 *          13  14  15  16
 *
outPut
 1
 5 2
 9 6 3
 13 10 7 4
 14 11 8
 15 12
 16

 Logic : if you see, each one is starting from col 0(leftHandSide) and ending at row 0(topRow)
         and than each one starting at rowMax(bottom) and ending at colMax(Right Side)
            if we notice in both cases
            --> row is decreasing and col is increasing as we move up

        so, basically need two loop to cover both scenarios

 */
package GooPrep;
public class _Goo_09_02_SpiralMatrixInDiagonally {

    private static void printMatrixDiagonally(int[][] matrix){

        //base cases
        if(matrix.length==0 && matrix[0].length == 0) {
            System.out.println("Matrix is blank");
        }

        int rowEnd = matrix.length;
        int colEnd = matrix[0].length;

        //lets print lines which are starting from leftHandSideCol and ending at top
        for(int k = 0; k<rowEnd; k++){
            int i = k;
            int j = 0;
            while(i>=0){  /*Using I here */
                System.out.print(matrix[i][j] + " ");
                //row is decreasing and col is increasing as we move up
                i--;
                j++;
            }
            System.out.println();
        }
        //lets print lines which are starting from bottom and ending at rightSide
        for(int k = 1; k < colEnd; k++){
            int i = rowEnd-1;
            int j = k;
            while(j<colEnd){   /*Using J here */
                System.out.print(matrix[i][j]+ " ");
                //row is decreasing and col is increasing as we move up
                i--;
                j++;
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {12, 13, 14, 15}};
        printMatrix(matrix);
        printMatrixDiagonally(matrix);
    }

    public static void printMatrix(int [][] matrix){
        System.out.println(" = = = Given Matrix = = = ");
        for(int r=0; r < matrix.length; r++ ){
            for(int c=0; c < matrix[r].length; c++){
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
