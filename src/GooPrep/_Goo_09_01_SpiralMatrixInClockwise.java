/** 09 _01 [Spiral Matrix In Clockwise ]
-------------------------------------------------------------------------------------------------------
 * Q: Write a function that takes in a matrix and outputs it in spiral order. Eg,
 * 1 2 3
 * 4 5 6 ---> 1 2 3 6 9 8 7 4 5
 * 7 8 9
 */
package GooPrep;
public class _Goo_09_01_SpiralMatrixInClockwise {

    public static void printSpiralMatrix(int [][] matrix){

        if(matrix == null || matrix.length ==0)
            return;

        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix[0].length -1;

        System.out.println("\n\n  = = = Printing Spiral = = = =     ");

        while(rowStart <= rowEnd && colStart <= colEnd){

            // Going RIGHT -->
            for(int i = colStart; i<=colEnd; i++){
                System.out.print(matrix[rowStart][i] + ", ");
            }
                rowStart ++; /* incrementing rowStart as 1st row is done */

            /** going down */

            for(int i = rowStart; i <= rowEnd; i++){
                System.out.print(matrix[i][colEnd] + ", ");
            }
                colEnd --; /* decrementing colEnd as last col is done */

            // Going Left
            for(int i = colEnd; i>= colStart; i--){
                System.out.print(matrix[rowEnd][i] + ", ");
            }
                rowEnd --; /* decrementing rowEnd as last row is done */

            /** Going up */
            for(int i = rowEnd; i>= rowStart; i --){
                System.out.print(matrix[i][colStart] + ", ");
            }
                colStart++; /* first col is done */
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {12, 13, 14, 15}};
        printMatrix(matrix);
        printSpiralMatrix(matrix);
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

