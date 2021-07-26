/* [ _SlidingWindow_02_ ] [ Fruits into Baskets ]
_______________________________________________________________________________
Given an array of characters where each character represents a fruit tree,
you are given two baskets and your goal is to put maximum number of fruits in each basket.
The only restriction is that each basket can have only one type of fruit.
Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5 -- We can put 3 'B' in one basket and two 'C' in the other basket.
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
----------------------
Logic:Sliding Window pattern --> Longest Substring with K Distinct Characters.
In this problem, we need to find the length of the longest subArray with no more than two distinct characters
(or fruit types!). This transforms the current problem into Longest Substring with K Distinct Characters where K=2.

*/
package _00_Problems_Sorted_By_Patterns;

import java.util.HashMap;
import java.util.Map;

public class _SlidingWindow_02_Fruit_into_Baskets {
    public static int findMaxFruitQuantity(char[] fruitsArray){
        int windowStart=0;
        int maxQuantity=0;
        Map<Character, Integer> countMap = new HashMap<>();
        //extend range [windowStart, windowEnd]
        for(int windowEnd=0; windowEnd<fruitsArray.length; windowEnd++){
            char rightChar = fruitsArray[windowEnd];
            countMap.put(rightChar,countMap.getOrDefault(rightChar,0)+1);

            //shrink the window, until we have only 2 kinds of fruits left
            while(countMap.size() > 2){ //---> this line is only different from problem: K Distinct char subString
                char leftChar = fruitsArray[windowEnd];
                countMap.put(leftChar,countMap.get(leftChar) -1);
                if(countMap.get(rightChar)==0){
                    countMap.remove(rightChar);
                }
                windowStart++; //-->shrink the window
            }
            maxQuantity = Math.max(maxQuantity, windowEnd-windowStart+1);
        }
        return maxQuantity;
    }

    public static void main(String[] args) {
        char[] fruits = new char[]{'A', 'B', 'C', 'B', 'B', 'C' };
        System.out.println(findMaxFruitQuantity(fruits));
    }
}

