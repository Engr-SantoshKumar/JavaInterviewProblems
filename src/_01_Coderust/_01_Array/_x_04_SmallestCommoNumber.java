package _01_Coderust._01_Array;

public class _x_04_SmallestCommoNumber {

    static int find_least_common_number(int[] arrA, int[] arrB, int[] arrC){

        int i =0, j =0, k =0;

        while(i<arrA.length && j< arrB.length && k < arrC.length){

            if(arrA[i] == arrB[j] && arrB[j] == arrC[k]){
                return arrA[i];
            }

            if(arrA[i] <= arrB[j] &&           // incrementing the smallest value
                    arrA[i] <= arrC[k]) {
                i++;
            }
            else if(arrB[j] <= arrA[i] &&
                    arrB[j] <= arrC[k]) {
                j++;
            }
            else if(arrC[k] <= arrA[i] &&
                    arrC[k] <= arrB[j]) {
                k++;
            }

        }

        return -1;
    }

    public static void main(String []args){
        int[] v1 = new int[]{1, 6, 10, 14, 50};
        int[] v2 = new int[]{-1, 6, 7, 8, 50};
        int[] v3 = new int[]{0, 6, 7, 10, 25, 30, 40};
        int result = find_least_common_number(v1, v2, v3);
        System.out.println("Least Common Number: " + result);
    }
}
