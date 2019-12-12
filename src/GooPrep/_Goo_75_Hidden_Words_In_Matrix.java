/**
 * [75 - A] [Word Search in matrix ]
 * --------------------------------------------------------------------------------------------------------------
 Given a 2D board and a word, find if the word exists in the grid.
 The word can be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once.

 board =
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']

 Given word = "ABCCED", return true.
 Given word = "SEE", return true.
 Given word = "ABCB", return false.

 */
package GooPrep;

public class _Goo_75_Hidden_Words_In_Matrix {
    //All all eight possible directions neighbours
    static int[] rowDirections = {-1, +1 , 0, 0, 1, 1, -1, -1};
    static int[] colDirections = {0 , 0, -1, +1, 1, -1, -1, 1};

    public static boolean findHiddenWord(char[][] board, String word) {

        if (board==null ||board.length==0||board[0].length==0) return false;

        // iterate through every cell in this 2D array
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if(board[row][col] == word.charAt(0)){
                    boolean[][] visitedMatrix=new boolean[board.length][board[0].length];
                    if (dfs(board, visitedMatrix, row, col,0,word))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, boolean[][] visitedMatrix, int row, int col, int charIndex, String word){

        // when we found all the characters
        if(charIndex == word.length()) return true;

        //Some negative cases
        // Case A: out of boundaries
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        // case B: all ready visitedMatrix and current cell word is not required
        if(visitedMatrix[row][col] || board[row][col] != word.charAt(charIndex)) return false;

        //once we found the required character
        visitedMatrix[row][col] = true;
        //now do the dfs for its neighbours
        for(int i =0; i<8; i++){
            int nRow = row + rowDirections[i];
            int nCol = col + colDirections[i];

            if(dfs(board, visitedMatrix, nRow, nCol,charIndex+1, word)){
                return true;
            }
        }
        // reset the the visited matrix board
        visitedMatrix[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        char mat[][] =
                {
                        "ABAC".toCharArray(),
                        "DPPL".toCharArray(),
                        "EFEP".toCharArray(),
                        "GHAP".toCharArray()
                };

        String word = "SANTOSH";
        System.out.println(findHiddenWord(mat, word));

        String word1 = "APPLE";
        System.out.println(findHiddenWord(mat, word1));

    }

}
