/**
 * [DP_04_Target Sum  ] [ Given an array of integers, nums, and a target value, T, find the number of ways ]
 _____________________________________________________________________________________________________________
 Given an array of integers, nums, and a target value, T, find the number of ways
 that you can add and subtract the values in arr to sum to T.
 Arr = {1, 2, 3, 4}
 T = 0
 1st way = 1 - 2 - 3 + 4
 2nd way = -1 + 2 + 3 - 4

 ● Time complexity is O(2^n)
 ● Space complexity is O(n)
 */
package DynamicProgramming;
public class _04_01_ByteBy_Target_Sum_Regression {
    static int targetSum(int[] arr, int K){
        return targetSum(arr, K, 0, 0);
    }

    static int targetSum(int[] arr, int K, int i, int runningSum){
        //base cases
        if(i==arr.length){
            return runningSum == K ? 1:0;
        }
        //call recursively one time - currentNum one time + currentNum
        return targetSum(arr, K, i+1, runningSum + arr[i]) +
                targetSum(arr, K, i+1, runningSum - arr[i]);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4};
        System.out.println(targetSum(arr, 0));
    }
}
