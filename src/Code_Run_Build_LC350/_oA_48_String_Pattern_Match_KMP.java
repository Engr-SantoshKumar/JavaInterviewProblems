/* [ _oA_48_ ] [ String Pattern Match KMP ]
_______________________________________________________________________________
Input: haystack = "hello", needle = "ll"
Output: 2

KMP: https://www.youtube.com/watch?v=V5-7GzOfADQ
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
            } else if (pat.charAt(j) != str.charAt(i)) {
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
        String txt = "AbcAbcAbc12AbcAbcAbc12";
        String pattern = "AbcAbc12";//"ABAAABABC";
        KEMP_Search_Algorithm(txt, pattern);
    }
}
