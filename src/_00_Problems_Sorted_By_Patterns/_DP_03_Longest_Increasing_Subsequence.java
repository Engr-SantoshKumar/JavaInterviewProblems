/* [ _DP_03_  ] [ Longest Increasing Subsequence ]
_______________________________________________________________________________
Given an integer array nums, return the number of longest increasing subsequences.

Input: nums = [1,3,5,4,7]
The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Logic:  Element at i will be part of subsequence only if
       1. arr[i] is grater than previous(last) element of subsequence
       2. length of subsequence w/o arr[i] + 1 is grater than length at i
           --> Length[j] +1 > length[i] ..because then only it will increase the size of subsequence

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.Arrays;

public class _DP_03_Longest_Increasing_Subsequence {
    public static int longestIncreasingSubsequence(int[] arr){
        int longestSubstring=1;
        int[] lenSubStr = new int[arr.length];
        lenSubStr[0] =1;
        for(int i =1; i<arr.length; i++){
            lenSubStr[i] =1;

            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] ){// cond 1: IF current is bigger than previous(last one) element of subsequence
                    if(lenSubStr[j]+1 > lenSubStr[i]){//cond 2: will adding current to existing increase
                                                            // the size or current is already part of bigger subsequence
                        lenSubStr[i] = lenSubStr[j]+1;
                    }

                }
            }
            longestSubstring = Math.max(longestSubstring, lenSubStr[i]);
        }
        System.out.println(Arrays.toString(lenSubStr));
        //printing the longest subsequence
        int i = lenSubStr.length-1;
        while(i>=0){
                if(lenSubStr[i]== longestSubstring){
                    System.out.print(arr[i] + " <-- ");
                    longestSubstring--;
                }
                i--;
        }
        return longestSubstring;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,7,8,9,2,3,4,9,10};
        System.out.println(longestIncreasingSubsequence(arr));
    }

}
