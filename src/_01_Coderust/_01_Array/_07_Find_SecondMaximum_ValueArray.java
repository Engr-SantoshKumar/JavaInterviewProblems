package _01_Coderust._01_Array;

public class _07_Find_SecondMaximum_ValueArray {

    public static int secondMax(int[] arr) {

        int secondNum = 0;
        int currentNum = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > currentNum) { // tracking for max no if its grater than current max will replace to current and 2nd max will be previous max
                secondNum = currentNum;
                currentNum = arr[i];
            }
            // case where, the current number is smaller than current max but greater than 2nd max
            else if(arr[i]>secondNum){
                secondNum=arr[i];
            }

        }
        return secondNum;
    }


    public static void main(String[] args) {
        int[] a = {2, 9, 10, 3, 2, 6, 6, 12, 11};

        System.out.println(secondMax(a));

    }
}
