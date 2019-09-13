// logic is same like removing white space and pushing all zeros to one side
//Use read and write pointers.

package _01_Coderust._04_String;

import java.util.HashSet;
import java.util.Set;

public class _x_01_Remove_Duplicates {

    public static void removeDups(String givenString) {

        char[] charsOfString = givenString.toCharArray();

        Set<Character> hasset = new HashSet<>();

        int readPointer = 0;
        int writePointer = 0;

        for (Character c : charsOfString) {
            if (!hasset.contains(c)) {
                hasset.add(charsOfString[readPointer]);
                charsOfString[writePointer] = charsOfString[readPointer];
                writePointer++;
            }
            readPointer++;
        }
        String s = String.valueOf(charsOfString);
        System.out.println(s.substring(0, writePointer));

    }


    public static void main(String[] args) {


        removeDups("aaaaaa bb cdd");

    }
}
