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
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        if(digits.length() ==0) {
            System.out.println("Not enough keys");
        }
        queue.add(""); // add a empty string or we can also all the char of first digit

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
            String nextMapping =  hmap.get(digits.charAt(currentWordLength) - '0'); // - '0' to convert to int value
            for(char c : nextMapping.toCharArray()){
                queue.add(currentWord+c);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        String keys = "232";
        letterCombinations(keys);

    }

}
