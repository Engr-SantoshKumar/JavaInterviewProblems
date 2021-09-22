/** 32  [First Char Not In Alphabetical Order]
 ---------------------------------------------------------------------------------------------------------
 Write a function that, given a string,
 find the first character not in alphabetical order.
 For example, given the string “Beehive”, it should return 6.
 */

package PrepSetOne;

public class _Goo_32_First_Char_Not_In_Alphabetical_Order {

    public static void main(String args[]){
        String s = "Beehive";
        String s1 = "Beehiv";
        firstNonAlpha(s);
        firstNonAlpha(s1);
    }

    static void firstNonAlpha(String s){
        char[] ar = s.toLowerCase().toCharArray();
        char prev = ar[0];
        for(int i = 1; i<ar.length; i++){
            if(ar[i] < prev){
                System.out.println(" First Char in [" + s + "] "
                        +
                        "which is not in alphabetical Order is "+ar[i]+ " at index "+i);
                return;
            }
            prev = ar[i];
        }
        System.out.println("[" + s + "]" + " is good string");
    }
}
    