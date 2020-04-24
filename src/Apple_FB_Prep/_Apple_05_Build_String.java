/**
[ Apple_05] [ Build String ]
_________________________________________________________________________________________________________
 Given two strings S and T, return if they are equal when both are typed into empty text editors.
 # means a backspace character.
 Note that after backspacing an empty text, the text will continue empty.
 Example 1:
 Input: S = "ab#c", T = "ad#c"
 Output: true
 Explanation: Both S and T become "ac".
 Input: S = "a##c", T = "#a#c"
 Output: true
 Explanation: Both S and T become "c".
 */
package Apple_FB_Prep;

import java.sql.SQLOutput;
import java.util.Stack;

public class _Apple_05_Build_String {

    //Simple concept of stack
    static boolean BuildStringUsingStack(String s1, String s2){
        return helperMethodBuildString(s1).equals(helperMethodBuildString(s2));
    }
    static String helperMethodBuildString(String s){
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch!='#'){
                stack.push(ch);
            }else if(!stack.empty()){
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }

    /*Traverse both the strings from the end until we encounter an undeleted character in each.
    Compare them and return false if not the same.*/

    static boolean buildStringTwoPointers(String S, String T){
        char[] s1 = S.toCharArray();
        char[] s2 = T.toCharArray();
        int i = s1.length-1; int j = s2.length-1;
        int s1backSpace =0, s2backSpace=0;

        while (i >= 0 || j >= 0){
            if(i >= 0 && s1[i] == '#'){ // keep moving i and increase the backspace count
                i--; s1backSpace ++;
            }
            else if(s1backSpace > 0){ // still keep moving i until any backspace count left
                i--; s1backSpace --;
            }
            else if( j >= 0 && s2[j] == '#'){
                j--; s2backSpace ++;
            }
            else if(s2backSpace > 0){
                j--; s2backSpace--;
            }

            // now i and j both at char after deleting the required
            // check if char at i and j are same
            else if( i < 0 || j < 0 || s1[i] != s2[j] ) return false;

            else{
                i--; j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "a##c", T = "#a#c";
        String S1 = "aa#a##cc#", T1 = "#aa#c";
        System.out.println(BuildStringUsingStack(S, T));
        System.out.println(buildStringTwoPointers(S1, T1));
    }
}


