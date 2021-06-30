package GooPrep;/* [ _Goo_75_C ] [ Word Search ]
_______________________________________________________________________________
/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once.

*/

import java.util.*;

public class _Goo_75_C_Word_Search_BFS {
    //Global variable
    static int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static Queue<HeadAndPath> allPaths = new ArrayDeque<>();
    static int boardSize;

    public static boolean findHiddenWord(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        boardSize = board[0].length;

        for(int row =0; row < board.length; row++){
            for(int col =0; col < board[0].length; col++){
                if(board[row][col] == word.charAt(0)){
                    int[] head = new int[]{row, col};
                    // converting row/col to integer value, so that we can
                    // use contains function of hashset to check the traveled path in O(1)
                    int integerValueOfHead = (row*boardSize) + col;
                    LinkedHashSet<Integer> curPath = new LinkedHashSet<>();
                    curPath.add(integerValueOfHead);
                    HeadAndPath headWithPath = new HeadAndPath(head, curPath);
                    allPaths.offer(headWithPath);
                    if (BFS(board, word, allPaths)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean BFS(char[][] board, String word, Queue<HeadAndPath> allPaths){
        while(!allPaths.isEmpty()){
            HeadAndPath currentPath = allPaths.poll();

            if (currentPath.path.size() == word.length() ) return true;

            int curRow = currentPath.head[0];
            int curCol = currentPath.head[1];

            for (int[] dir: directions) {
                int nRow = curRow + dir[0];
                int nCol = curCol + dir[1];

                // boundary check
                if (nRow < 0 || nRow >= board.length || nCol < 0 || nCol >= board[0].length) continue;
                // next char check
                if (board[nRow][nCol] != word.charAt(currentPath.path.size())) continue;
                // if all ready visited
                int[] newHead = new int[]{nRow, nCol};
                int integerValueOfHead = (nRow*boardSize) + nCol;
                System.out.println("new head : "+ integerValueOfHead);
                if(currentPath.path.contains(integerValueOfHead)) continue;

                // construct a new obj with existing Path+newHead
                LinkedHashSet<Integer> nPath = new LinkedHashSet<>();
                nPath.addAll(currentPath.path);
                nPath.add(integerValueOfHead);
                HeadAndPath nHeadWithPath = new HeadAndPath(newHead, nPath);
                allPaths.offer(nHeadWithPath);

            }
        }
        return false;
    }

    public static void main(String[] args) {

        char[][] mat2 =
                {
                        "ABCE".toCharArray(),
                        "SFES".toCharArray(),
                        "ADEE".toCharArray(),
                };

        String word2 = "ABCB";
        String word3 = "ABCESEEEFS";
        //System.out.println(findHiddenWord(mat2, word2));
        System.out.println(findHiddenWord(mat2, word3));
    }


}
class HeadAndPath{
    int[] head;
    LinkedHashSet<Integer> path;

    public HeadAndPath(int[] head, LinkedHashSet<Integer> path) {
        this.head = head;
        this.path = path;
    }
}