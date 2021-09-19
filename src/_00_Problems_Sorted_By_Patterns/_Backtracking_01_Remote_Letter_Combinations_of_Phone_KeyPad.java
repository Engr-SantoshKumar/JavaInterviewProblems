/* [ _Backtracking_01_ ] [ Remote Letter Combinations of Phone KeyPad ]
_______________________________________________________________________________
Given a string containing digits from 2-9 inclusive, return all possible letter combinations
that the number could represent. Return the answer in any order.

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
*/
package _00_Problems_Sorted_By_Patterns;
import java.util.*;
public class _Backtracking_01_Remote_Letter_Combinations_of_Phone_KeyPad {

    static Map<Integer, String> hashMap = new HashMap<>() {{
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
        Queue<String> queue = new ArrayDeque<>();
        if(digits.length() ==0) {
            System.out.println("Not enough keys");
        }
        queue.add(""); // add a empty string or we can also all the char of first digit

        while(!queue.isEmpty()){
            //get the length of current removed string
            String currentWord = queue.poll();

            int currentWordLength = currentWord.length();
            // if the length is equal we have one combination else
            if(currentWordLength == digits.length()){
                result.add(currentWord);
                continue;
            }
            // get the digit at currentWordLength and get its string value was map is Map<String, String>
            String nextMapping =  hashMap.get(digits.charAt(currentWordLength) - '0'); // - '0' to convert to int value
            for(char c : nextMapping.toCharArray()){
                queue.add(currentWord+c);
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        String keys = "23222";
        letterCombinations(keys);
    }
}
