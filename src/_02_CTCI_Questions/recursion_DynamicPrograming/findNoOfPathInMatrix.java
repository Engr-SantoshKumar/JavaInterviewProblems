/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid 
(marked 'Finish' in the diagram below).
How many possible unique paths are there?
https://leetcode.com/problems/unique-paths/description/
https://algorithms.tutorialhorizon.com/dynamic-programming-count-all-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/
- simply add the [row-1][col] and [row][col-1] to count paths
 */

package _02_CTCI_Questions.recursion_DynamicPrograming;

public class findNoOfPathInMatrix {

	static void getPathUsingDP(int [][] maze){
		
		int [][] pathCount = new int [maze.length] [maze.length];
		
		// No of ways to reach any 1st row or col is only 1 ..so making pathCount 1st row and 1st col =1
		for(int row = 0; row < pathCount.length; row ++ ){
			pathCount[row][0] = 1;
		}
		for(int col = 0; col < pathCount.length; col ++ ){
			pathCount[0][col] = 1;
		}
		
		//filling the pathCount matrix 
		for(int row =1; row < pathCount.length; row++){
			for(int col =1; col < pathCount[0].length; col ++){
				pathCount[row][col] = pathCount[row -1][col] + pathCount[row][col - 1];
			}
		}
		
		System.out.println("No of diff way to reach bottom right corroner are " + pathCount[pathCount.length-1][pathCount[0].length-1]);
		
		
	}
	static void getPathsUsingRecursion(int [][] maze){
		System.out.print("No of diff way to reach bottom right corroner Using Recursion are:  ");
		System.out.print(findPathsUsingRecursion(maze, 0, 0));
	}
	static int findPathsUsingRecursion(int [][] maze, int row, int col){
		//base condn, check if last row OR column is reached since after that only one path
		if(row == maze.length-1 || col == maze.length-1){
			return 1;
		}
		
		int left = 0;
		int down = 0;
		
		// Recursion call for only those cells which are not blocked cell
		if( row != maze.length-1){
			down =  findPathsUsingRecursion(maze, row +1, col);
		}
		if (col != maze.length-1){
			left = findPathsUsingRecursion(maze, row , col +1);
		}
		return left + down;
		
		//or just in one line
		//return fidPathsUsingRecursion(maze, row +1, col) + fidPathsUsingRecursion(maze, row , col +1);
	}
	
	
//---Main----	
	public static void main(String[] args) {

			int[][] maze = new int[][] { 
										{ 1, 1, 1, 1 }, 
									    { 1, 2, 3, 4 },
									    { 1, 1, 1, 1 }, 
									    { 1, 1, 1, 1 } };		

									    getPathUsingDP(maze);
									    getPathsUsingRecursion(maze);
 }

}
