/** 24 - 02 [Periodic String KMP]
 ---------------------------------------------------------------------------------------------------------
 1) Find length of the longest proper prefix of ‘str’ which is also a suffix.
 Let the length of the longest proper prefix suffix be ‘len’.
 This can be computed in O(n) time using pre-processing step of KMP string matching algorithm.

 2) If value of ‘n – len’ divides n (or ‘n % (n-len)’ is 0), then return true, else return false.
 In case of ‘true’ , the substring ‘str[0..n-len-1]’ is the substring that repeats n%(n-len) times.
 */

package GooPrep;

public class _Goo_24_02_Periodic_string_KMP {


    /**Returns true if str is repetition of one of its substrings else return false. */
    static boolean isRepeat(String str)
    {
        int n = str.length();
        int LongestPrefixSuffix[] = new int[n]; //store lps values used in KMP

        // Precess the pattern (calculate lps[] array)
        computeLPSArray(str, n, LongestPrefixSuffix);

        // Find length of longest suffix which is also prefix of str.
        int len = LongestPrefixSuffix[n-1];
        System.out.println("LPS : --> " + len);

        /*If there exist a suffix which is also prefix AND Length of the remaining substring divides total length,
         then str[0..n-len-1] is the substring that repeats n/(n-len) times
         e.g:  ABABAB --> lsp is 4
               6 % (6-4) == 0 --> true
               ABCDABCABC --> lsp is 3
               10 % (10-3) => 10 % 7 == 0 false
                    */

        return (len > 0 && n%(n-len) == 0)? true: false;
    }

    static void computeLPSArray(String sPattern, int strLen, int[] lpsArray){

        int count =0;
        lpsArray[0] =0; // lps[0] is always 0

        int i =1;
        while(i < strLen){

            if(sPattern.charAt(count) == sPattern.charAt(i)){
                count ++;
                lpsArray[i] = count;
                i++;
            }
            else
            {
                if(count != 0)
                {
                /**
                 lps[count-1] contains the largest prefix of pattern that matches the suffix ending at
                 pattern[count-1], So try to match from that prefix
                 (which has to be smaller than current prefix)
                  ---> "i " --> is not incrementing here.               */
                    count = lpsArray[count-1];
                }
                else{
                    lpsArray[i] =0;
                    i++;
                }
            }
        }
    }

     public static void main(String[] args)
     {
         String txt[] = {"ABCABCABC", "ABABAB", "ABCDAB", "GEEKSFORGEEKS", "GEEKGEEK", "AAAACAAAAC", "ABCDABC", "ABCDABCABC"};
        int n = txt.length;

        for (int i = 0; i < n; i++) {
            if(isRepeat(txt[i]) == true)
                System.out.println(txt[i] + " -->True");
            else
                System.out.println(txt[i] + " -->False");
        }
     }
 }

