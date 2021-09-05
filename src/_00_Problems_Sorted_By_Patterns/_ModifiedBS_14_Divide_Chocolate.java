/* [ _ModifiedBS_14_ ] [ Divide Chocolate ]
_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
← ↑ → ↓ ↖ ↘ ↗ ↙   ●  ○ ∞
You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.
You want to share the chocolate with your k friends so you start cutting the chocolate bar into k + 1 pieces
using k cuts, each piece consists of some consecutive chunks.

Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.
Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
    Input: sweetness = [1,2,3,4,5,6,7,8,9], noOfFriends = 5
    Output: 6, Divisions --> [1,2,3], [4,5], [6], [7], [8], [9]

    Input: sweetness = [5,6,7,8,9,1,2,3,4], k = 8
    Output: 1
    Explanation: There is only one way to cut the bar into 9 pieces.
*/
package _00_Problems_Sorted_By_Patterns;
public class _ModifiedBS_14_Divide_Chocolate {
    /*
    This question is very similar to _ModifiedBS_11_Split_Array_Largest_Sum and
                                     _ModifiedBS_10_Allocate_Minimum_Number_Of_Pages
                                     
    In "Split Array Largest sum" we want to find: Minimum of maximum largest sum
    In this problem we want to find: Maximum of minimum total sweetness
    
    In both places we do binary search on target answer, the difference is subtle but the key:
        In "Split Array Largest sum" when we overshoot the target, we will include the number in the next sum,
        so we can ensure all numbers are less than target - binary search does the rest of the magic
     
        In this when we overshoot the target, we will include that number in previous sum, as that is
        how we will maintain the target as the minimum number and binary search will find this optimal minimum
    */
    /*
              ● Time complexity: O(n * log(sum of array))
                The binary search costs O(log(sum of array)) *
                the time complexity is O(n) since we only need to go through the whole array.
     */
    public static int maximizeSweetness(int[] sweetness, int noOfFriends) {
        //sweetness will range from a minimum individual chunk sweetness to sumOfAllChunk
        int minSweetness = Integer.MAX_VALUE;
        int maxTotalSweetness = 0;
        
        for(int chunk: sweetness){
            minSweetness = Math.min(minSweetness, chunk);
            maxTotalSweetness += chunk;
        }
        // lo (if no of friends = 5, we need to divide it into 6 parts ..one for self)
        if(noOfFriends+1==sweetness.length) return minSweetness;
        
        //hi
        if(noOfFriends ==0 ) return maxTotalSweetness;
        
        //inBetween : lets Do binary search, boundary starting from min to the totalSumSweetness.
        int lo = minSweetness;
        int hi = maxTotalSweetness;
        int result =0;
        
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(isPossible(sweetness, noOfFriends, mid)){
                result = mid;
                hi = mid -1; //--> lower mid (decreasing sweetness)
            }else{
                lo = mid +1; //--> increasing sweetness
            }
        }
        return result;
    }
    
    // This method is to find, with the give target is it possible to divide the chocolate among friends
    private static boolean isPossible(int[] sweetness, int noOfFriends, int targetSweetness) {
        int curSweetness =0;
        int curNoOfChunks =0;
        
        for(int chunk: sweetness){
            curSweetness +=chunk;
            if(curSweetness > targetSweetness){
                curNoOfChunks++;
                curSweetness =0;
            }
        }
        return curNoOfChunks <= noOfFriends; // if friends =5 and we got chunks = >5 we need to increase targetSweetness
    }
    
    public static void main(String[] args) {
        int[] sweetness = new int[]{1,2,3,4,5,6,7,8,9};
        int noOfFriends = 5;
        System.out.println(maximizeSweetness(sweetness, noOfFriends));
    }
  
}
