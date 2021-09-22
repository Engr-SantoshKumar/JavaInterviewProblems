/**
 * [ ] [ ]
 * -----------------------------------------------------------------------------------------------------
 * PROBLEM STATEMENT:
 I nput: str = “cd”
 Output: cd dc

 Input: str = “abb”
 Output: abb abb bab bba bab bba
 * TIME COMPLEXITY:
 */
package PrepSetOne;

import java.util.ArrayList;
import java.util.List;

public class _Goo_58_00_Permutations_Of_String {

    static List<String>  result= new ArrayList<String>();

    public static List<String> letterCombinations(String str){
        if(str.length()!=0){
            createStrings( "", str);
        }
        return result;
    }

    public static void createStrings(String combinations, String str  ){
        // if no digit left, the combination is done
        //System.out.println(combinations);
        if(str.length()==0)
        {
            result.add(combinations);
        }
        else
        {
            for(int i=0; i < str.length(); i++){
                // ith char of string
                char currentCh = str.charAt(i);

                //  remaining chars --> all chars before i + all chars after i;
                String remChars = str.substring(0, i) + str.substring(i+1);

                // call fun again with remaining chars and current combination + currentCh
                createStrings(combinations+currentCh, remChars);
            }
        }
    }

    public static void main(String[] args) {
        String s = "ABC";
        List<String> result= new ArrayList<String>();
        result = letterCombinations(s);

        for(String words : result){
            System.out.println(words);
        }

    }

}
