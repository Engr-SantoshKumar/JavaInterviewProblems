/**
 * [76] [ Even Number at Even Index ]
 * --------------------------------------------------------------------------------------------------------------
 Given a list of N numbers, use a single list comprehension to produce a new list that only contains those values that are:
 (a) even numbers, and
 (b) from elements in the original list that had even indices

 For example, given the following list:
 #        0   1   2   3    4    5    6    7    8
 nums = [ 1 , 3 , 5 , 8 , 10 , 13 , 18 , 36 , 78 ]

 Desired output = [10, 18, 78]"
 */
package PrepSetOne;

public class _Goo_76_Even_Number_At_Even_Index {

    public static void findEvenNumsAtEvenIndex(int[] arr){
        for(int i=0; i<arr.length; i++){

            int curDigt = arr[i];

            if(curDigt%2 ==0){
                System.out.print(arr[i] + ", ");
            }
            i++;
        }


    }

    public static void main(String[] args) {
        int[] nums = {1 , 3 , 5 , 8 , 10 , 13 , 18 , 36 , 78};
        findEvenNumsAtEvenIndex(nums);
    }


}
