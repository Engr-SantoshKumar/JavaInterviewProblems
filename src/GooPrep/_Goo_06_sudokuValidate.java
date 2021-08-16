/** 06 [Valid Sudoku]
 -------------------------------------------------------------------------------------------------------
 * Write a method that determines if a Sudoku puzzle is solved correctly
 * validate box 3X3 logic:
 *  when r =0 and c =0
 *  call will be like (0*3, 0*3+2, 0*3, 0*3+2, box) -> (0,2,0,2,box) -> this is top left box
 *  when r =0 and c =1
 *  call will be like (0*3, 0*3+2, 1*3, 1*3+2, box) -> (0,2,3,5,box) -> this is top middle box
 *  similarly: when r = 1, c= 1
 *  call will be like (1*3, 1*3+2, 1*3, 1*3+2, box) -> (3,5,3,5,box) -> this is top middle row middle box
 */

package GooPrep;

import java.util.HashSet;
import java.util.Set;
public class _Goo_06_sudokuValidate{

    public static boolean isValidSudoku(int [][] board){

        //Validate Row
        for(int row=0; row < board[0].length; row ++){  //--> only row loop
            if(!validator(row, row, 0, board.length-1, board))   //same as (r, r, 0, 8, board))
            {
                return false;
            }
        }

        //Validate Column
        for(int col =0; col<board.length; col ++){  //--> only col loop
            if(!validator(0, board[0].length-1, col, col, board ))  //same as (0, 8, c, c, board))
            {
                return false;
            }
        }

        //validate box 3X3
        for(int row=0; row < 3; row ++){
            for(int col =0; col < 3; col ++){
                if(!validator(row*3, row*3+2, col*3, col*3+2, board )){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validator(int rowStart, int rowEnd, int colStart, int colEnd, int[][]board){
        Set<Integer> hSet = new HashSet<>();
        for(int row = rowStart; row <= rowEnd; row ++) {
            for(int col=colStart; col<=colEnd; col++) {
                if(board[row][col] != 0){
                    if(hSet.contains(board[row][col])){
                        return false;
                    }else{
                        hSet.add(board[row][col]);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        System.out.println(isValidSudoku(board));
    }
}
