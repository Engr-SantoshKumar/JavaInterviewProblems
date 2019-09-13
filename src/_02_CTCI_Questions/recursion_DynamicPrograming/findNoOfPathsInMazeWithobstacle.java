/* In Dynamic programming solution, we need to take care of two conditions, 
 * 	first we are not solving it for blocked cells and 
 * 	while solving for other cells do not involve blocked cells.
 * 
 */

package _02_CTCI_Questions.recursion_DynamicPrograming;

public class findNoOfPathsInMazeWithobstacle {
	
	static void getPathsUsingDP(int [][] maze){
		
		// copy maze to pathCount  ...here main aim is to get pathCounts matrix same as maze matrix 
		int [][] pathCounts = maze;
		
		for(int row =1; row < pathCounts.length; row ++ ){
			for(int col =1; col < pathCounts.length; col ++){
				
				//check if not a blocked cell
				if(pathCounts[row][col] != 0){
					pathCounts[row][col] = 0;
					
					//update the cell from the above and left, if those are not 0 .. i.e greater than 0
					if(pathCounts[row -1][col] > 0){
						pathCounts[row][col] = pathCounts[row][col] + pathCounts[row -1][col];
					}
					if(pathCounts[row][col - 1] > 0){
						pathCounts[row][col] = pathCounts[row][col] + pathCounts[row][col -1];
					}
					
				}
				
			}
		}
		System.out.println("No of diff way to reach bottom right corroner using DP are: " + pathCounts[pathCounts.length-1][pathCounts[0].length-1]);
		
		
	}
	static void getPathsUsingRecursion(int [][] maze){
		System.out.print("No of diff way to reach bottom right corroner Using Recursion are:  ");
		System.out.print(fidPathsUsingRecursion(maze, 0, 0));
	}
	static int fidPathsUsingRecursion(int [][] maze, int row, int col){
		//base condn, check if last row OR column is reached since after that only one path
		if(row == maze.length-1 || col == maze.length-1){
			return 1;
		}
		
		int left = 0;
		int down = 0;
		
		// Recursion call for only those cells which are not blocked cell
		if( row != maze.length-1 && maze[row + 1][col] != 0){
			down =  fidPathsUsingRecursion(maze, row +1, col);
		}
		if (col != maze.length-1 && maze[row][col+1] != 0){
			left = fidPathsUsingRecursion(maze, row , col +1);
		}
		return left + down;
	}
	
	

	public static void main(String[] args) {

		int[][] maze = new int[][] { 
									{ 1, 0, 0, 0 }, 
								    { 1, 1, 1, 0 },
								    { 0, 1, 1, 1 }, 
								    { 0, 0, 1, 1 } };		

		 getPathsUsingDP(maze);
		 getPathsUsingRecursion(maze);


	}

}
