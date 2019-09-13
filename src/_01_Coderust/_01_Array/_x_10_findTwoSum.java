package _01_Coderust._01_Array;

import java.util.HashMap;
import java.util.Map;

public class _x_10_findTwoSum {

    static void twoSum(int[] arr, int x){
        if(arr.length < 2){
            System.out.println("No pair found");
        }

        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for(int i : arr){
            if(hashMap.containsKey(i)){
                System.out.println("Pair --> " + hashMap.get(i) + " : " + i);
            }else{
                hashMap.put(x-i, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] v = new int[]{2, 1, 8, 4, 7, 3, 0};
        twoSum(v, 8);

    }
}
