/** 20 [Longest Common Prefix]
 -------------------------------------------------------------------------------------------------------
 "Find the longest common prefix from a set of strings.
 “aaabbb”
 “aabbb”
 “abcde”
 return “a”
 */
package PrepSetOne;

import java.util.Arrays;
import java.util.List;

public class _Goo_20_Longest_Common_Prefix {

    static String longestPrefix(List<String> list ){

        for(String s: list){
            if (s.length() == 0) {
                System.out.println("there is a blank string in list");
                return "";
            }
        }
        String prefix ="";

        for(int i =0; i < list.get(0).length(); i++){

            char c = list.get(0).charAt(i);
            boolean match = true;

            for(String s:list){
                if(s.length() > i+1  &&  c!=s.charAt(i)){
                    match = false;
                    break;
                }
            }
            if(match){
                prefix+=c;
            }else{
                break;
            }
        }
        System.out.println(prefix);
        return prefix;
    }

    public static void main(String args[]){
        String[] ar = {"aaabbb", "aa", "aabcde"};
        String[] ar1 = {"aaa", ""};
        System.out.println(longestPrefix(Arrays.asList(ar)));
    }
}
