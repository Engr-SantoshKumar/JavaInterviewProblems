/*
 * [ _oA_25_ ] [ package Code_Run_Build_LC350; ]
 * _______________________________________________________________________________________________________________
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

 */
package Code_Run_Build_LC350;
public class _oA_25_ZigZag_Conversion {

    public static String zigZagConvert(String s, int nRows) {
        char[] charArray = s.toCharArray();
        int strLen = charArray.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < strLen) {
            for (int j = 0; j < nRows && i < strLen; j++) // vertically down
                sb[j].append(charArray[i++]);
            for (int j = nRows-2; j >= 1 && i < strLen; j--) // obliquely up
                sb[j].append(charArray[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

    public static void main(String[] args) {
        String s ="PAYPALISHIRING";
        System.out.println(zigZagConvert(s, 4));
    }

}
