/**
[70] [ Reverse String Iteration Recursion]
--------------------------------------------------------------------------------------------------------------
 * PROBLEM STATEMENT:
 Write two functions to reverse a String using the following approaches: iteration and recursion.
 */
package PrepSetOne;

public class _Goo_70_01_Reverse_String_Iteration_Recursion {

    //iteration way
    static String reverse(String s){
        if(s==null || s.length() <1){
            System.out.println("Invalid input");
        }
        char[] chArray = s.toCharArray();
        int start=0;
        int end = chArray.length-1;

        while(start<end){
            char temp = chArray[start];
            chArray[start] = chArray[end];
            chArray[end] = temp;
            start++;
            end --;
        }
        return new String(chArray);
    }

    //Recursion way

    public static void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }
    public static void helper(char[] s, int left, int right) {
        if (left >= right) return;
        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
        helper(s, left, right);
    }



    //Test
    public static void main(String args[]) {
        testFor("ABCD");
        testFor("S");
        testFor("DJ");
        testFor("SUN");
        testFor("ABCD");
    }
    static void testFor(String s)  {
        //System.out.println(" input " + s + " rev " + reverse(s));
        //System.out.println(" input " + s + " revrec " + reverseUsingRecursion(s.toCharArray()));
    }


}
