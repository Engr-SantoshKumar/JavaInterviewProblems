/**  65 [Reverse Vowels in String]
 ____________________________________________________________________________________________________________________
 Write a function that takes a string as input and reverse only the vowels of a string.

 Input: "hello"
 Output: "holle"
 */
package PrepSetOne;

import java.util.Set;

public class _Goo_65_Reverse_Vowels_In_String {
    static String reverseVowels(String str) {
        Character[] vowel = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        Set<Character> vowels = Set.of(vowel);
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
