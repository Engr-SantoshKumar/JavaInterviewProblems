/* [  ] [ Maximum Points You Can Obtain from Cards ]
_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
← ↑ → ↓ ↖ ↘ ↗ ↙   ●  ○ ∞
There are several cards arranged in a row, and each card has an associated number of points.
The points are given in the integer array cardPoints.
In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
Your score is the sum of the points of the cards you have taken.
Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1.
However, choosing the rightmost card first will maximize your total score.
The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.

Input: cardPoints = [2,2,2], k = 2
Output: 4
Explanation: Regardless of which two cards you take, your score will always be 4.

*/

package _00_Problems_Sorted_By_Patterns;
public class _SlidingWindow_06_Maximum_Points_You_Can_Obtain_from_Cards {
    public static int maxScore(int[] arr, int k) {
        int startingIndex = 0;
        int curSubArrScore = 0;
        int n = arr.length;
        int reqSubArrLen = n - k;
        int minScore;
        int totalScore = 0;
        
        // Total score obtained on selecting all the cards.
        for (int i : arr) {
            totalScore += i;
        }
        
        minScore = totalScore;
        
        if (k == n) {
            return totalScore;
        }
        
        for (int i = 0; i < n; i++) {
            curSubArrScore += arr[i];
            int curLen = i - startingIndex + 1;
            // If a valid subArray (having size cardsPoints.length - k) is possible.
            if (curLen == reqSubArrLen) {
                minScore = Math.min(minScore, curSubArrScore);
                curSubArrScore -= arr[startingIndex++];
            }
        }
        return totalScore - minScore;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 1, 7, 0};
        System.out.println(maxScore(arr, 3));
    }
}

