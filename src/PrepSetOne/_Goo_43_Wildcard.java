/** [_Goo_043] [Wildcard.]
 -------------------------------------------------------------------------------------------------------
 Generate all binary strings from given pattern
 Given a string containing of ‘0’, ‘1’ and ‘?’ wildcard characters,
 generate all binary strings that can be formed by replacing each wildcard character by ‘0’ or ‘1’.
 Input str = "1??0?101"
 Output:
 10000101 ,10001101, 10100101, 10101101, 11000101, 11001101, 11100101, 11101101
 */

package PrepSetOne;

import java.util.*;
import java.util.LinkedList;

public class _Goo_43_Wildcard {

    private static void findAllPossibleString(String givenString) {
        List<String> result = new LinkedList<>();
        Queue<String> queue = new ArrayDeque<>();

        queue.add(givenString);

        while (!queue.isEmpty()) {
            String curString = queue.remove();

            // this will return first occurrence of '?' and if not present will return -1
            int indexOfWild = curString.indexOf('?');
            if(indexOfWild == -1){ // all done
                result.add(curString);
            }else{
                String strWithZero = curString.substring(0, indexOfWild) + '0' +
                        curString.substring(indexOfWild + 1);
                queue.add(strWithZero);

                String strWithOne  = curString.substring(0, indexOfWild) + '1' +
                        curString.substring(indexOfWild + 1);
                queue.add(strWithOne);
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
    }

    public static void main(String[] args) {
        String givenString = "1??0?101";
        findAllPossibleString(givenString);
    }
}
