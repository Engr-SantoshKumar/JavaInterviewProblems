/**
 * [ Apple_07 ] [ Last Stone Weight ]
 * ____________________________________________________________________________________________________________________
 */
package Apple_FB_Prep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class _Apple_07_LastStoneWeight {
    static int LastStoneWeight(int[] arr){
        if(arr.length ==0) return 0;
        if(arr.length ==1) return arr[0];

        Queue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int i =0; i<arr.length; i++){
            pq.offer(arr[i]);
        }

        while(pq.size()>1){
            int firstE = pq.poll();
            int sndE = pq.poll();
            if((firstE-sndE) > 0) {
                pq.offer(firstE - sndE);
            }
        }
        int ans = pq.poll();
        return ans;
    }

    public static void main(String[] args) {
        int arr1[]={2,7,4,1,8,1};

        System.out.println(LastStoneWeight(arr1));

    }


}
