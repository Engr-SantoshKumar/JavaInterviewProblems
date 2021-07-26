/* [ _SlidingWindow_05_  ] [ Words Concatenation ]
_______________________________________________________________________________
Given a string and a list of words, find all the starting indices of substrings in the given string
that are a concatenation of all the given words exactly once without any overlapping of words.
It is given that all words are of the same length. --> note all words are of same length
String="catfoxcat", Words=["cat", "fox"]
Output: [0, 3]
Explanation: The two substring containing both the words are "catfox" & "foxcat".

Logic:
Sliding Window pattern --> similarities -->  Maximum Sum Subarray of Size K.
We will keep track of all the words in a HashMap and try to match them in the given string.
Here are the set of steps for our algorithm:

Keep the frequency of every word in a HashMap.
Starting from every index in the string, try to match all the words.
In each iteration, keep track of all the words that we have already seen in another HashMap.
If a word is not found or has a higher frequency than required, we can move on to the next character in the string.
Store the index if we have found all the words.
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _SlidingWindow_05_Words_Concatenation {
        public static List<Integer>  findWordConnections(String str, String[] wordsArray){
            //load the words into map with frequency
            Map<String, Integer> mapWordFrequency = new HashMap<>();
            for(String word:wordsArray){
                mapWordFrequency.put(word, mapWordFrequency.getOrDefault(word, 0)+1);
            }

            //Some variables
            List<Integer> resultIndices = new ArrayList<>();
            int windowStart=0;
            int wordsCount = wordsArray.length;
            int wordLength = wordsArray[0].length();
            int wordsLengthAllTogether = wordLength*wordsArray.length;

            //Scan the string
            for(int i =0; i<=str.length()-wordsLengthAllTogether; i++){
                //we need to keep count of seen words in current window
                Map<String, Integer> mapWordsSeen = new HashMap<>();
                //lets see if we can find all words starting from i
                for(int j =0; j < wordsCount; j++){
                    int nextWordStartIndex = i + j*wordLength; // if i=0; 1st word start4m index 0 + 0*3 =>0, 2nd --> 0+1*3=>3

                    // get the next word from the string
                    String curWord = str.substring(nextWordStartIndex, nextWordStartIndex+wordLength);
                    //is this word present in wordFrqMap
                    System.out.println(curWord);
                    if(!mapWordFrequency.containsKey(curWord)) {
                        System.out.println("mapDoesNotContains ---> " + curWord);
                        break; //--> no need to look further for current index i
                    }
                    //store the curWord in seenMap with frequency
                    mapWordsSeen.put(curWord, mapWordsSeen.getOrDefault(curWord, 0)+1);
                    // no need to process further if the curWord frequency is more than required
                    if(mapWordsSeen.get(curWord) > mapWordFrequency.get(curWord)){
                        System.out.println("Seen is more than required  ---> " + curWord);
                        break;
                    }

                    //store the index if we have found all the words
                    if(j +1 == wordsCount)
                        resultIndices.add(i); //--> from index i we have all the connectedWords

                }
            }
            return resultIndices;
        }

    public static void main(String[] args) {
        String str1 = "catcatfoxfox";
        String[] wordsArray1 = new String[]{"cat", "fox"};
        //System.out.println(findWordConnections(str1,wordsArray1));

        String str = "wordgoodgoodgoodbestword";
        String[] wordsArray = new String[]{"word","good","best","good"};
        System.out.println(findWordConnections(str,wordsArray));
    }


}
