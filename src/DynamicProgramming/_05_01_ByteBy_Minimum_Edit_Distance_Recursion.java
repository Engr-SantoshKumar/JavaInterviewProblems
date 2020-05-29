/**
 * [ DP_05_01 ] [ Minimum  Edit Distance ]
 * _____________________________________________________________________________________________________________
 Given two strings, write a function that determines the minimum edit distance
 between the two strings. You can insert and modify characters.
 eg.
 edit(“ABCD”, “ACBD”) = 2 (ABCD->ACCD->ACBD)
 edit(“AC”, “ABCD”) = 2 (AC->ABC->ABCD)
 */
package DynamicProgramming;
public class _05_01_ByteBy_Minimum_Edit_Distance_Recursion {

    static int editDistance(String s1, String s2){
        return editDistance(s1, s2, 0, 0);
    }

    static int editDistance(String s1, String s2, int i, int j){
        //base cases
        if(i== s1.length()) return s2.length()-j;
        if(j== s2.length()) return s1.length()-i;

        int min = editDistance(s1, s2, i+1, j+1);

        if(s1.charAt(i) != s2.charAt(j)) min++;
        min = Math.min(min, editDistance(s1, s2, i+1, j) + 1);
        min = Math.min(min, editDistance(s1, s2, i, j+1) + 1);

        return min;
    }

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "ACBD";

        System.out.println(editDistance(s1, s2));
    }


}
