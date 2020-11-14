/* [ _oA_31_ ] [ Roman to Integer ]
_______________________________________________________________________________
I-->1, V-->5, X-->10, L-->50, C-->100, D-->500, M-->1000
e.g.

Input: s = "IX"
Output: 9

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

*/
package Code_Run_Build_LC350;

import java.util.HashMap;

public class _oA_31_Roman_To_Integer {
    public static int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return -1;

        //Logic: create a map of Roman char to integer
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = s.length();
        int result = map.get(s.charAt(len - 1));
        //now we move given string from left to right
        // e.g: CIV == 104
        // V --> 5, result = 5
        // I --> 1 , now 1 is smaller than 5 (i+1, previous one ) so result = 5-1 => 4 (v--> 5, iv --> 4)
        // C --> 100, logic(100>1) so result = result+100 => 104

        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("CIV"));
        System.out.println(romanToInt("MCMXCIV"));
    }

}
