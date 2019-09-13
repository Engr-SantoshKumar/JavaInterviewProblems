/** 24 - 01  [Find LPS (Longest Suffix Prefix) KMP Algo ]
---------------------------------------------------------------------------------------------------------
 Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[])
 that prints all occurrences of pat[] in txt[]. You may assume that n > m.

 The KMP matching algorithm uses degenerating property (pattern having same sub-patterns appearing more
 than once in the pattern) of the pattern and improves the worst case complexity to O(n).
 The basic idea behind KMP’s algorithm is: whenever we detect a mismatch (after some matches),
 we already know some of the characters in the text of the next window.
 We take advantage of this information to avoid matching the characters that we know will anyway match.
 */
// Examples of lps[] construction:
// For the pattern “AAAA”,
// lps[] is [0, 1, 2, 3]
//
// For the pattern “ABCDE”,
// lps[] is [0, 0, 0, 0, 0]
//
// For the pattern “AAACAAAAAC”,
// lps[] is [0, 1, 2, 0, 1, 2, 3, 3, 3, 4]
//
// For the pattern “AAABAAA”,
// lps[] is [0, 1, 2, 0, 1, 2, 3]

package GooPrep;

public class _Goo_24_01_Find_Longest_Suffix_Prefix_KMP {

    public static String findLongestSuffix_Prefix(String s){

        int currMaxLPS =0;
        int[] lpsArray = new int[s.length()];
        lpsArray[0] = 0; // lps[0] is always 0

        int i =1;
        while(i < s.length()){

            if(s.charAt(currMaxLPS) == s.charAt(i)){
                currMaxLPS ++;
                lpsArray[i] = currMaxLPS;
                i++;
            }
            else
            {
                if(currMaxLPS!=0){
                    currMaxLPS = lpsArray[currMaxLPS-1];
                }else{
                    lpsArray[i] =0;
                    i++;
                }
            }
        }
        int lpsLength = lpsArray[s.length()-1];
        return s.substring(0,lpsLength);

    }

    public static void main(String[] args)
    {
        String txt[] = {"ABCABC", "ABABAB", "ABCDAB", "GEEKSFORGEEKS", "GEEKGEEK", "AAAACAAAAC", "ABCDABC"};
        int n = txt.length;

        for (int i = 0; i < n; i++) {
            System.out.println(txt[i]+ " -> " + findLongestSuffix_Prefix(txt[i]));

        }
    }
}
