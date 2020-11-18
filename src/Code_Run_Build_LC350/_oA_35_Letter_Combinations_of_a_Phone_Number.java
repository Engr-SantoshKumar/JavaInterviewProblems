/* [ _oA_35_ ] [ Letter Combinations of a Phone Number ]
_______________________________________________________________________________
Given a string containing digits from 2-9 inclusive, return all possible letter
combinations that the number could represent. Return the answer in any order.
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Input: digits = "2"
Output: ["a","b","c"]

DFS solution (recursion) :_Goo_58_00_Remote_Letter_Combinations_of_Phone_KeyPad
*/
package Code_Run_Build_LC350;
import java.util.*;
import java.util.LinkedList;

public class _oA_35_Letter_Combinations_of_a_Phone_Number {

    // global map
    static Map<Integer, String> map = new HashMap<>() {{
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
    }};

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        if(digits.length() ==0) {
            return result;
        }
        // add a empty string or we can also all the char of first digit
        queue.add("");

        while(!queue.isEmpty()){
            //get the length of current removed string
            String currentWord = queue.poll();
            // if the length is not equal to digits length that means still some key remaining to add
            int currentWordLength = currentWord.length();
            if(currentWordLength == digits.length()){
                result.add(currentWord);
                continue;
            }
            // get the digit at currentWordLength and get its string value was map is Map<String, String>
            String nextMapping =  map.get(digits.charAt(currentWordLength) - '0'); // - '0' to convert to int value
            for(char c : nextMapping.toCharArray()){
                queue.add(currentWord+c);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        String keys1 = "232";
        String keys2 = "";
        System.out.println(letterCombinations(keys1));

    }
}
