/* [  ] [ Median of Two Sorted Arrays ]
_______________________________________________________________________________
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Input: nums1 = [], nums2 = [1]
Output: 1.00000
*/
package _00_Problems_Sorted_By_Patterns;
/*
    Step 1: Always keep Array A smaller than B
    Step 2: suppose the total len of both array combined is [6+9] -> 15, we will do binary search on Array A and find
            mid ( 6/2 --> 3) at index 3 this will be arbitrary mid and what will be arbitrary mid of Array B
            totalLen/2 - elements picked in array A --> 15/2 - 3 => 7-3 => 5 so the mid of arrayB is 5th index
    Step 3: we also needs to handle the cases of when median is falling on just one array by consuming all elements of
           one array and few from other


    As we learned we are going to play with aMidLeftVal, aMidVal, bMidVal && bMidLeftVal
            so a straight forward happy positive case will be like
                        if(a[aLeft-1] <= b[bLeft] && b[bLeft-1] <= a[aLeft] ) →  then → find median
            BUT boundary cases :
                        suppose if array B has just 1 element then its possible median will be in array a and vice versa
            so we can't just simply move mid/aLeft (← ← or → →) now its comes to how far we can move aLeft-1, aLeft, bLeft-1 and bLeft
            lets assign boundary for it
            ● if aLeft-1 at 0th element of Array A. we can not do more aLeft -1. so assign the minimum value → minus ∞
            ● same way if we get to the last element of Array a. we can not move more assign max → . so assign → +∞
            ● same for array b's bLeft -1 and bLeft

*/
public class _ModifiedBS_08_Median_Of_Two_Sorted_Array {
    //https://scottc130.medium.com/understanding-leetcode-median-of-two-sorted-arrays-hard-a83d7e5cac53
    public static double findMedianSortedArrays(int[] a, int[] b) {
        //make first array smaller size (the array on which we are performing binary search
        if(a.length > b.length)
            return findMedianSortedArrays(b,a);

        // some variables, as we are performing BS on array a
        int aLen = a.length;
        int bLen = b.length;
        int lo =0;
        int hi = aLen;

        while(lo <= hi){
            int aMidPos = (lo+hi)/2; //--> aMidPos is noting but mid Position created by BS
            int bMidPos = (aLen+bLen+1)/2 - aMidPos;

            int aMidLeftVal = (aMidPos == 0)? Integer.MIN_VALUE : a[aMidPos-1];
            int aMidVal = (aMidPos == aLen)? Integer.MAX_VALUE : a[aMidPos];

            int bMidLeftVal = (bMidPos == 0)? Integer.MIN_VALUE : b[bMidPos-1];
            int bMidVal = (bMidPos == bLen)? Integer.MAX_VALUE : b[bMidPos];


            //check if we get split both array correctly
            if(aMidLeftVal <= bMidVal && bMidLeftVal <= aMidVal ){
                //if even len
                if((aLen+bLen) % 2 ==0){
                    int lMax = Math.max(aMidLeftVal, bMidLeftVal);
                    int rMin = Math.min(aMidVal, bMidVal);
                    return (lMax+rMin)/2.0;

                }else{
                    return Math.max(aMidLeftVal, bMidLeftVal);
                }
            }
            // need to shift arbitrary mid in array A
            else if(aMidLeftVal > bMidVal){
                //there are more elements need to be pick from array b (moving mid/aMidPos ← ←
                hi = aMidPos-1;
            }
            else{
                // there are more elements need to pick from array a (moving mid/aMidPos → →
                lo = aMidPos+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3};
        int[] b = new int[] { 4, 5, 6, 7, 8, 9};
        System.out.println(findMedianSortedArrays(b,a));
    }
}
