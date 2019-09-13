package _02_CTCI_Questions.recursion_DynamicPrograming;

import java.util.ArrayList;

public class _08_02_FindPathIn2DMatrixUsingDFS {

	public static void getpath(int [][] maze){
		// check for valid maze
		if(maze == null || maze.length == 0){
			System.out.println("Not a Valid maze");;
		}
		
		ArrayList<Point> path = new ArrayList<Point>();
		
		// calling find path from destination i.e right corner bottom
		findPath(maze, maze.length - 1, maze[0].length - 1, path); 
		
		//Print
		for(Point p : path){
		System.out.print("("+p.row + ":" + p.column+") ");
			}
		}
		
	
	    // find the existing path
		public static Boolean findPath(int [][] maze, int row, int colunm, ArrayList<Point> path){
			
			//Checking If out of bounds or value "0"
			if(row < 0 || colunm < 0 || maze[row][colunm] ==0) return false;
			
			boolean isAtOrigin = (row == 0) && (colunm == 0);
			
			// If there's a path from the start to my current location, add my location.
			if (isAtOrigin || findPath(maze, row, colunm - 1, path) || findPath(maze, row - 1, colunm, path)) { 
				Point p = new Point(row, colunm);
				path.add(p);
				return true;				
			}
			return false;
		}
	
		
	public static void main(String[] args) {
		int[][] maze = new int[][] { { 1, 0, 0, 0 }, 
			                         { 1, 1, 1, 0 },
                                     { 0, 1, 1, 1 }, 
                                     { 0, 0, 0, 1 } };		
	
        getpath(maze);
	
	}



}
class Point{
	int row, column;
	
	public Point(int row, int col){
		this.column=col;
		this.row=row;
	}
}
