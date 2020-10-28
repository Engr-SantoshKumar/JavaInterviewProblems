/**
[ Apple_09 ] [ String Shifts ]
____________________________________________________________________________________________________________
 You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 direction can be 0 (for left shift) or 1 (for right shift).
 amount is the amount by which string s is to be shifted.
 A left shift by 1 means remove the first character of s and append it to the end.
 Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.

 Input: s = "abc", shift = [[0,1],[1,2]]
 Output: "cab"
 Explanation: [0,1] -->  "abc" -> "bca" --> [1,2] right by 2. "bca" -> "cab"
 */
package Code_Run_Build_LC350;
public class _oA_09_StringShifts {
    static void stringShift(String s, int[][] shift) {
        /*find the final shift by counting the total left shift times
        (may be negative if the final result is right shift), and perform it once. */
        int finalShift =0;
        for(int i=0; i<shift.length; i++){
            finalShift = finalShift + (shift[i][0] == 0? -(shift[i][1]) : (shift[i][1]));
        }
        System.out.println(finalShift);

        /* one more logic: suppose if the finalShift is 30 and length of string is 4, we dont want
        to shift it 100 time ..we can avoid by 30 % 4 --> 2 ..we just need to shift 2 times   */
        int realShift = Math.abs(finalShift % (s.length()));
        System.out.println(realShift);
        String result = "";
        if(finalShift > 0){
            result = s.substring(s.length()-realShift) + s.substring(0,(s.length() - realShift));
            }else{
            result = s.substring(realShift) + s.substring(0,realShift);
        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        String s = "abcdefg";
        String s1 = "joiazl";
        int[][] shift = {{1,1},{1,1},{0,7},{1,3}};
        int[][] shift1 = {{1,1},{1,6},{0,1},{1,3},{1,0},{0,3}};
        stringShift(s1, shift1 );
        stringShift(s, shift );
    }
}
