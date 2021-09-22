/** 35  [Frequency Of Number]
 ---------------------------------------------------------------------------------------------------------
 "Count number of occurrences (or frequency) in an array
 Array = [1,0,1,5,1,7,9,0]
 Input = 1
 Frequency = 3"

*/
 package PrepSetOne;

import java.util.HashMap;
import java.util.Map;

public class _Goo_35_Frequency_Of_Number {

    public static void main(String args[]){
        int[] arr = new int[] {1,0,1,5,1,7,9,0, 0,1,2,3,4,5,6};

        System.out.println(" Frequency of "+ 1 + " is " + findFrequency(arr, 1));
        System.out.println(" Frequency of "+ 0 + " is " + findFrequency(arr, 0));
        System.out.println(" Frequency of "+ 8 + " is " + findFrequency(arr, 8));
    }

    static int findFrequency(int[] arr, int k){

        Map<Integer, Integer> hMap = new HashMap<>();

        for(int i: arr){
                hMap.put(i, hMap.getOrDefault(i, 0)+1);
        }

        if(!hMap.containsKey(k)){
            return 0;
        }else{
            return hMap.get(k);
        }

   }
}
