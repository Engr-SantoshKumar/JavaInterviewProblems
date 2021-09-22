/**
 * [ Goo2_29 ] [ Alien Dictionary   ]
 * _____________________________________________________________________________________________________________
 There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 You receive a list of non-empty words from the dictionary, where words are sorted
 lexicographically(Lexicographic order is the way of ordering of words based on the alphabetical order of
 their component letters. by the rules of this new language. Derive the order of letters in this language.

Input: [ "wrt", "wrf", "er", "ett", "rftt"]
Output: "wertf"
 */
package PrepSetTwo;

import java.util.*;

public class _Goo2_29_Alien_Dictionary {
    static String alienAlphabetsOrder(String [] words){
        String result="";
        Map<Character, Integer> mapDegree = new HashMap<>();// if count is zero means its first char of Alpha
        Map<Character, Set<Character>> mapCharAdjList = new HashMap<>();//for next linked char
        Queue<Character> queue = new ArrayDeque<>();//for BFS

        // Step 1: Create data structures and find all unique letters and its count(count port we will handle later)
        for(String word : words){
            for(char c: word.toCharArray()){
                mapDegree.put(c,0);
            }
        }

        // Step 2: Find all edges.
        for(int i =0; i < words.length-1; i++){
            String fstWord = words[i];
            String sndWord = words[i+1];
            //finding the first not matching char e.g : sklf, skdg --> this means l is before d
            int minWordLength = Math.min(fstWord.length(), sndWord.length());
            for(int j =0; j<minWordLength; j++){
                char firstChar = fstWord.charAt(j);
                char secChar   = sndWord.charAt(j);
                if( firstChar != secChar){
                    if(!mapCharAdjList.containsKey(firstChar)){
                        mapCharAdjList.put(firstChar, new HashSet<>());
                    }
                    mapCharAdjList.get(firstChar).add(secChar);
                    //update charCount map too
                    mapDegree.put(secChar, mapDegree.get(secChar)+1);
                    break; // as we just need the 1st only unmatched char
                }
            }
        }

        // Step 2: BFS, we need to look for all the entries which value is zero(there will be at-least one entry)
        // that will be the first letter for the language

        for(char c : mapDegree.keySet()){
            if(mapDegree.get(c)==0) queue.offer(c);
        }
        //bfs
        while(!queue.isEmpty()){
            char currentChar = queue.poll();
            result+=currentChar;
            if(mapCharAdjList.containsKey(currentChar)){
                for(char c: mapCharAdjList.get(currentChar)){
                    mapDegree.put(c, mapDegree.get(c)-1);
                    if(mapDegree.get(c)==0){
                        queue.add(c);
                    }
                }
            }
        }
        if(result.length()!=mapDegree.size()) return "";
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "wrd", "er", "ett", "rftt"};
        String[] words1 = {"ac","ab","zc","zb"};
        //System.out.println(alienAlphabetsOrder(words));
        System.out.println(alienAlphabetsOrder(words1));
    }
}
