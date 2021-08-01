/* [ _Monotone_Stack_05_] [ Remove Duplicate Letters Monotone Stack ]
_______________________________________________________________________________
Given a string s, remove duplicate letters so that every letter appears once and only once.
You must make sure your result is the smallest in lexicographical order among all possible results.
Logic One: use array of 26, add char to array and ready it again O(N+N) we will not able to maintain order
Logic Two: Using Monotone stack
           Time complexity : O(n), n is the number of chars in string.
           Space complexity: O(n) worst case.

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class _Monotone_Stack_05_Remove_Duplicate_Letters {
    public static String removeDuplicate(String str){
        Stack<Character> stack = new Stack<>();

        // will use set to keep track of already visited ones in O(1)
        HashSet<Character> hashSet = new HashSet<>();

        // will keep map to have furthest index of any char
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            hashMap.put(str.charAt(i), i);
        }

        for(int i = 0; i < str.length(); i++){
            char incomingChar = str.charAt(i);
            //
            if (!hashSet.contains(incomingChar)){
                //Logic is pretty simple, we will check if incoming curChar is smaller than charAtTopOfStack
                //if so we check, do we have top of stack char again in somewhere in the string later(compare curIndx with mapValue)
                // if so its safe to remove top of stack (largerThanCurIncoming) and as we move forward in string we can add later
                // this we maintain the smallest in the beginning of our result
                while(!stack.isEmpty() && incomingChar < stack.peek() && hashMap.get(stack.peek()) > i){
                    hashSet.remove(stack.pop());
                }
                hashSet.add(incomingChar);
                stack.push(incomingChar);
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
