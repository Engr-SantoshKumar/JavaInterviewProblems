package _02_CTCI_Questions.recursion_DynamicPrograming;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueenProblem {

    class Position {
        int row, col;
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public Position[] solveNQueenOneSolution(int n) {
        Position[] QueenPosition = new Position[n];
        boolean hasSolution = solveNQueenOneSolutionUtil(n, 0, QueenPosition);
        if (hasSolution) {
            return QueenPosition;
        } else {
            return new Position[0];
        }
    }

    private boolean solveNQueenOneSolutionUtil(int n, int row, Position[] QueenPosition) {
        if (n == row) {
            return true;
        }
        for (int col = 0; col < n; col++) {
            boolean foundSafe = true;

            //check if this row and col is not under attack from any previous queen.
            for (int queen = 0; queen < row; queen++) {
                if (QueenPosition[queen].col == col || QueenPosition[queen].row - QueenPosition[queen].col == row - col ||
                		QueenPosition[queen].row + QueenPosition[queen].col == row + col) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
            	QueenPosition[row] = new Position(row, col);
                if (solveNQueenOneSolutionUtil(n, row + 1, QueenPosition)) {
                    return true;
                }
            }
        }
        return false;
    }

    

    public static void main(String args[]) {
        EightQueenProblem s = new EightQueenProblem();
        Position[] positions = s.solveNQueenOneSolution(6);
        Arrays.stream(positions).forEach(position -> System.out.println(position.row + " " + position.col));
    }
    
    
    
    
    
    
    /*
     *Solution for https://leetcode.com/problems/n-queens/
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Position[] positions = new Position[n];
        solve(0, positions, result, n);
        return result;
    }

    public void solve(int current, Position[] positions, List<List<String>> result, int n) {
        if (n == current) {
            StringBuffer buff = new StringBuffer();
            List<String> oneResult = new ArrayList<>();
            for (Position p : positions) {
                for (int i = 0; i < n; i++) {
                    if (p.col == i) {
                        buff.append("Q");
                    } else {
                        buff.append(".");
                    }
                }
                oneResult.add(buff.toString());
                buff = new StringBuffer();

            }
            result.add(oneResult);
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean foundSafe = true;
            for (int j = 0; j < current; j++) {
                if (positions[j].col == i || positions[j].col - positions[j].row == i - current || positions[j].row + positions[j].col == i + current) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                positions[current] = new Position(current, i);
                solve(current + 1, positions, result, n);
            }
        }
    }
}
