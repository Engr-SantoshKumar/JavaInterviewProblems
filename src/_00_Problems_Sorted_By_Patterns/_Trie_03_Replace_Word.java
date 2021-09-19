/* [ _Trie_03_ ] [ Replace Words ]
_______________________________________________________________________________
Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces,
replace all the successors in the sentence with the root forming it.
If a successor can be replaced by more than one root, replace it with the root that has the shortest length.

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _Trie_03_Replace_Word {
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

    public static String replaceWords(List<String> dictionary, String givenSentence) {
        TrieNode root= new TrieNode('/');
        createTrieDictionary(dictionary, root);
        String[] words = givenSentence.split(" ");
        return replaceWords(words, root);
    }

    private static void createTrieDictionary(List<String> dictionary, TrieNode root) {
        TrieNode currentNode = root;
        for(String word: dictionary){
            for(char ch: word.toCharArray()){
                currentNode.childrenMap.putIfAbsent(ch, new TrieNode(ch));
                currentNode = currentNode.childrenMap.get(ch);
            }
            currentNode.endingWord = true;
            currentNode = root;
        }
    }
    private static String replaceWords(String[] words, TrieNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            //creating string
            stringBuilder.append(getShortestReplacement(word, root));
            stringBuilder.append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length()-1);
    }
    /*
        Logic: keep digging in the Trie until the matching char and keep adding each char to SB and
        as soon as a node has endWord --> true return the SB
     */
    private static String getShortestReplacement(String word, TrieNode root) {
        TrieNode currentNode = root;
        StringBuilder stringBuilder = new StringBuilder();
        //creating word
        for (char ch : word.toCharArray()) {
            stringBuilder.append(ch);
            if (currentNode.childrenMap.containsKey(ch)) {
                if (currentNode.childrenMap.get(ch).endingWord) {
                    return stringBuilder.toString(); //--> returning the shorter word
                }
                currentNode = currentNode.childrenMap.get(ch);
            } else {
                return word; // --> returning same word
            }
        }
        return word; // --> returning same word
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary, sentence));
    }

}
