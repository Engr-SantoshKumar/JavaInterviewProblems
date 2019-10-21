/** 12-a [Most Frequent Number ]
------------------------------------------------------------------------------------------------------
 * Give the count of a most popular element in an integer array.
 * int arr[] = {1, 5, 2, 1, 3, 2, 1 , 1, 5, 5, 5, 5, 5, 5, 5};
 * Number : 5 Count: 8
 */
package GooPrep;
import java.util.*;

public class _Goo_12_a_MostFrequentNumber {


    public static void mostPopularNumber(int [] arr){
        //sort the array
        Arrays.sort(arr);

        int result =arr[0];
        int currentCount = 1;
        int maxCount = 1;

        for(int i =1; i<arr.length; i++){
            if(arr[i] == arr[i-1]){
                currentCount ++;
            }else{
                if(currentCount > maxCount){
                    maxCount = currentCount;
                    result = arr[i-1];
                }
                currentCount = 1;
            }
        }
        //if the last element has max count
        if(currentCount > maxCount){
            maxCount = currentCount;
            result = arr[arr.length-1];
        }
        System.out.println("Number : " + result + " Count: " +  maxCount);
    }




    public static void main (String[] args) {

        int arr[] = {1, 5, 2, 1, 3, 2, 1 , 1, 5, 5,5, 5,5, 5,5};
        mostPopularNumber(arr);

    }
}
