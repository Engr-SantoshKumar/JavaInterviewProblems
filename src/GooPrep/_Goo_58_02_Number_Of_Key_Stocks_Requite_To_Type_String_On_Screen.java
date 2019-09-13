/**  58-02 [No of key stocks requite to type string on scree (movement+enter) ]
 ____________________________________________________________________________________________________________________
 How to generate grid: Iterate from A to Z. Initialize a hashmap of string:array type.
 Take ascii value and divide the ascii value by 5(gives row value) and take %5(gives column value).
 Hashmap would look like {A:[0,0], B:[0,1]....F:[1,0]}

 Now start iterating on the string(GEEK), and your initial position would be prevLetter:
 A so to reach to the current letter G.
 stepsTillNow += abs(hash[A[0]] - hash[G[0]])+abs(hash[A[1]]-hash[G[1]]) +1
 Now in the next iteration, your prevLetter becomes G and the currentLetter becomes E.
 Keep on iterating the string and at the end return stepsTillNow.

 Runtime:O(n)
 Space: O(1) (hash will only have 26 elements which can be considered constant)

 Screen
 A B C D E
 F G H  I  J
 K L M N O
 P Q R S  T
 U V W X Y
 Z
 */

package GooPrep;

import java.util.HashMap;
import java.util.Map;

public class _Goo_58_02_Number_Of_Key_Stocks_Requite_To_Type_String_On_Screen {

    public static void findPath(String inputStr){

        Map<Character, Integer[]> map = new HashMap<Character, Integer[]>();
        for (char ch = 'A'; ch <= 'Z'; ++ch){

            int rowCoordinates = (ch - 'A') / 5; // 13/5=2 because 13 divided 5=2
            int colCoordinates = (ch - 'A') % 5; // 13%5=3 because 13%5 =3 with a  of 3
            Integer[] coordinates = {rowCoordinates, colCoordinates};
            map.put(ch, coordinates);
        }

        int keystrokesTillNow =0;
        char current = 'A';

        for(char ch: inputStr.toCharArray()){
            char next = ch;

            /* Move[A[0,0] --> H[1,2]]
              abs(0-1) + abs(0-2) + 1
              1+2+1 = 4 (A->F->G->H + enter) */

            keystrokesTillNow += Math.abs(map.get(current)[0] - map.get(next)[0]) +
                            Math.abs(map.get(current)[1] - map.get(next)[1]) +1;// +1 for press enter key
            current = next;
        }
        System.out.println(keystrokesTillNow);
    }

    public static void main (String[] args)
    {
        String str = "SANTOSH";
        findPath(str);
    }
}
