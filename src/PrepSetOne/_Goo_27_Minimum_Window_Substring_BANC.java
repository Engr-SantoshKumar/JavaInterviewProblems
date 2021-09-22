/** 27  [Sliding Window - Minimum sub string window]
 ---------------------------------------------------------------------------------------------------------
Logic in this problem is same as og "Finding sub Anagram in a String" problem _Goo_14_TARZAN

 "Return the shortest substring that contains all the characters in the set. (Minimum Window Substring)
 For example,
 S = ""ADOBECODEBANC""
 T = ""ABC""
 Minimum window is ""BANC"" ."

 */

package PrepSetOne;
public class _Goo_27_Minimum_Window_Substring_BANC {

    static void minimumWindowSubstring(String S, String pattern){

         int[] dict = new int[126];

         // Step 1: load the pattern string to dict
         for(char c: pattern.toCharArray()){
             dict[c] ++;
         }

         //Step 2: we need variables for "count for remainingCount" and where the sub string "Starts"
         int requiredCount = pattern.length();

         /* Reduce the count from dict for current char
         Case a: if the current char is in pattern, its count will be reduced by 1..(will be > 0 )
         Case b: if the current char is NOT in pattern, its count will go in negative ( 0--> -1 --> -2)
          */
         for(int i =0, j =0 ; i<S.length(); i++) {
             char c = S.charAt(i);

             //check if it is in pattern, if yes reduce the reqCount
             if (dict[c] > 0) {
                 requiredCount--;
             }
             //reduce the count for visited chars
             dict[c]--;

             //once we have reqCount ==0,
             // means we found a subString which has all of the patterns chars
             if (requiredCount == 0) {

                 //shrink the window, we might have a string with all the pattern Chars but there could be few
                 // in the front of string which we don't need
                 while (dict[S.charAt(j)] < 0) {
                     dict[S.charAt(j)]++;
                     j++;
                 }
                 System.out.println(S.substring(j, i + 1));

                 // remove the first char from above found string(so that we can find the others substring)
                 dict[S.charAt(j)]++;
                 j++;
                 requiredCount++;
             }
         }
    }

    public static void main(String[] args) {
        String s="EABDEBANC";
        //String s="APDPBAKAP";
        String t = "ABC";
        minimumWindowSubstring(s,t);
        //System.out.println(" result "+result);
    }
}
