/* [ _Trie_04_ ] [ word break ]
_______________________________________________________________________________
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
*/
package _00_Problems_Sorted_By_Patterns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _Trie_04_Word_Break {

    public static boolean wordBreak(String str, List<String> wordDict) {
        TrieNode root = new TrieNode('/');
        createTrieDictionary(wordDict, root);
        //we store true/false at each index if we able to form a valid word from wordDict
        boolean[] dp = new boolean[str.length()+1];
        char[] chars = str.toCharArray();
        dp[0] = true;
        
        for(int i=0; i<chars.length; i++){
            if(dp[i]==false) continue;
            // start trie traversal
            int j = i;
            TrieNode curNode = root;
            while (j < chars.length && curNode.childrenMap.containsKey(chars[j])) {
                curNode = curNode.childrenMap.get(chars[j]);
                j++;
                if (curNode.endingWord)
                    dp[j] = true;
            }
        }
        return dp[str.length()];
    }

    private static void createTrieDictionary(List<String> wordDict, TrieNode root) {
        TrieNode curNode = root;
        for(String word: wordDict) {
            for (char ch : word.toCharArray()) {
                curNode.childrenMap.putIfAbsent(ch, new TrieNode(ch));
                curNode = curNode.childrenMap.get(ch);
            }
            curNode.endingWord = true;
            curNode = root;
        }
    }

    public static void main(String[] args) {
       /* List<String> dictionary = new ArrayList<>();
        dictionary.add("apple");
        dictionary.add("pen");
        String sentence = "applepenapple";
        System.out.println(wordBreak(sentence, dictionary)); */

        List<String> dictionary1 = new ArrayList<>();
        dictionary1.add("cats");dictionary1.add("dog");
        dictionary1.add("sand");dictionary1.add("and");dictionary1.add("cat");
        String sentence1 = "catsandog";
        System.out.println(wordBreak(sentence1, dictionary1));
    }

    /* Node class to store char | endOfAnyWord | mapOfChildren */
    static class TrieNode{
        boolean endingWord;
        char ch;
        HashMap<Character, TrieNode> childrenMap; // can use map or array of 26

        public TrieNode(char ch){
            this.ch = ch;
            this.childrenMap = new HashMap<>();
            this.endingWord = false;
        }
    }
}
