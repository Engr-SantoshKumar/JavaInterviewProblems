
/*
 * [ oA_04 ] [ Counting Elements ]
_____________________________________________________________________________________________________________
 Given an integer array arr, count element x such that x + 1 is also in arr.
 If there's duplicates in arr, count them separately.
 Example 1:
 Input: arr = [1,3,2,3,5,0]
 Output: 3
 Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.

 Example 2:
 Input: arr = [1,1,2,2]
 Output: 2
 Explanation: Two 1s are counted cause 2 is in arr.
 */
package Code_Run_Build_LC350;

import java.util.HashMap;
import java.util.Map;

public class _oA_04_Counting_Elements {

    static int countElements(int[] arr){
        int result = 0;
        if(arr.length<2) return result;
        Map<Integer,Integer> hMap = new HashMap<>();
        for(int i:arr){
            hMap.put(i, hMap.getOrDefault(i,0)+1);
        }

        for(int i: arr){
            if(hMap.containsKey(i+1)){
                result++;
                int count = hMap.get(i);
                if(count==1){
                    hMap.remove(i);
                }
                hMap.put(i,count-1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1= {1,3,2,3,5,0};
        int[] arr2= {1,1,2,2};
        int[] arr3= {1,1,3,3,5,5,7,7};
        System.out.println(countElements(arr1));
        System.out.println(countElements(arr2));
        System.out.println(countElements(arr3));

    }
}
