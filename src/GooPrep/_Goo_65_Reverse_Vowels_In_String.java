/**  65 [Reverse Vowels in String]
 ____________________________________________________________________________________________________________________
 Write a function that takes a string as input and reverse only the vowels of a string.

 Input: "hello"
 Output: "holle"
 */
package GooPrep;

import java.util.HashSet;
import java.util.Set;

public class _Goo_65_Reverse_Vowels_In_String {
    static String reverseVowels(String str) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] car = str.toCharArray();
        int i = 0;
        int j = car.length - 1;
        while (i < j) {
            //keep increasing i until it finds a vowel
            while (i < j && !vowels.contains(car[i])) {
                i++;
            }
            //keep decreasing j until it finds a vowel
            while (i < j && !vowels.contains(car[j])) {
                j--;
            }
            char temp = car[i];
            car[i] = car[j];
            car[j] = temp;
            i++;
            j--;
        }
        return new String(car);
    }

    static void testFor(String sentence){
        System.out.print("\n: input : "+sentence);
        System.out.print(" => : "+reverseVowels(sentence));
    }
    public static void main(String[] args) {
        //String sentence = "epppppppi";
        testFor("epppppppi");
        testFor("aA");
        testFor("united states");
        testFor("united");
        testFor("");
        testFor("sun");
        testFor("moon");
        testFor("**{}");
        testFor("magic");
        testFor("maec");
        testFor("mntc");

    }
}
