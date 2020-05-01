/**
[ _Apple_11 ] [ Find first missing positive number in array without extra space]
 ____________________________________________________________________________________________________________
 Logic: we will use in-place to solve the problem
 1. will try to sort the array in such a way so that each number at correct index
 e.g:
 index  0   1   2   3
 num    1   2   3   4

 CORRECT SLOT will never be changed: for CORRECT SLOT, A[A[i] - 1] always equals to A[i], vice versa (1)
 For each swap, the number of CORRECT SLOT increases by at least 1: Position A[A[i] - 1] = A[i] becomes a
 CORRECT SLOT after swap, and according to (1), this must be a new CORRECT SLOT
 The maximum of CORRECT SLOT <= N
 Therefore, the complexity is O(N)
 */
package Apple_FB_Prep;
public class _Apple_11_FirstMissingPositiveNumber {

    static int firstMissingPositiveNumber(int[] arr){
        //base cases
        if(arr == null || arr.length==0 ) return 1;
        //loop thorough arr
        for(int i =0; i<arr.length; i++){
            int current = arr[i];
            //keep swapping to move current to its correct index
            // 1. arr[index] != index +1 e.g at index 0 number should be 1
            // 2. arr[index] is withing range i.e >0 && <length
            while(current-1 >= 0 && current-1 < arr.length && current!=arr[current-1] ){
                int temp = arr[current-1];
                arr[current-1] = arr[i];
                arr[i] = temp;
            }
        }
        //check if arr[index] == index + 1;
        for(int i=0; i < arr.length; i++){
            if(arr[i]!=i+1) return i+1;
        }
        //corner case: {1,2,3,4} return 5
        return arr.length+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,8,2,3,9};
        System.out.println(firstMissingPositiveNumber(arr));
    }
}
