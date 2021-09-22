/**  46 [Find Pair whose sum is less than K]
 --------------------------------------------------------------------------------------------------------
 Sol[A] : A simple solution of this problem run two loops to generate all pairs and one by one and
          check if current pair’s sum is less than x or not.

 Sol[B] : Take left[0] and Right[len -1] index, if their sum is smaller than K, then
          the all elements from left+1 to right will have their sum less than K.

 for example:
 Arr: [1, 2, 3, 4, 5, 6, 7, 8]  K = 8
 left = 1 right = 7  --> 1+7 <= 8
 Now: [1 + 2], [1 + 3], [1 + 4], . . . [1 + 6]  these all pairs sum is less than K
 once this is done move the [leftPointer] ++
 left = 2 right = 7  --> if the sum is grater than K, keep moving the [rightPointer] --
 */
package PrepSetOne;

import java.util.ArrayList;
import java.util.List;

public class _Goo_46_Two_Sum_Less_Equal_K {

    public static void findPairLessThanK(int[] arr, int K){
        int left = 0;
        int right = arr.length - 1;
        List<SumPair> list = new ArrayList<>();

        while(left < right)
        {
            if(arr[left] + arr[right] <= K){
                computePairs(arr, left, right, list, K);
                left ++;
            }
            else{
                right --;
            }
        }
    }

    static void computePairs(int[] ar, int left, int right, List<SumPair> list, int K) {

        for (int i = left + 1; i <= right; i++) {
            list.add(new SumPair(ar[left], ar[i]));
            System.out.println(ar[left] +" : "+ ar[i]);
        }
    }

    public static void main(String args[]) {
        int[] ar = {1, 4, 6, 8, 8, 10, 12, 15, 24, 45};
        //testFor(b, 5);
        findPairLessThanK(ar, 16);
    }
    static class SumPair{
        int s;
        int e;
        public SumPair(int str, int end){
            this.s = str;
            this.e = end;
        }
        public String covtToStr(){
            return "\n{" + s + ", " + e + "}";
        }
    }
}
