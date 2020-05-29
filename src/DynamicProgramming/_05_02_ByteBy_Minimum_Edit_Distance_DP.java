/**
 * [ DP_05_02 ] [ Minimum  Edit Distance DP]
 * _____________________________________________________________________________________________________________
 Given two strings, write a function that determines the minimum edit distance
 between the two strings. You can insert and modify characters.
 eg.
 edit(“ABCD”, “ACBD”) = 2 (ABCD->ACCD->ACBD)
 edit(“AC”, “ABCD”) = 2 (AC->ABC->ABCD)
 */
package DynamicProgramming;
public class _05_02_ByteBy_Minimum_Edit_Distance_DP {

    static int editDistance(String s1, String s2){
        // a 2d matrix
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        //lets fill the cells
        for(int r = 0; r < dp.length; r++){
            for(int c=0; c < dp[0].length; c++){
                //base cases - default value
                if(r==0) dp[r][c]=c;
                else if(c==0) dp[r][c]=r;
                else{
                    int min = dp[r-1][c-1];
                    if (s1.charAt(r-1) != s2.charAt(c-1)) min++;
                    min = Math.min(min, dp[r-1][c] + 1);
                    min = Math.min(min, dp[r][c-1] + 1);
                    dp[r][c] = min;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "ACBD";

        System.out.println(editDistance(s1, s2));
    }


}
