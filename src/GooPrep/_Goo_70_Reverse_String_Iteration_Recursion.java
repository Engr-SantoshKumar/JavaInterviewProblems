/**
[70] [ Reverse String Iteration Recursion]
--------------------------------------------------------------------------------------------------------------
 * PROBLEM STATEMENT:
 Write two functions to reverse a String using the following approaches: iteration and recursion.
 */
package GooPrep;

public class _Goo_70_Reverse_String_Iteration_Recursion {

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
    static String reverseUsingRecursion(String s) {
        if (s == null) {
            System.out.println("Invalid input");
        }
        char[] chArray = s.toCharArray();
        return new String(chArray);
    }
    static void reverseRec(char[] ar, int start, int end) {
        if (end <= start) {
            return;
        }
        reverseRec(ar, start + 1, end - 1);
        swap(start, end, ar);
    }
    static void swap(int i, int j, char[] car) {
        char temp = car[i];
        car[i++] = car[j];
        car[j--] = temp;
    }

    //Test
    public static void main(String args[]) {
        testFor("");
        testFor("S");
        testFor("DJ");
        testFor("SUN");
        testFor("ABCD");
        // testFor(null);
    }
    static void testFor(String s)  {
        System.out.println(" input " + s + " rev " + reverse(s));
        System.out.println(" input " + s + " revrec " + reverseUsingRecursion(s));
    }


}
