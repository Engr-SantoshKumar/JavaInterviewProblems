package _01_Coderust._07_Dynamic_Programing;

import java.util.HashSet;
import java.util.Set;

public class _x_05_Make_Columns_And_Rows_Zeros {

    static void make_zeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        Set<Integer> zero_rows = new HashSet<Integer>();
        Set<Integer> zero_cols = new HashSet<Integer>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == 0) {
                    if (!zero_rows.contains(i)) {
                        zero_rows.add(i);
                    }

                    if (!zero_cols.contains(j)) {
                        zero_cols.add(j);
                    }
                }
            }
        }

        for (int r : zero_rows) {
            for (int c = 0; c < cols; ++c) {
                matrix[r][c] = 0;
            }
        }

        for (int c : zero_cols) {
            for (int r = 0; r < rows; ++r) {
                matrix[r][c] = 0;
            }
        }
    }


    static void print_matrix(int[][] m){
        System.out.println();
        for(int i =0; i < m.length; i++){
            for(int j=0; j < m[i].length; j++){
                System.out.print(m[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  5,  45,  0,  81},
                { 6,  7,   2,  2,   8},
                {20,  2,   9,  5,   5},
                { 0,  23,  0,  4,  92}
        };
        print_matrix(matrix);
        make_zeroes(matrix);
        print_matrix(matrix);


    }
}

