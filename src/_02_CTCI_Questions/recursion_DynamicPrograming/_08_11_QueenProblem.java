package _02_CTCI_Questions.recursion_DynamicPrograming;

import java.util.Arrays;

public class _08_11_QueenProblem {
	
	static class position{
		int row, column;
		position(int row, int column){
			this.row = row;
			this.column = column;
		}
	}

	static position[] findPositions(int n){
		position[] QueenPositions = new position[n]; // an array of position class to hold Queens Position in each row
		
		boolean hasSolution = findQueenSafePosition(n, 0, QueenPositions);
		if (hasSolution) {
            return QueenPositions;
        } else {
            return new position[0]; // no solution found
        }
	}

	static boolean findQueenSafePosition(int n, int row, position[] QueenPositions ){
		
		if(n == row) {
			return true; // base cond, this means we reached the last row
		}
		for(int col =0; col < n; col ++){
			
			boolean safePlace = true;
			
			//check if this row and col is not under attack from any previous queen.
			for(int QueenCurrentPosition =0 ; QueenCurrentPosition < row; QueenCurrentPosition ++){
				
				if(QueenPositions[QueenCurrentPosition].column == col || 
						QueenPositions[QueenCurrentPosition].row + QueenPositions[QueenCurrentPosition].column == row+col ||
						QueenPositions[QueenCurrentPosition].row - QueenPositions[QueenCurrentPosition].column == row-col ){
					safePlace = false;
					break;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
				}
			}
				
				if (safePlace){
					QueenPositions[row] = new position(row, col); // added row and column value object in QueenPosition array
					
					// call method again with for queen to 
					if(findQueenSafePosition(n, row+1, QueenPositions)){
						return true;
					}
				}
			}
		return false;
		}
	
	
	public static void main(String args[]) {

        position[] positions = findPositions(6);
        Arrays.stream(positions).forEach(position -> System.out.println(position.row + " " + position.column));
    }
	
}
