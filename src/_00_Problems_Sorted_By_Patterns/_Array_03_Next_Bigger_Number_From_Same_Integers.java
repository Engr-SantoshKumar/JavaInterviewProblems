package _00_Problems_Sorted_By_Patterns;/* [  ] [  ]
_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
← ↑ → ↓ ↖ ↘ ↗ ↙   ●  ○ ∞
*/

public class _Array_03_Next_Bigger_Number_From_Same_Integers {
    
    public static int nextBiggerNumber(int n){
        //base case
        if( n<10) return -1;
        
        char[] arr = (n + "").toCharArray();
        /*
        String temp = Integer.toString(n);
        int[] arr = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            arr[i] = temp.charAt(i) - '0';
        }*/
        
        
        /* I) Start from the right most digit and  find the first digit that
         is smaller than the digit next to it (which breaks ascending order) */
        int i, j;
        for (i = arr.length-1; i > 0; i--)
            if (arr[i-1] < arr[i]){
                break;
            }
        // If no such digit is found, its the edge case 1.
        if (i == 0)
            return -1;
        
        //II) Find the smallest digit on right side of (i-1)'th digit that is greater than number[i-1]
        for( j = arr.length-1; j>i; j--){
            if(arr[j] > arr[i-1]) break;
        }
        
        // III) Swap the above found smallest digit with number[i-1]
        char temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;
        
        /* IV) Sort the digits after (i-1) in ascending order */
        //Arrays.sort(number, i, number.length); //nLog(n)
        reverse(arr, i, arr.length-1); //O(n)
        
        return Integer.parseInt(new String(arr)); //come back this could be a problem
        
        /*long val = Long.parseLong(new String(arr));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1; */
    }
    
    private static void reverse(char[] arr, int s, int e) {
        while(s < e){
            char temp = arr[s];
            arr[s] =arr[e];
            arr[e] = temp;
            s++; e--;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(nextBiggerNumber(5349763));
        System.out.println(nextBiggerNumber(1234));
        System.out.println(nextBiggerNumber(4321));
        System.out.println(nextBiggerNumber(10010));
        System.out.println(nextBiggerNumber(1332211));
        System.out.println(nextBiggerNumber(5));
        System.out.println(nextBiggerNumber(1200000));
    }
}
