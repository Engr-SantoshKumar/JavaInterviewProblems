/* [ _oA_56_ ] [ Remove Duplicate Letters Monotone Stack ]
_______________________________________________________________________________
Given a string s, remove duplicate letters so that every letter appears once and only once.
You must make sure your result is the smallest in lexicographical order among all possible results.
Logic One: use array of 26, add char to array and ready it again O(N+N) we will not able to maintain order
Logic Two: Using Monotone stack
           Time complexity : O(n), n is the number of chars in string.
           Space complexity: O(n) worst case.

*/
package Code_Run_Build_LC350;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class _oA_56_Remove_Duplicate_Letters_Monotone_Stack {
    public static String removeDuplicate(String str){

        Stack<Character> stack = new Stack<>();

        // this lets us keep track of what's in our solution in O(1) time
        HashSet<Character> hashSet = new HashSet<>();

        // this will let us know if there are any more instances of s[i] left in s
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            hashMap.put(str.charAt(i), i);
        }

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            // we can only try to add c if it's not already in our solution
            // this is to maintain only one of each character
            if (!hashSet.contains(c)){
                // if the last letter in our solution:
                //     1. exists
                //     2. is greater than c so removing it will make the string smaller
                //     3. it's not the last occurrence
                // we remove it from the solution to keep the solution optimal
                while(!stack.isEmpty() && c < stack.peek() && hashMap.get(stack.peek()) > i){
                    hashSet.remove(stack.pop());
                }
                hashSet.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) sb.append(c.charValue());
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicate("bcabca"));
    }


}
