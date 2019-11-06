/**
 * [ Goo2_S 20 ] [ Given a list of non negative integers, arrange them such that they form the largest number ]
 * __________________________________________________________________________________________________________

Input: [10,2]
Output: "210"

 Input: [3,30,34,5,9]
 Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
 */
package GooPrep02;
import java.util.Arrays;
import java.util.Comparator;


public class _Goo2_20_S_CreateMaxNumberFromArray {

    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        System.out.println(Arrays.toString(arr));


        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        while (sb.charAt(0) == '0' && sb.length() > 1) sb.deleteCharAt(0); // removing zeros from front
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] num = {3, 30, 34, 5, 3, 9 };
        System.out.println(largestNumber(num));
    }


}



