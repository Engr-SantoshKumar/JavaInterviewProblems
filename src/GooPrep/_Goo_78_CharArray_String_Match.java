/**
 * [78] [Given a charArray and String, find if possible to create string using charArray ]
 * --------------------------------------------------------------------------------------------------------------
 * PROBLEM STATEMENT:
 Given a char array and a word, write a function to tell if the word can be made using the chars from char array.
 (note: no need to use all the chars in char array, and each char in the char array can only be used once.)
 e.g:
 * <p>
 * <p>
 * TIME COMPLEXITY:
 */
package GooPrep;

public class _Goo_78_CharArray_String_Match {

    public static void isPossibleTOCreateWord(char[] chrArr, String s){

        int[] charCout = new int[26];

        for(char c: chrArr){
            charCout[c - 'A'] ++;
        }

        for(int i =0; i<s.length(); i++){
            if(charCout[s.charAt(i) - 'A' ] == 0){
                System.out.println("Not Possible");
                return;
            }else{
                charCout[s.charAt(i) - 'A' ] --;
            }
        }

        System.out.println("Possible to make");

    }


    public static void main(String[] args) {
        char[] chrArr = {'A', 'B', 'C', 'D' };
        String s = "ABCCD";
        String s1 = "CDB";
        isPossibleTOCreateWord(chrArr, s);
        isPossibleTOCreateWord(chrArr, s1);
    }
}
