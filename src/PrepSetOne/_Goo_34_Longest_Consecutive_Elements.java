/** 34  [Longest Consecutive Elements]
 ---------------------------------------------------------------------------------------------------------
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence should be [1, 2, 3, 4].
 Its length is 4.
 Your algorithm should run in O(n) complexity.
 */
package PrepSetOne;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _Goo_34_Longest_Consecutive_Elements {
/*
    HashSet
    - To see consecutive elements, you must have num ++ , num -- search
    -  1. Need O( 1 ) to find the element
    -  2. Need to quickly and easily find num -  1 , num +  1.
    - If you use min, max to open array, it takes space
    - Use HashSet to save, use set . contains() to find (num - 1) ,(num + 1) exists or not
    - for loop. O(n)
    - Inside the while Loop generally do not have O (n); Once the O (n), also means that the set is cleared,
        for Loop there will not be more Inner the while derived .
    - overall O(n) time complexity
*/
    public static int longestConsecutive(int[] num) {
        // if array is empty, return 0
        if (num.length == 0) {
            return 0;
        }
        Set<Integer> hSet = new HashSet<>();

        for(int i: num){
            hSet.add(i);
        }
        int globalMax = 1;
        for(int curNum: num)
        {
            int count = 1;
            int nextNo = curNum+1;
            int prevNo = count-1;

            while(hSet.contains(nextNo)){
                count++;
                hSet.remove(nextNo);
                nextNo++;
            }
            while(hSet.contains(prevNo)){
                count++;
                hSet.remove(prevNo);
                prevNo --;
            }
            globalMax = Math.max(count, globalMax);
        }
        return globalMax;
    }
/* LOGIC :
    1. sort
    2. use a 'count' and 'max' to keep track of consecutive elements
    3. one-pass
    Note: Take care of equal numbers: skip/continue those
*/
        public static int longestConsecutiveUsingSorting(int[] num) {
            if (num == null || num.length == 0) {
                return 0;
            }
            if (num.length == 1) {
                return 1;
            }
            int count = 1;
            int max = 1;
            Arrays.sort(num);
            for (int i = 1; i < num.length; i++) {
                if (num[i - 1] == num[i]) {//dup case
                    continue;
                } else if (num[i - 1] + 1 == num[i]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
            return max;
        }

    public static void main(String args[]){
        int arr[] = new int[] { 100, 4, 200, 1, 3, 2 };
        System.out.println(" longest concecutive list is "+longestConsecutive(arr));
        System.out.println(" longest concecutive list is "+longestConsecutiveUsingSorting(arr));
    }
    }



