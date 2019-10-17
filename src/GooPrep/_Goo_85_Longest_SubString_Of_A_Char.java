/**
[ Goo 85 ] [ Uni Char longest sub String  ]
________________________________________________________________________________________________________________
 Given an input string representing one word, find the start and end indices of all
 extensions in the word. ex:"heeeello" should return 1, 4
 package GooPrep;
 */
package GooPrep;
import java.util.Arrays;
public class _Goo_85_Longest_SubString_Of_A_Char {

    public static int[] longestSubstring(String str, char ch){

        int[] startEndIndex = new int[2];
        int i =0;
        int j = 0;

        startEndIndex[0] = i;
        startEndIndex[1] = j;
        int globalMax = 0;

        while(i < str.length()){
            if(str.charAt(i) == ch){
                j =i;
                while(i < str.length() && str.charAt(i) == ch ){
                    i++;
                }
                int curMax = i-j;
                if(curMax > globalMax){
                    startEndIndex[0] = j;
                    startEndIndex[1] = i-1;
                    globalMax = curMax;
                }
            }
            i++;
        }
        return startEndIndex;
    }


    public static void main(String[] args) {
        String str = "heeeello";
        char ch = 'e';
        System.out.println(Arrays.toString(longestSubstring(str,ch)));
    }
}
