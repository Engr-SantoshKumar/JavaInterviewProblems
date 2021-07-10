/* [ _003_ ] [ Find first missing positive number in array without extra space]
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
package _00_Problems_Sorted_By_Patterns;
    public class _Array_001_First_Missing_Positive {

    static int firstMissingPositiveNumber(int[] arr){
        //base cases
        if(arr == null || arr.length==0 ) return 1;
        //loop thorough arr
        for(int i =0; i<arr.length; i++){
            int current = arr[i];
            //keep swapping to move current to its correct index
            // 1. arr[index] is withing range i.e >0 && <length
            // 2. why if(arr[arr[i]-1] != arr[i]) instead of if(arr[i]-1 != i) ? Aren't they the same???
            // Almost the same, but like [3,2,3,4], when i = 0, A[0] = 3, and we should move it to position 3
            // i.e  i = 2 where there also  A[2] = 3. same digit exists
            // Thus there is no need to do swap or it will go into endless loop
            while(arr[i] > 0 && arr[i] < arr.length && arr[arr[i]-1]!=arr[i] ){
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
        int[] arr1 = {3,4,-1,1};
        System.out.println(firstMissingPositiveNumber(arr1));
    }
}
