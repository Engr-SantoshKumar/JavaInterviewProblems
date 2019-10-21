/**
 * [75 - B] [BFS - Word Search in matrix ]
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

import java.util.ArrayDeque;
import java.util.Queue;

public class _Goo_75_B_BFS_Hidden_Words_In_Matrix {
    //All all eight possible directions neighbours
    static int[] rowDirections = {-1, +1 , 0, 0, 1, 1, -1, -1};
    static int[] colDirections = {0 , 0, -1, +1, 1, -1, -1, 1};
    static Queue<Integer> rowQueue = new ArrayDeque<>();
    static Queue<Integer> colQueue = new ArrayDeque<>();
    static Queue<String> wordQueue = new ArrayDeque<>();

    public static boolean findHiddenWord(char[][] board, String word) {
        if (board==null ||board.length==0||board[0].length==0) return false;
        // iterate through every cell in this 2D array
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if(board[row][col] == word.charAt(0)){
                    boolean[][] visitedMatrix=new boolean[board.length][board[0].length];
                    rowQueue.add(row);
                    colQueue.add(col);
                    wordQueue.add(Character.toString((board[row][col])));
                    if (BFS(board, visitedMatrix, word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean BFS(char[][] board, boolean[][] visitedMatrix, String givenWord){

        while(!rowQueue.isEmpty()){

                String currentWord = wordQueue.poll();
                int nextIndex = currentWord.length();
                if(currentWord.length()==givenWord.length()) return true;
                int curRow = rowQueue.poll();
                int curCol = colQueue.poll();
                for(int i =0; i<8; i++) {
                    int nRow = curRow + rowDirections[i];
                    int nCol = curCol + colDirections[i];

                    // some validations
                    if (nRow < 0 || nRow >= board.length || nCol < 0 || nCol >= board[0].length) continue;
                    if (visitedMatrix[nRow][nCol] || board[nRow][nCol] != givenWord.charAt(nextIndex)) continue;
                    rowQueue.add(nRow);
                    colQueue.add(nCol);
                    wordQueue.add(currentWord + board[nRow][nCol] );
                }
        }
        return false;
    }

    public static void main(String[] args) {
        char mat[][] =
                {
                        "DEMXB".toCharArray(),
                        "AOEAE".toCharArray(),
                        "PDCPD".toCharArray(),
                        "EBEDP".toCharArray(),
                        "CPYEL".toCharArray()
                };

        //String word = "SANTOSH";
        //System.out.println(findHiddenWord(mat, word));

        String word1 = "APPLE";
        System.out.println(findHiddenWord(mat, word1));

    }

}
