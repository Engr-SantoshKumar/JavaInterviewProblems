/**  60 [Game Of Life]
 ____________________________________________________________________________________________________________________
 Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
 RULES:
    A. [live cell] < [2 live neighbors] --->  dies
    B. [live cell] == [2 or 3 live neighbors] --->  lives
    C. [live cell] > [3 live neighbors] --->  Dies
    D. [dead cell] = [3 live neighbors] --->  become live

 Write a function to compute the next state (after one update) of the board given its current state.
 The next state is created by applying the above rules simultaneously to every cell in the current state,
 where births and deaths occur simultaneously.

 Example:

    Input:                        Output:
    [0,1,0],                      [0,0,0],
    [0,0,1],        -->           [1,0,1],
    [1,1,1],                      [0,1,1],
    [0,0,0]                       [0,1,0]

 Follow up:
 Could you solve it in-place? Remember that the board needs to be updated at the same time:
 You cannot update some cells first and then use their updated values to update other cells.
*/
package GooPrep;

import java.util.Arrays;

public class _Goo_60_Game_Of_Life {

    //All all eight possible directions neighbours
    static int[] rowDirections = {-1, +1 , 0, 0, 1, 1, -1, -1};
    static int[] colDirections = {0 , 0, -1, +1, 1, -1, -1, 1};

    //all states
    static int dead =0;
    static int alive = 1;
    static int dead2alive = 2;
    static int alive2dead = 3;

    public static void gameOfLife(int[][] board) {

        // iterate through every cell in this 2D array
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                // keep track of the number of alive neighbors
                int neighborsCount = 0;
                // Find all the alive neighbour count
                neighborsCount = exploreAllAliveNeighbours(board, row, col);

                /*
                if we think: there are only two case to handle
                Case one: if current cell is date
                Case two: else current cell is not dead
                 */
                // if current cell is dead and Alive Neighbours count ==3
                if (board[row][col] == 0) {
                    if (neighborsCount == 3) {
                        board[row][col] = dead2alive;
                    }
                } else{
                    // in case current cell is alive AND
                    // neighborsCount either less than 2 or more than 3
                    if (neighborsCount != 2 && neighborsCount != 3){
                        board[row][col] = alive2dead;
                    }
                }
            }
        }

        //after completing above loop we will get update board with value 0,1,2 and 3. lets change value 3 and 4 to
        //their corresponding ones i.e 2--> alive [1] and 3--> dead [0]

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 2) {
                    board[row][col] = 1;
                }
                if (board[row][col] == 3) {
                    board[row][col] = 0;
                }
            }
        }
    }

    public static int exploreAllAliveNeighbours(int[][] board, int row, int col) {
        int count = 0;
        for(int i=0; i<8; i++){
            int nR = row + rowDirections[i];
            int nC = col + colDirections[i];

            if(nR >= 0 && nR <board.length && nC>=0 && nC<board[0].length){
                //look for live or live2Ded cell
                if(board[nR][nC] == alive || board[nR][nC] == alive2dead){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] M = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(M);
        for (int[] x : M) {
            System.out.println(Arrays.toString(x));
        }
    }
}

/*
GIVEN:
        {0, 1, 0},
        {0, 0, 1},
        {1, 1, 1},
        {0, 0, 0}
OUTPUT:
        [0, 0, 0]
        [1, 0, 1]
        [0, 1, 1]
        [0, 1, 0]
 */
