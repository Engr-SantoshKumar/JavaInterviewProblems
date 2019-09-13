/**  63 [Left Sum == Right Sum]
 ___________________________________________________________________________________________________________________
Given an array A with n elements, find all indexes i such that
 A[0] + A[1] +..+ A[i-1] = A[i+1] + A[i+2]+…+ A[n-1].


 Input : A[] = {-7, 1, 5, 2, -4, 3, 0}
 Output : 3
 3 is an equilibrium index, because:
 A[0] + A[1] + A[2]  =  A[4] + A[5] + A[6]

*/

 package GooPrep;

public class _Goo_63_Leftsum_Rightsum {
      public static void main(String[] args) {
       int[] ar = new int[]{1, 4, 2 , 5};
       int[] ar1 = new int[]{-7, 1, 5, 2, -4, 3, 0};

      System.out.println("Left sum == Right sum at index :" + leftRightUsingPrefixArray(ar1));
      System.out.println("Left sum == Right sum at index :" + leftRightUsingPrefixArray(ar));

      System.out.println("Left sum == Right sum at index :" + leftSumRightSum(ar1));
      System.out.println("Left sum == Right sum at index :" + leftSumRightSum(ar));

      }

      static int leftRightUsingPrefixArray(int[] ar){

          int[] leftSum = new int[ar.length];
          leftSum[0] = ar[0];

          for(int i =1; i< ar.length; i++ ){
              leftSum[i] = leftSum[i-1]+ar[i];
          }
          //System.out.println(Arrays.toString(leftSum));

          int rightSum = 0;
          for(int i=ar.length-1; i>=0; i--){
              rightSum+=ar[i];
              if(rightSum == leftSum[i]){
                  return i;
              }
          }
          return -1;
      }
    // there could be multiple points where LeftSum = RightSum
    static int leftSumRightSum(int[] ar) {
        if (ar.length == 0) {
            return -1;
        }
        int totalSum = 0;
        for (int i = 0; i < ar.length; i++) {
            totalSum += ar[i];
        }
        int leftSum = 0;
        for (int i = 0; i < ar.length; i++) {
            int rightSum = totalSum - ar[i] - leftSum;
            if (rightSum == leftSum) {
                return i;
            }
            leftSum += ar[i];
        }
        return -1;
    }

}
