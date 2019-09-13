/** 03 [Sort String]
-------------------------------------------------------------------------------------------------------
 *
 * "Write a procedure which accept this string “THISISGOOD” .
 * ==> print string in sorted order - DGHIIOOSST
 * ==> print letter with highest count - 2 - IOS"
 */
package GooPrep;

public class _Goo_03_Sort_String {

    static String sort_string(String s){
        StringBuffer sortedString = new StringBuffer();

        int[] arr = new int[26];

        for(char c : s.toCharArray()){
            arr[c-'A']++;

        }

        for(int i = 0; i<arr.length; i++){
            int charCount = arr[i];
            if(charCount > 0){
                for(int k =0; k<charCount; k++){
                    int FinalIntValue = i + 'A';
                    char b=(char)FinalIntValue;
                    sortedString.append(b);
                }
            }
        }
        //Converting to string
        System.out.println(sortedString.toString());
        return sortedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(sort_string("SANTOSH"));

    }
}
