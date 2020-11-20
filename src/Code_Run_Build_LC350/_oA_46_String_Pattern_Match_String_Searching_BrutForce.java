/* [ _oA_46_  ] [String Pattern Match String Searching ]
_______________________________________________________________________________
Input: haystack = "hello", needle = "ll"
Output: 2

The two most common O(n) string searching algorithms are:
Boyer Moore: https://en.wikipedia.org/wiki/Boyer–Moore_string-search_algorithm
KMP: https://www.youtube.com/watch?v=V5-7GzOfADQ
When you use ctrl+f, it's usually one of these algorithms running,
but if you're dealing with small strings, it's not worth it to run these algorithms.
*/
package Code_Run_Build_LC350;
public class _oA_46_String_Pattern_Match_String_Searching_BrutForce {

    public static int stringSearchBrutForce(String str, String pat) {

        // empty pat appears everywhere, first appears at 0 index
        if (pat.length() == 0)
            return 0;
        if (str.length() == 0)
            return -1;

        for (int i = 0; i < str.length(); i++) {
            // no enough places for pat after i
            if (i + pat.length() > str.length()) break;

            for (int j = 0; j < pat.length(); j++) {
                if (str.charAt(i+j) != pat.charAt(j))
                    break;
                if (j == pat.length()-1)
                    return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(stringSearchBrutForce("abaacl", "aa"));
    }
}
