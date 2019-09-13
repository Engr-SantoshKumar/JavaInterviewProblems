/** 53 [Screen Fitting Word]
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
 circular* = to print array in circular order, we can you arr[i/arr.len] -- keep increasing i
 e.g. len 5 :-->  0/5 =0, 1/5 = 1, 2/5=2, 3/5 = 3, 4/5 = 4, 5/5 = 0(here it starts again from 0 index)
 */

package GooPrep;

import java.util.Arrays;

public class _Goo_53_Sentence_Screen_Fitting {
    public static void main(String args[]) {
        String sentence0 = "hello world";
        screenFit(sentence0.split(" "), 2, 8);

        String sentence = "a bcd e";
        String[] ar = sentence.split(" ");
        screenFit(ar, 3, 6);

        String sentence2 = "I had apple pie";
        screenFit(sentence2.split(" "), 4, 5);
    }

    public static void screenFit(String[] sentence, int R, int C){

        int index =0;
        int times =0;
        char[][] screen = new char[R][C];

        for(int row =0; row <R; row++ ){
            for(int col =0; col<C; col++){
                String word = sentence[index % sentence.length];//circular* --> 0/4 = 0 ; 1/4 = 1 .. 4/4 =0 ..
                if(C-(word.length()+col) >= 0){
                    for(char c: word.toCharArray()){
                        screen[row][col] = c;
                        col++;
                    }
                    times = times + times(index, sentence);
                    index++;
                }
            }
        }
        print(R, C, screen);
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

    static int times(int k, String[] ar) {
        int times = 0;
        if ((k % ar.length) == ar.length - 1) { // imp k% ar.len because k becomes 3,4,5
            times++;  // etc which is never going to meet condition after k >=3
        }
        return times;
    }

}