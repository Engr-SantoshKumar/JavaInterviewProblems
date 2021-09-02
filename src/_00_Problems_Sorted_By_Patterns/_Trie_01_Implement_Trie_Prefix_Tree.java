/* [  ] [ Implement Trie (Prefix Tree) ]
_______________________________________________________________________________
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys
in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) -->  Inserts the string word into the trie.
boolean search(String word) --> Returns true if the string word is in the trie
boolean startsWith(String prefix) --> Returns true if that has the prefix prefix, and false otherwise.


Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
*/
package _00_Problems_Sorted_By_Patterns;
public class _Trie_01_Implement_Trie_Prefix_Tree {

    /* Node class to store char and 26 element array of each possible child node it may have    */
    static class TrieNode{
        char val;
        int endingCount;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }

        public TrieNode(char ch){
            TrieNode TrieNode = new TrieNode();
            TrieNode.val = ch;
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
            root.val = '/';
        }
         /** [Insertion of a key] We insert a key by searching into the trie.
             * We start from the root and search a link, which corresponds to the first key character.
             * There are two cases :
                 A link exists. Then we move down the tree following the link to the next child level.
                                The algorithm continues with searching for the next key character.
                 A link does not exist. Then we create a new node and link it with the parent's link matching
                                the current key character. We repeat this step until we encounter the last character
                                of the key, then we mark the current node as an end node and the algorithm finishes.

         ●  Time complexity : O(m)O(m), where m is the key length.
         ●  Space complexity : O(m)O(m).   */

         public void insert(String word) {
            TrieNode current = root;
            // loop through each char and if present their corresponding node until the end
            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                // once found the empty node in child array, create a new node and put and continue for rest
                if(current.children[ch-'a'] == null){
                    current.children[ch-'a'] = new TrieNode(ch);
                }
                 current = current.children[ch-'a'];
            }
            //now we finished inserting nodes for each char ..need to indicate the end of word
            current.endingCount =1;
        }
         /** [Search for a key in a trie]
            Each key is represented in the trie as a path from the root to the internal node or leaf.
            We start from the root with the first key character.
         There are two cases :
             A link exist. We move to the next node in the path following this link,
                            and proceed searching for the next key character.

             A link does not exist. If there are no available key characters and current node is marked as isEnd.
                                we return true. Otherwise there are possible two cases in each of them we return false
             Time complexity : O(m)O(m) In each step of the algorithm we search for the next key character.
             In the worst case the algorithm performs mm operations.
         */

        public boolean search(String word) {
            TrieNode current = root;
            // loop through each char and if present their corresponding node until the end
            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                // once found the empty node in child array, create a new node and put and continue for rest
                if(current.children[ch-'a'] == null) return false;
                current = current.children[ch-'a'];
            }
            return current.endingCount > 0;
        }

        /**The only difference with the mentioned above search for a key algorithm is that
         * when we come to an end of the key prefix, we always return true.
         * We don't need to consider the isEnd mark of the current trie node,
         * because we are searching for a prefix of a key, not for a whole key.*/
        public boolean startsWith(String prefix) {
            TrieNode current = root;
            // loop through each char and if present their corresponding node until the end
            for(int i=0; i<prefix.length(); i++){
                char ch = prefix.charAt(i);
                // once found the empty node in child array, create a new node and put and continue for rest
                if(current.children[ch-'a'] == null) return false;
                current = current.children[ch-'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));    // return True
        System.out.println(trie.search("app"));      // return False
        System.out.println(trie.startsWith("app"));         // return True
        trie.insert("app");
        System.out.println(trie.search("app"));      // return True
    }

}
