package _01_Coderust._03_Math_And_Stats;

public class _x_02_Find_the_Missing_Number {

    public static int missingNumber(int [] arr, int lenght){
        int givenNo = arr[0];
        int resultTemp = 1;

         /* For xor of all the elements in array */
        for(int i =1; i<lenght; i++){
            givenNo = givenNo ^ arr[i];
        }

         /* For xor of all the elements from 1 to n+1 */
        for(int i =2; i <= lenght+1; i++)
            resultTemp = resultTemp ^ i;

        return (givenNo ^ resultTemp);
    }

    public static int missingNumberUseingSum(int[] arr){
        // calculate sum of all elements in input list
        int sum_of_elements = 0;
        for (int x : arr) {
            sum_of_elements += x;
        }

        // There is exactly 1 number missing
        int n = arr.length + 1;
        int actual_sum = (n * ( n + 1 ) ) / 2;
        return actual_sum - sum_of_elements;

    }


    public static void main(String args[])
    {
        int a[] = {1,2,4,5,6};
        int miss = missingNumber(a,5);
        System.out.println(miss);
    }
}
