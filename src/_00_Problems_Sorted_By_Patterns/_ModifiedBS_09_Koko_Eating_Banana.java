/* [ _ModifiedBS_09_ ] [ Koko eating banana ]
_______________________________________________________________________________
   Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
    The guards have gone and will come back in h hours.
   Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and
    eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and
    will not eat any more bananas during this hour.

   Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
    Return the minimum integer k such that she can eat all the bananas within h hours.

        Input: piles = [3,6,7,11], h = 8
            Output: 4

        Input: piles = [30,11,23,4,20], h = 5
            Output: 30

        Input: piles = [30,11,23,4,20], h = 6
            Output: 23

*/
package _00_Problems_Sorted_By_Patterns;
/*  GIVEN :  piles = [3,6,7,11]
    With this type of problems: first we need to find on what we do the binary search and whats the range
    Think what if the given hours == length of Array
      -- In this cases koko needs the speed of value of max element in array i.e. 11b/hour ..to finish all piles
      -- what if given hours is  ∞ .. in that case logical she can eat 0 banana/hr
    Use binary search to approach the correct answer.
    We have 0 = min rate and max is 11 .. so the answer is some were between 0-11, and best way to do BS for this range
     
     Time Complexity: O(NlogW), where N is the number of piles, and W is the maximum size of a pile.
     Space Complexity: O(1).
 
 */
public class _ModifiedBS_09_Koko_Eating_Banana {
    public static int minEatingSpeed(int[] pilesArray, int hours) {

        int max = Integer.MIN_VALUE;
        for(int m: pilesArray){
            max = Math.max(m, max);
        }
        //one base cases suppose arraySize == hours, in that cases
        if(pilesArray.length == hours)
            return max;
        
        int speed = Integer.MAX_VALUE;
        int lo = 0;
        int hi = max;
        // we will do BS for range min - max
        while(lo <= hi){
            int curSpeed = lo + (hi-lo)/2; //mid val
            //now we will check if speed of mid can all piles finished in given time
            //update hi as we will try to see if possible with lower than this rate
            if(isPossible(pilesArray, hours, curSpeed)){
                speed = curSpeed;
                hi=curSpeed-1;
            }
            //update lo as with the current speed koko will not able to finish the all piles
            else{
                lo = curSpeed+1;
            }
        }
        return speed;
    }
    
    private static boolean isPossible(int[] pilesArray, int hours, int curSpeed) {
        int curTime = 0;
        for(int pile: pilesArray){
            curTime += pile/curSpeed;
            if(pile%curSpeed != 0)        // if its 2.1 hrs converting to 3 full hrs
                curTime ++;
        }
        return curTime <= hours;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{30,11,23,4,20};
        int givenTime = 6;
        System.out.println(minEatingSpeed(arr, givenTime));
    }
}
    
