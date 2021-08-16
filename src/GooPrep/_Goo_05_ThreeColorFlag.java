/** 05 [Three Color Flag]
-------------------------------------------------------------------------------------------------------
 Three color flag question: given an unsorted array with repeated 0,1,2,
 or example {1,2,0,2,2,1,0,1,0,0,1}, sort it to {0,0,0,0,1,1,1,1,2,2,2}
 */

package GooPrep;
import java.util.Arrays;
public class _Goo_05_ThreeColorFlag {

    public static void sortFlag(int[] arr){

        int start = 0;
        int end = arr.length-1;
        for(int i = 0; i<=end; i++){
            //swap 2 to the end, and then end --
            if(arr[i] == 2){
                while(arr[i] == 2 && i < end){
                    int temp = arr[end];
                    arr[end] = arr[i];
                    arr[i] = temp;
                    end --;
                }
            }
            /*while moving 2 to the end, current position might become 0.. now swap 0 with int at start.
            That's why we trying to move 2 and then 0
            */
            if(arr[i] == 0){
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
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
