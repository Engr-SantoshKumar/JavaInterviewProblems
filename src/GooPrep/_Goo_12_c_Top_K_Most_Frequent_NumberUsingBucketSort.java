/**
 * [ Goo 12_C ] [ Find top k most frequent Number in Array ]
 * ____________________________________________________________________________________________________________________
 arr :  1, 5, 2, 1, 3, 2, 1 , 1, 5, 5,5, 5,5, 5,5
 o/p: [5, 1, 2]

 Solved using: Bucket Sort technique

 */

package GooPrep;

import java.util.*;

public class _Goo_12_c_Top_K_Most_Frequent_NumberUsingBucketSort {

    public static int[] mostPopularNumberUsingBucketSort(int [] nums, int k){

        List<Integer>[] bucketList = new ArrayList[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int value = frequencyMap.get(key);
            if (bucketList[value] == null) {
                bucketList[value] = new ArrayList<>();
            }
            bucketList[value].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucketList.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucketList[pos] != null) {
                res.addAll(bucketList[pos]);
            }
        }
        int[] toArray = res.stream().mapToInt(Integer::intValue).toArray();
        return toArray;
    }

    public static void main (String[] args) {
        int arr[] = {1, 5, 2, 1, 3, 2, 1 , 1, 5, 5,5, 5,4, 5,4, 2, 2};
        int topK = 3;
        System.out.println(Arrays.toString(mostPopularNumberUsingBucketSort(arr, topK)));
    }
}
