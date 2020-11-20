/* [ _oA_47_ ] [ String Pattern Match Rabin Karp ]
_______________________________________________________________________________
Input: haystack = "hello", needle = "ll"
Output: 2

The two most common O(n) string searching algorithms are:
Rabin-Karp: https://www.youtube.com/watch?v=qQ8vS2btsxI
*/
package Code_Run_Build_LC350;
public class _oA_47_String_Pattern_Match_Rabin_Karp {

    // function to convert character to integer
    public static int charToInt(int idx, String s) {
        return (int)s.charAt(idx) - (int)'a';
    }

    public static int stringPatternMatchRabinKarp(String str, String pat){

            int P = pat.length(), N = str.length();
            if (P > N) return -1;

            // base value for the rolling hash function
            int a = 26;
            // modulus value for the rolling hash function to avoid overflow
            long modulus = (long)Math.pow(2, 31);

            // compute the hash of strings str[:P], pat[:P]
            long h = 0, ref_h = 0;
            for (int i = 0; i < P; ++i) {
                h = (h * a + charToInt(i, str)) % modulus;
                ref_h = (ref_h * a + charToInt(i, pat)) % modulus;
            }
            if (h == ref_h) return 0;

            // const value to be used often : a**P % modulus
            long aL = 1;
            for (int i = 1; i <= P; ++i) aL = (aL * a) % modulus;

            for (int start = 1; start < N - P + 1; ++start) {
                // compute rolling hash in O(1) time
                h = (h * a - charToInt(start - 1, str) * aL
                        + charToInt(start + P - 1, str)) % modulus;
                if (h == ref_h) return start;
            }
            return -1;
    }
    public static void main(String[] args) {
        System.out.println(stringPatternMatchRabinKarp("abaacl", "aa"));
    }
}
