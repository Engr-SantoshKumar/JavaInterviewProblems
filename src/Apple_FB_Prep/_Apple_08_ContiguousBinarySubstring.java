/**
[ _Apple_08 ] [ Contiguous Binary subArray with 0's==1's ]
_______________________________________________________________________________________________________________
 Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

 Input: [0,1,0,0,1,1,1]
 Output: 6
 Explanation: [0,1,0,0,1,1] is a longest contiguous subArray with equal number of 0 and 1.
 */
package Apple_FB_Prep;

import java.util.HashMap;
import java.util.Map;

public class _Apple_08_ContiguousBinarySubstring {
    static int findBinaryStringBrutForce(int[] arr){
        int numOfZeros;
        int numOfOnes;
        int maxLength = 0;
        for(int i=0; i<arr.length; i++) {
            numOfZeros=0;
            numOfOnes=0;
            for(int j=i; j<arr.length; j++) {
                if(arr[j] == 0)
                    numOfZeros++;
                else
                    numOfOnes++;
                if( numOfZeros == numOfOnes )
                    maxLength = Math.max(maxLength, numOfZeros*2 );
            }
        }
        return maxLength;
    }

    /*logic: increment the counter +1 for 1 and -1 for 0
             if the counter encounter any previous value that means between those two points of encounter
             count of 0 and 1 is same
             using map < count, index> whats the counter value at each index .. if we encounter the same counter
             value we get the index
    */
    static int findBinaryStringUsingHMap(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        int count =0, maxLength =0;
        //need a default value in map (0,-1) i.e count is zero at index -1 because when we start travelling
        // (after +- counter and encounter zero at very first time (means 0==1) means from index 0 --> current 0=1
        // to calculate the length we need 0,-1
        //e.g   0 1   --> count will be like -1 --> 0  at 1 = 1 ( how to calculate i-(-1) => 2
        map.put(0, -1);
        for(int i=0; i<arr.length; i++){
            count = count + (arr[i]==1 ? 1 : -1);
            if(map.containsKey(count)){
                maxLength = Math.max(maxLength, i - map.get(count));
            }else{
                map.put(count, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 1, 1, 1, 1, 0};
        System.out.println(findBinaryStringBrutForce(arr));
        System.out.println(findBinaryStringUsingHMap(arr));
    }


}
