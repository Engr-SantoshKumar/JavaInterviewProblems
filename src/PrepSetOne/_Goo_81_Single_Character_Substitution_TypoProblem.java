/**
 * [81] [Typo Problem]
 * --------------------------------------------------------------------------------------------------------------
 * PROBLEM STATEMENT:
You have a list of words in English (your vocabulary).
 Code a method for determining if an arbitrary string can be changed to a word
 in your vocabulary with a single character substitution. What is the big O for your algorithm?

 Example:
 vocab = ['apple', 'pineapple', 'banana', 'cucumber']
 singleTypo('adple') # True
 singleTypo('addle') # False
 singleTypo('aple') # False

 Let n be the length of vocab, and let k be the length of a typical word. """
 */
package PrepSetOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _Goo_81_Single_Character_Substitution_TypoProblem {

    public static boolean isSingleTypo(String[] vocab, String s ){

        if(vocab == null || s.length()==0) return false;
        Map<Integer, ArrayList> map = new HashMap<>();

        //sort the vocab based on size
        for(String word: vocab){
            int len = word.length();
            map.putIfAbsent(len, new ArrayList<>());
            map.get(len).add(word);
        }

        //get all the words from Vocab having size of s
        ArrayList<String> sameLengthWords = map.get(s.length());

        for(String word: sameLengthWords){
            int diffChar =0;
            for (int i =0; i< s.length();i++){
                if(word.charAt(i)!=s.charAt(i)){
                    diffChar ++;
                    if(diffChar>1){
                        System.out.println(word + ": is not singleCharTypo of : " + s);
                        break;
                    }
                }
            }
            if(diffChar ==1) {
                System.out.println(word + ": is a singleCharTypo of : " + s);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] vocab = {"apple", "pineapple", "banana", "cucumber", "apeee", "ppdle"};
        String word = "apdle";

        isSingleTypo(vocab, word);
    }


}
