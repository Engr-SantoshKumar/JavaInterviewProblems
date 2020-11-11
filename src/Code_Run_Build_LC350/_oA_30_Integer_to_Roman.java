/* [_0A_30_] [Integer to Roman  ]
____________________________________________________________________________________________________________
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
I-->1, V-->5, X-->10, L-->50, C-->100, D-->500, M-->1000
Input: num = 3
Output: "III"

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/
package Code_Run_Build_LC350;
public class _oA_30_Integer_to_Roman {

    public static String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanChar = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer sb = new StringBuffer();

        //Logic: we create a kind of map for value and romanChars [1000 --> M both are at 0th position]
        // now loop through the value array and subtract the biggest possible one first and so on
        //e.g. num = 994 (first biggest number from value array that we can subtract which is <= num is 900)
        // 900 is at index 1 and corresponding romanChar[1] is CM
        // remain is 994-900 = 94 so 94-90 -->  XC
        // remain is 4 --> IV

        for(int i=0; i<values.length; i++){
            while(num >= values[i]){
                num -= values[i];
                sb.append(romanChar[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(994));
    }
}
