package _02_CTCI_Questions.recursion_DynamicPrograming;

import java.util.ArrayList;
import java.util.HashSet;


public class _08_02_FindingPathUsingDFSandStorage {
   
	static void getpath(int [][] maze){
		if(maze == null || maze.length == 0) return;
		
		ArrayList<Point> path = new ArrayList<>();
		HashSet<Point> visitedPoints = new HashSet<Point>();
		
		findPath(maze, maze.length-1, maze[0].length-1, path, visitedPoints);
		//Print
		for(Point p : path){
			System.out.println(p.row + ":"+p.colunm);
		}
		
		
	}
	
	static Boolean findPath(int [][] maze, int row, int colunm, ArrayList<Point> path, HashSet<Point> visitedPoints ){
		
		if(row < 0 || colunm < 0 || maze [row][colunm] == 0){
			return false;
		}
		
		Point p = new Point(row, colunm);
		if(visitedPoints.contains(p)){
			return false;
		}
		
		boolean isAtOrigin = (row == 0) && (colunm == 0);
		
		if(isAtOrigin || findPath(maze, row -1, colunm, path, visitedPoints) || findPath(maze, row, colunm -1, path, visitedPoints) ){
			path.add(p);
			return true;
		}
		visitedPoints.add(p);
		return false;
		
	}
	
	
	
	
	public static void main(String[] args) {
		int[][] maze = new int[][] { 
			{ 1, 0, 0, 0 }, 
            { 1, 1, 1, 0 },
            { 0, 1, 1, 1 }, 
            { 0, 0, 0, 1 } };		

            getpath(maze);
	}

	static class Point{
		int row, colunm;
		public Point(int row, int colunm){
			this.colunm = colunm;
			this.row = row;
		}
	}	
	
}


