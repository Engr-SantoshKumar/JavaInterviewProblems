/* [ _oA_48_ ] [ String Pattern Match KMP ]
_______________________________________________________________________________
KMP: https://www.youtube.com/watch?v=V5-7GzOfADQ
https://prismoskills.appspot.com/lessons/Pattern_Matching/Chapter_01_-_KMP_Algorithm.jsp
 Problem Statement: Find all occurrences of pattern[] of length 'm' in txt[] of length 'n'.
 Solution: KMP algorithm makes use of the match done till now and does not begin searching all over again
 in case a mismatch is found while searching for a match.

*/
package Code_Run_Build_LC350;

import java.util.Arrays;

public class _oA_48_String_Pattern_Match_KMP {

    static void KEMP_Search_Algorithm(String str, String pat) {
        int lps[] = new int[pat.length()];
        computeLPS(pat, lps);
        int i = 0, j = 0;

        while (i < str.length()) {
            if (pat.charAt(j) == str.charAt(i)) {
                j++;
                i++;
            }
            if (j == pat.length()) {
                System.out.println
                        ("Pattern is found at index " + (i - j));
                j = lps[j - 1];
            } else if ((i<str.length()) && pat.charAt(j) != str.charAt(i)) {
                // mismatch occurs after j matches
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
    }

    static void computeLPS(String pattern, int[] lps) {
        int currMaxLPS = 0;
        lps[0] = 0;

        for (int i = 1; i < pattern.length(); ) {
            if (pattern.charAt(i) == pattern.charAt(currMaxLPS)) {
                currMaxLPS++;
                lps[i] = currMaxLPS;
                i++;
            } else {
                if (currMaxLPS != 0) {
                    currMaxLPS = lps[currMaxLPS - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        System.out.println("LPS Array = " + Arrays.toString(lps));
    }

    public static void main(String args[]) {
        String txt = "AbcAbcAbc12Abc12AbcAbc12";
        String pattern = "AbcAbc12";
        KEMP_Search_Algorithm(txt, pattern);
    }
}
