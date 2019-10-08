/**
 * [58-01] [Letter Combinations of a Phone Number -- WithOut recursion ]
 * -----------------------------------------------------------------------------------------------------
 * PROBLEM STATEMENT:
 Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
 the number could represent.
 A mapping of digit to letters (just like on the telephone buttons) is given below.
 Note that 1 does not map to any letters.
 */
package GooPrep;

import java.util.*;
import java.util.LinkedList;

public class _Goo_58_00_Remote_Letter_Combinations_of_Phone_KeyPad_WithoutRecursion {

    static Map<Integer, String> hmap = new HashMap<>() {{
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
    }};

    public static void letterCombinations(String digits) {
        Queue<String> result = new LinkedList<>();
        if(digits.length() ==0) {
            System.out.println("Not enough keys");
        }
        result.add(""); // add a empty string or we can also all the char of first digit
        // check if the length, if the length is not equal to digits length that means still some key remaining to add
        while(result.peek().length()!=digits.length()){
            //get the length of current removed string
            String currentWord = result.poll();
            int currentWordLength = currentWord.length();
            // get the digit at currentWordLength and get its string value was map is Map<String, String>
            String nextMapping =  hmap.get(digits.charAt(currentWordLength) - '0'); // - '0' to convert to int value
            for(char c : nextMapping.toCharArray()){
                result.add(currentWord+c);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        String keys = "232";
        letterCombinations(keys);

    }

}
