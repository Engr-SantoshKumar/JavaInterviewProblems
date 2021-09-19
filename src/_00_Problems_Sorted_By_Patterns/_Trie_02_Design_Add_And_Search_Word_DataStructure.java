/* [ _Trie_02_ ] [ Design Add and Search Words Data Structure | Wild Card ]
_______________________________________________________________________________
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary()     ---> Initializes the object.
void addWord(word)   ---> Adds word to the data structure, it can be matched later.
bool search(word)    ---> Returns true if there is any string in the data structure that matches word or
                          false otherwise. word may contain dots '.' where dots can be matched with any letter.

WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.HashMap;
import java.util.Map;

public class _Trie_02_Design_Add_And_Search_Word_DataStructure {

    /* Node class to store char and 26 element array of each possible child node it may have    */
    static class TrieNode{

        boolean endingWord;
        Map<Character, TrieNode> childrenMap; // can use map or array of 26

        public TrieNode() {
            endingWord =false;
            childrenMap = new HashMap<>();
        }
    }

    static class WordDictionary {
        TrieNode root;

        public WordDictionary() {
            root= new TrieNode();
        }

        public void addWord(String word) {
            TrieNode currentNode = root;
                for(char ch: word.toCharArray()){
                    currentNode.childrenMap.putIfAbsent(ch, new TrieNode());
                    currentNode = currentNode.childrenMap.get(ch);
                }
            currentNode.endingWord = true;
        }

        /*
        Time complexity: O(M) for the "well-defined" words without dots,
        where M is the key length, and N is a number of keys, and O(N*26^M ) for the "undefined" words.
        That corresponds to the worst-case situation of searching an undefined word
         */
        public boolean search(String word){
            return searchHelper(word, root);
        }
        public boolean searchHelper(String word, TrieNode currentNode) {
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if (!currentNode.childrenMap.containsKey(ch)) {
                    // if the current character is '.' check all possible nodes at this level
                    if (ch == '.') {
                        for (char x : currentNode.childrenMap.keySet()) {
                            TrieNode child = currentNode.childrenMap.get(x);
                            if (searchHelper(word.substring(i + 1), child)) {
                                return true;
                            }
                        }
                    }
                    // if no nodes lead to answer or the current character != '.'
                    return false;
                } else {
                    // if the character is found go down to the next level in trie
                    currentNode = currentNode.childrenMap.get(ch);
                }
            }
            return currentNode.endingWord;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        //wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
        System.out.println(wordDictionary.search(".a"));  // return false
    }
}
