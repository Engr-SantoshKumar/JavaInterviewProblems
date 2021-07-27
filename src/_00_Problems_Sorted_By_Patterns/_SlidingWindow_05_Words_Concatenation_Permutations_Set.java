/*[ _SlidingWindow_05_  ] [ Words Concatenation ]
_______________________________________________________________________________
    Given a string and a list of words, find all the starting indices of substrings in the given string
    that are a concatenation of all the given words exactly once without any overlapping of words.
    It is given that all words are of the same length. --> note all words are of same length
    String="catfoxcat", Words=["cat", "fox"]
    Output: [0, 3]
    Explanation: The two substring containing both the words are "catfox" & "foxcat".
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.*;
import java.util.LinkedList;

public class _SlidingWindow_05_Words_Concatenation_Permutations_Set {
    public static List<Integer> findWordConnections(String str, String[] wordsList){
        List<List<String>> allPermutations = findPermutation(wordsList); // o/p [foo, bar], [bar,foo]
        List<String> connectedWord = connectWords(allPermutations);// o/p {foobar, barfoo}
        HashSet<String> hashsetWords = new HashSet<>();
        for(String curStr: connectedWord){
            hashsetWords.add(curStr);
        }
        //System.out.println(hashsetWords);
        //Scan the string
        List<Integer> resultIndices = new ArrayList<>();
        int wordsCount = wordsList.length;
        int totalWordLength = wordsList[0].length()*wordsCount;
        for(int i =0; i<=str.length()-totalWordLength; i++) {
            String curWord = str.substring(i, i + totalWordLength);

            if(hashsetWords.contains(curWord)){
                resultIndices.add(i);
            }
        }
        return resultIndices;
    }

    //finding permutations using BFS --> N! permutations of a set with ‘N’ numbers To insert a number into a
    // permutation of size ‘N’ will take O(N),O(N), which makes the overall time complexity of our algorithm O(N*N!)
    private static List<List<String>> findPermutation(String[] wordsList) {
        List<List<String>> result = new ArrayList<>();
        Queue<List<String>> queue = new ArrayDeque<>();
        queue.add(new ArrayList<>());
        for (String currentWord : wordsList) {
            //we will take all the existing permutations and add the current word
            int batch = queue.size();
            for (int i = 0 ; i < batch; i++) {
                List<String> current = queue.poll();
                //creating a new permutation by adding the current word at every position
                for (int j = 0; j <= current.size(); j++) {
                    List<String> temp = new LinkedList<>(current);
                    temp.add(j, currentWord); // (j,currentWord) --> (atIndex j , add currentWord)
                    queue.add(temp);

                    if (temp.size() == wordsList.length) {
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }
    //Therefore the overall space complexity to store N! permutations each containing NN elements will be O(N*N!)
    private static List<String> connectWords(List<List<String>> allPermutations) {
        List<String> result = new ArrayList<>();
        for(List<String> current: allPermutations){
            StringBuilder newWord = new StringBuilder();
            for(String str:current){
                newWord.append(str);
            }
            result.add(String.valueOf(newWord));
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "wordgoodgoodgoodbestword";
        String[] wordsArray = new String[]{"word","good","best","good"};
        System.out.println(findWordConnections(str,wordsArray));
    }
}
