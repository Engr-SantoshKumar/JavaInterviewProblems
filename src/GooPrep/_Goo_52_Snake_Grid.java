
/*
"The snake grid.

ex:
1 6 7 12
2 5 8 11
3 4 9 10"
 */
package GooPrep;

public class _Goo_52_Snake_Grid {

    public static void snakeGrid(int [][] matrix){

        if(matrix == null || matrix.length ==0)
            return;

        int rS = 0;
        int rE = matrix.length-1;
        int cS = 0;
        int cE = matrix[0].length-1;

        while(rS<rE && cS <cE){

            // print first col from top to bottom
            for(int r = 0; r <= rE; r++){
                System.out.print(matrix[r][cS] + ", ");
            }
            cS++;

            // print next col from bottom to top
            for(int r = rE; r>=rS; r--){
                System.out.print(matrix[r][cS] + ", ");
            }
            cS++;
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 8, 9}, {2, 7, 10}, {3, 6, 11}, {4, 5, 12}};
        printMatrix(matrix);
        snakeGrid(matrix);
        System.out.println("\n");
        int[][] matrix1 = {{1, 8, 9, 16}, {2, 7, 10, 15}, {3, 6, 11, 14}, {4, 5, 12, 13}};
        printMatrix(matrix1);
        snakeGrid(matrix1);
    }

    public static void printMatrix(int [][] matrix){
        System.out.println(" = = = Given Matrix = = = ");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}


