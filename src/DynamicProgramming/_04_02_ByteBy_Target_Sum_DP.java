/**
 * [DP_04_Target Sum  ] [ Given an array of integers, nums, and a target value, T, find the number of ways ]
_____________________________________________________________________________________________________________
Given an array of integers, nums, and a target value, T, find the number of ways
that you can add and subtract the values in arr to sum to T.
 Arr = {1, 2, 3, 4}
T = 0
 1st way = 1 - 2 - 3 + 4
2nd way = -1 + 2 + 3 - 4
 */
package DynamicProgramming;
public class _04_02_ByteBy_Target_Sum_DP {
        static int target_Sum_DP(int[] arr, int target){
            // we need a matrix to hole all possible combination, all possible combination will be in
            // range from -10 to +10  +/- (1+2+3+4)=10*2=20
            int totalSum =0;
            for(int i :arr) totalSum+=i;
            //total rows = arr.length +1 (1 for 0 extra zero values)
            //total cols = (totalSum*2) +1
            int[][] dp = new int[arr.length+1][totalSum*2 + 1];

            //default value at middle (0th position in number scale -/+)
            dp[0][totalSum]=1;

            // lets fill the dp
            for(int i =1; i < dp.length; i++){
                for(int col=0; col<dp[0].length; col++){
                    //if inside the boundary (-ve side )
                    if(col-arr[i-1] >= 0){
                        dp[i][col] += dp[i-1][col - arr[i-1]];
                    }
                    //if inside the boundary (+ve side)
                    if(col+arr[i-1] < dp[0].length){
                        dp[i][col] += dp[i-1][col + arr[i-1]];
                    }
                }
            }
            return dp[arr.length][totalSum];
        }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(target_Sum_DP(arr, 0));
    }
}
