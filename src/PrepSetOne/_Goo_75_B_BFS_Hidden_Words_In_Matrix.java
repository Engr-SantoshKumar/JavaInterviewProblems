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
package PrepSetOne;

import java.util.*;

public class _Goo_75_B_BFS_Hidden_Words_In_Matrix {
    // some global variables --> all possible directions + Queue for BFS
    static int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static Queue<LinkedHashSet<Integer>> allPaths = new ArrayDeque<>();
    static int rowSize; static int colSize;

    public static boolean findHiddenWord(char[][] board, String word) {
        if (board==null ||board.length==0||board[0].length==0) return false;
         rowSize = board.length;
         colSize = board[0].length;
        // iterate through every cell in this 2D array
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if(board[row][col] == word.charAt(0)){
                    LinkedHashSet<Integer> curPath = new LinkedHashSet<>();
                    curPath.add(row*rowSize + col);
                    allPaths.offer(curPath);
                    if (BFS(board, word, allPaths)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean BFS(char[][] board, String givenWord, Queue<LinkedHashSet<Integer>> allPaths){
        while(!allPaths.isEmpty()){
            LinkedHashSet<Integer> currentPath = allPaths.poll();
            System.out.println(allPaths.size());
            System.out.println(Arrays.toString(currentPath.toArray()));
            if (currentPath.size() == givenWord.length()) return true;

            //get the last cell of linkedHashSet
            Integer[] intArray = new Integer[ currentPath.size() ];
            intArray = currentPath.toArray(intArray);
            int lastCell =  intArray[ intArray.length - 1 ];
            int curRow = lastCell/rowSize;
            int curCol = lastCell%rowSize;

            for (int[] dir: directions) {
                int nRow = curRow + dir[0];
                int nCol = curCol + dir[1];

                // some validations
                if (nRow < 0 || nRow >= board.length || nCol < 0 || nCol >= board[0].length) continue;

                if (board[nRow][nCol] != givenWord.charAt(currentPath.size())) continue;
                int nextBlockNo = nRow*rowSize + nCol;
                if(currentPath.contains(nextBlockNo)) continue;
                LinkedHashSet<Integer> updatedPath = new LinkedHashSet<>();
                updatedPath.addAll(currentPath);
                updatedPath.add(nextBlockNo);
                allPaths.offer(updatedPath);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] mat =
                {
                        "HBKC".toCharArray(),
                        "EPGD".toCharArray(),
                        "LFEP".toCharArray(),
                        "PPAP".toCharArray()
                };
        char[][] Box1 =
                {
                        "LEB".toCharArray(),
                        "PEP".toCharArray(),
                        "PAP".toCharArray(),
                };
        char[][] mat2 =
                {
                    "BCE".toCharArray(),
                    "FES".toCharArray(),
                    "DEE".toCharArray(),
                };
        char[][] mat3 =
                {
                        "ABCE".toCharArray(),
                        "SFES".toCharArray(),
                        "ADEE".toCharArray(),
                };

        String word1 = "APPLE";
        String word2 = "BCESEEEF";
        System.out.println(findHiddenWord(mat2, "word2"));
        System.out.println(findHiddenWord(mat3, "ABCB"));
    }
}


