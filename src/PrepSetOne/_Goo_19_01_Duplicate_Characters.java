/** 19 [Duplicate Characters]
 -------------------------------------------------------------------------------------------------------
 Return true if the given string contains duplicate characters."
 */

package PrepSetOne;
public class _Goo_19_01_Duplicate_Characters {

    static boolean isHasDuplicates(String s){

        int[] chCount = new int[256];

        for(char c : s.toCharArray()){
            int count = chCount[c];
            if(count > 0)
                return false;

            chCount[c]++;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String s1 = "ABCDEF";
        System.out.println(isHasDuplicates(s));
        System.out.println(isHasDuplicates(s1));
    }
}
