/**
[Goo 96] [ Rope DataStructure  ]
 ____________________________________________________________________________________________________________________
 Find the longest word in a Rope, bearing in mind that a word can cross string boundaries.
 For instance, in ["hell", "o foo"], "hello" is the longest word. In ["hell", "o world"],
 "hello" is the first word found.
 Q1. Implement indexOf on a Rope, e.g., in [“hell”, “o world”], rope.indexOf(‘o’) would give 4.
 Q2. Find the longest word in a Rope, bearing in mind that a word can cross string boundaries.
    For instance, in ["hell", "o foo"], "hello" is the longest word. In ["hell", "o world"], "hello" is the first
    word found.
 Q3. Implement either indexOf or extractVowels using the mechanism
 https://docs.google.com/spreadsheets/d/1iIYlDY2zZV7yYVQ5BfNdReVmixTZMfxS01Bhas9mjN0/edit#gid=668355055

 SOME MORE READING
 50:24 - Rope Operations https://www.youtube.com/watch?v=erKlLEXLKyY
 https://www.geeksforgeeks.org/ropes-data-structure-fast-string-concatenation/

 One of the most common operations on strings is appending or concatenation.
 Appending to the end of a string when the string is stored in the traditional manner (i.e. an array of characters)
 would take a minimum of O(n) time (where n is the length of the original string).

 We can reduce time taken by append using Ropes Data Structure.
 A Rope is a binary tree structure where each node except the leaf nodes, contains the number of characters
 present to the left of that node. Leaf nodes contain the actual string broken into substrings
 (size of these substrings can be decided by the user).

 */
package GooPrep;

import java.util.*;

public class _Goo_96_Rope_Question {
    static List<String> rope = Arrays.asList("hell", "o world", "toAll");

    // Logic is keep constructing string until you hit a " " ---> update longest
    private static String findLongest() {
        String longestSoFar = "";
        String currentWord = "";

        //get the first word
        for (String ropePart : rope) {
            for (char c : ropePart.toCharArray()) {
                if (c == ' ') {
                    if (currentWord.length() > longestSoFar.length()) {
                        longestSoFar = currentWord;
                    }
                    currentWord = "";
                } else {
                    currentWord += c;
                   // System.out.println(currentWord);
                }
            }
        }
        if (currentWord.length() > longestSoFar.length()) {
            longestSoFar = currentWord;
        }
        return longestSoFar;
    }
    private static int findIndexOf(char ch) {
        int i = 0;
        for (String ropePart : rope) {
            for (char c : ropePart.toCharArray()) {
                if (ch == c) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }
    private static List<Character> extractVowels(){
        List<Character> result = new ArrayList<>();
        Character[] vowel = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        Set<Character> vowels = Set.of(vowel);
        for(String word : rope){
            for(char ch: word.toCharArray()){
                if(vowels.contains(ch)){
                    result.add(ch);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findLongest());
        System.out.println(findIndexOf('o'));
        System.out.println(extractVowels());
    }






}
