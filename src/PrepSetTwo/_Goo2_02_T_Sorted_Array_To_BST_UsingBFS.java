package PrepSetTwo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class _Goo2_02_T_Sorted_Array_To_BST_UsingBFS {

    static Node root;

    public static int[] sortedArrayToBSTUsingBFS(int arr[]) {

        int[] arrForBST = new int[arr.length];
        int mid = (0 + arr.length) / 2;
        Queue<midLR> queue = new ArrayDeque<>();
        queue.add(new midLR(arr[mid], 0, mid-1, mid+1, arr.length-1 ));
        int i =0;
        while(!queue.isEmpty()){

            midLR current = queue.poll();
            arrForBST[i++] = current.curDigt;

            if(current.lS <= current.lE){
                mid = current.lS + (current.lE - current.lS)/2;
                queue.add(new midLR(arr[mid], current.lS, mid-1, mid+1, current.lE ));
            }
            if(current.rS <= current.rE){
                mid = current.rS + (current.rE - current.rS)/2;
                queue.add(new midLR(arr[mid], current.rS, mid-1, mid+1, current.rE ));
            }
        }
        System.out.println(Arrays.toString(arrForBST));
        return arrForBST;
    }


    public static void main(String[] args) {
        _Goo2_02_T_Sorted_Array_To_BST_UsingBFS tree = new _Goo2_02_T_Sorted_Array_To_BST_UsingBFS();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] arrForBST = tree.sortedArrayToBSTUsingBFS(arr);
        //display tree
        TreeHelper.print(arrForBST);

    }
}
class midLR{
    int curDigt;
    int rS, rE, lS, lE;
    public midLR(int curDigt, int lS, int lE , int rS, int rE){
        this.curDigt = curDigt;
        this.lS = lS;
        this.lE = lE;
        this.rS = rS;
        this.rE = rE;

    }
}