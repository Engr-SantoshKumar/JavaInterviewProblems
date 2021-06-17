/** 11 [Missing Ranges]
-----------------------------------------------------------------------------------------------------
 * "You are given a sorted list of distinct integers from 0 to 99, for instance [0, 1, 2, 50, 52, 75].
 * Produce a string that describes numbers missing from the list; in this case "3-49,51,53-74,76-99.
 * The items should be sorted in ascending order and separated by commas. When a gap spans only one
 * number, the item is the number itself; when a gap is longer,
 * the item comprises the start and the end of gap, joined with a minus sign."
 */

package GooPrep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class _Goo_11_MissingRanges {
    public static List<String> missingRanges(int[] arr, int lower, int upper){

        List<String> result = new ArrayList<>();

        if(arr[arr.length-1] < lower || arr[0] > upper){
            result.add(String.format("%s-%s", lower, upper));
            return result;
        }

        for(int i =0; i< arr.length; i++)
        {
            /* finding the first number in arr which is in range */
            if(arr[i] < lower){
                continue;
            }
            if (arr[i] == Integer.MIN_VALUE) {
                lower = arr[i] + 1;
                continue;
            }
            //Cases 1: keep moving lower until there is missing number e.g 1,2,3,4
            if(lower == arr[i]){
                lower = arr[i] +1;
            }

            // Cases 2: this to check if only one number is missing e.g 4,5,_,7,8
            else if(lower == arr[i] - 1){
                result.add(String.valueOf(lower));
                lower = arr[i] +1;
            }

            // Cases 3: if bunch of numbers missing
            else
                {
                if(arr[i] >= upper){// current number arr[i] is out of range
                    result.add(String.format("%s-%s", lower, upper-1));
                    break; //--> no need to scan more as current element is > upper
                }
                else if(arr[i] == Integer.MAX_VALUE) {
                        return result;
                }
                else{
                    result.add(String.format("%s-%s", lower, arr[i]-1));
                    lower = arr[i]+ 1;
                }
            }
        }

        // Case: if the last element is less than upper
        if(arr[arr.length-1] < upper)
        {
            result.add(String.format("%s-%s", lower, upper));
        }
        return result;
    }
   public static void main(String[] args) {
        int[] nums = {-3,4, 12, 14, 16, 30, 32};

        List<String> list = missingRanges(nums, 10, 30);
        System.out.println(Arrays.toString(list.toArray())); //--> [2, 4-49, 51-74, 76-99]

       int[] nums1 = {-10,0, 1, 3, 50, 75, 99};
        List<String> list1 = missingRanges(nums1, 0, 99);
        System.out.println(Arrays.toString(list1.toArray())); // --> [2, 4-49, 51-74, 76->98]

       int[] nums2 = {50, 75};
        List<String> list2 = missingRanges(nums2, 0, 99);
        System.out.println(Arrays.toString(list2.toArray())); //--> [0-49, 51-74, 76->99]

       int[] nums3 = {-10,-5, -1, 0};
       List<String> list3 = missingRanges(nums3, 1, 99);
       System.out.println(Arrays.toString(list3.toArray())); //[1-99]
    }
}

/*
o/p
[2, 4-49, 51-74, 76-99]
[2, 4-49, 51-74, 76-98]
[0-49, 51-74, 76-99]
[1-99]
 */
