/* [ _ModifiedBinarySearch_04_ ] [ Find Smallest Letter Greater Than Target ]
_______________________________________________________________________________
Given a characters array letters that is sorted in non-decreasing order and a character target,
return the smallest character in the array that is larger than target.

Note that the letters wrap around.

For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.

Input: letters = ["c","f","j"], target = "a"
Output: "c"
---------------------------
NOTE SOME POINTS TO BS
1. always use start+(end-start) to fins mid, start+end will cause an overflow
2. When do you use while (start<end) , when do you use while (start<=end)?
  -->  You use while (start <= end) if you are returning the match from inside the loop.
  -->  You use while (start < end) if you want to exit out of the loop first, and then use the result
        of start or end to return the match.
*/
package _00_Problems_Sorted_By_Patterns;
public class _ModifiedBS_04_Find_Smallest_Letter_Greater_Than_Target {
        public static char nextGreatestLetter(char[] letters, char target) {
            int n = letters.length;
            if(target >= letters[n - 1]) return letters[0];

            int left = 0;
            int right = n - 1;
            while(left < right){
                int mid = left + (right - left)/2;
                if(letters[mid] <= target) left = mid + 1;
                else right = mid;
            }
            return letters[right];
        }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c','f','j'}, 'a'));
        System.out.println(nextGreatestLetter(new char[]{'c','f','j'}, 'k'));
        System.out.println(nextGreatestLetter(new char[]{'c','f','j'}, 'f'));
    }

}
