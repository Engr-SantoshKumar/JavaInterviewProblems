/** 05 [Three Color Flag]
-------------------------------------------------------------------------------------------------------
 Three color flag question: given an unsorted array with repeated 0,1,2,
 or example {1,2,0,2,2,1,0,1,0,0,1}, sort it to {0,0,0,0,1,1,1,1,2,2,2}
 */

package GooPrep;
import java.util.Arrays;
public class _Goo_05_ThreeColorFlag {

    public static void sortFlag(int[] nums){

        int start = 0;
        int end = nums.length-1;

        for(int i = 0; i<=end; i++){

            //swap 2 to the end, and then end --
            if(nums[i] == 2){
                while(nums[i] == 2 && i < end){

                    int temp = nums[end];
                    nums[end] = nums[i];
                    nums[i] = temp;
                    end --;
                    }
            }
            /*0 from the end may swap to nums[i], therefore we should check 2 first then 0
            swap 0 to the head, and then start ++
            */
            if(nums[i] == 0){
                int temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
                start ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 0, 2, 1, 1, 0, 2};
        sortFlag(a);
        System.out.println(Arrays.toString(a));
    }

}
