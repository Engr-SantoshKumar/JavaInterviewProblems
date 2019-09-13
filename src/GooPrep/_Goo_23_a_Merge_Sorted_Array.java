/**  23 [Merge Sorted Array]
 ---------------------------------------------------------------------------------------------------------
 Given two sorted integer arrays X and Y , merge Y into X as one sorted array.
 X = { 1, 3, 5, 9, 11,_,_,_,_,_}
 Y = { 2, 6, 7, 10, 13}
 */
package GooPrep;
import java.util.Arrays;

public class _Goo_23_a_Merge_Sorted_Array {

    static int[] mergeArray(int[] a, int[] b, int lastA, int lastB)  {
        int indexMerged = lastB + lastA - 1; /* Index of last location of merged array */
        int indexA = lastA - 1; /* Index of last element in array b */
        int indexB = lastB - 1; /* Index of last element in array a */

        /* Merge a and b, starting from the last element in each */
        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) { /* end of a is bigger than end of b */
                a[indexMerged] = a[indexA]; // copy element
                indexA--;
            } else {
                a[indexMerged] = b[indexB]; // copy element
                indexB--;
            }
            indexMerged--; // move indices
        }
        return a;
    }

    static int[] merge(int[] ar1, int[] ar2) {
        int k = ar1.length-1;
        int i = ar1.length-1;
        int j = ar2.length-1;

        while(ar1[i] == 0){
            i--;
        }
        while(i>=0 && j>=0){
            if(ar1[i]>= ar2[j]){
                ar1[k--] = ar1[i--];
            }else{
                ar1[k--] = ar2[j--];
            }
        }
        while (i>=0){
            ar1[k--] = ar1[i--];
        }
        while ( j>=0){
            ar1[k--] = ar2[j--];
        }
        return ar1;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 4, 6, 7, 7};
        int NoOfRealEleamentsInA = 8;
        int NoOfRealEleamentsInB = 6;
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
//        System.out.println(Arrays.toString(mergeArray(a, b, NoOfRealEleamentsInA, NoOfRealEleamentsInB)));
        int[] a1 = {2, 3, 0, 0};
        int[] b1 = {1, 4};
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(b1));
        System.out.println(Arrays.toString(merge(a1, b1)));
    }
}
