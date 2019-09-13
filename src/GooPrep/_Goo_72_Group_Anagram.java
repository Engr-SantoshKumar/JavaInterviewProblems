/**
 * [72] [Group Similar Characters Words Together (Group Anagram)   ]
 * --------------------------------------------------------------------------------------------------------------
 * PROBLEM STATEMENT: Given a list words with lowercase and uppercase characters.
 * Implement a function to find all words that have unique character set.
 * <p>
 * e.g:
 * <p>
 * <p>
 * TIME COMPLEXITY:
 */
package GooPrep;

import java.util.*;

public class _Goo_72_Group_Anagram {
    public static void main(String[] args) {
        int x = 'a';
        System.out.println(x);
        String words[] = {"Eat", "Tea", "Tan", "Ate", "Nat", "Bat"};

        List<List<String>> result = groupAnagrams(words);

        for (List<String> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0)
            return new ArrayList<List<String>>();

        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String s : strs) {
            String keyStr = getKey(s);
            if (!map.containsKey(keyStr)){
                map.put(keyStr, new ArrayList<String>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static String getKey(String str){
        char[] arr = new char[26];
        for(int i=0; i<str.length(); i++){
            char lowCase = Character.toLowerCase(str.charAt(i));
            arr[lowCase -'a']++;
        }
        String nKey = new String(arr);
        return nKey;
    }
}


