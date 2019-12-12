/**
 * [58-00] [Letter Combinations of a Phone Number]
 * -----------------------------------------------------------------------------------------------------
 * PROBLEM STATEMENT:
 Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
 the number could represent.
 A mapping of digit to letters (just like on the telephone buttons) is given below.
 Note that 1 does not map to any letters.
 */
package GooPrep;

import java.util.*;

public class _Goo_58_00_Remote_Letter_Combinations_of_Phone_KeyPad {

    static Map<String, String> hmap = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    static List<String>  result= new ArrayList<String>();

    public static List<String> letterCombinations(String KeyPadDigits){
        if(KeyPadDigits.length()!=0){
            createStrings("", KeyPadDigits);
        }
        return result;
    }

    public static void createStrings(String combinations, String next_digits ){
        // if no digit left, the combination is done
        if(next_digits.length()==0)
        {
            result.add(combinations);
        }
        else
            {
            // take the 1st digit from the next_digit string, e.g: "3 4 5" -> substring(0,1) --> 3
            String digit = next_digits.substring(0,1);
            String letters = hmap.get(digit);
            for(int i=0; i < letters.length(); i++){
                // pick the first char of 3 = def --> d
                String letter = Character.toString(letters.charAt(i));
                // call fun again with remaining digits --> next_digits.substring(1) --> "4 5"
                createStrings(combinations+letter, next_digits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        String keys = "232";
        List<String>  result= new ArrayList<String>();
        result = letterCombinations(keys);

        for(String words : result){
            System.out.println(words);
        }

    }


}
