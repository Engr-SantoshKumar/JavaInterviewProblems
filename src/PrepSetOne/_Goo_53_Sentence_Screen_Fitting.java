/** [Goo_53] [Screen Fitting Word]
     Given a rows x cols screen and a sentence represented by a list of non-empty words,
     find how many times the given sentence can be fitted on the screen.
      Note:
         -  A word cannot be split into two lines.
         -  The order of words in the sentence must remain unchanged.
         -  Two consecutive words in a line must be separated by a single space.
     e.g:
     Input: rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
     Output:  2
     Explanation:
         a-bcd-
         e-a---
         bcd-e-
     The character '-' signifies an empty space on the screen.
     https://medium.com/@rebeccahezhang/leetcode-418-sentence-screen-fitting-9d6258ce116e
     circular* = to print array in circular order, we can do arr[i/arr.len] -- keep increasing i
     e.g. len 5 :-->  0/5 =0, 1/5 = 1, 2/5=2, 3/5 = 3, 4/5 = 4, 5/5 = 0(here it starts again from 0 index)
 */

package PrepSetOne;

import java.util.Arrays;

public class _Goo_53_Sentence_Screen_Fitting {

    public static void screenFit(String[] sentence, int totalRow, int totalCol){

        int curWordIndex =0;
        int times =0;
        char[][] screen = new char[totalRow][totalCol];

        for(int row =0; row <totalRow; row++ ){
            for(int col =0; col<totalCol; col++){
                //circular* --> 0%4 = 0 ; 1%4 = 1 .. 4%4 =0 ..
                String word = sentence[curWordIndex % sentence.length];

                if(totalCol-(word.length()+col) >= 0){
                    for(char c: word.toCharArray()){
                        screen[row][col] = c;
                        col++; // col will increase ever after last char which will take care of space
                    }

                    // basically we are checking if the current word is the last word of sentence,
                    // if yes we able to fit whole sentence, increase the count
                    if(curWordIndex % sentence.length == sentence.length-1) times ++;
                    curWordIndex++;
                }
            }
        }
        print(totalRow, totalCol, screen);
        System.out.println(" times sentence \"" + Arrays.toString(sentence) + "\" fits in is " + times);
    }


    static void print(int i, int j, char[][] M) {
        for (int x = 0; x < i; x++) {
            for (int y = 0; y < j; y++) {
                System.out.print(" " + M[x][y]);
            }
            System.out.println();
        }
    }


    public static void main(String args[]) {
        String sentence0 = "hello world";
        screenFit(sentence0.split(" "), 2, 8);

        String sentence = "a bcd e";
        String[] ar = sentence.split(" ");
        screenFit(ar, 3, 6);

        String sentence2 = "I had apple pie";
        screenFit(sentence2.split(" "), 4, 5);
    }

}
/*
 h e l l o      
 w o r l d      
 times sentence "[hello, world]" fits in is 1
 a   b c d  
 e   a      
 b c d   e  
 times sentence "[a, bcd, e]" fits in is 2
 I   h a d
 a p p l e
 p i e   I
 h a d    
 times sentence "[I, had, apple, pie]" fits in is 1
 */