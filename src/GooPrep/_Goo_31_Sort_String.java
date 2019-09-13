/** 31  [Sort String]
 ---------------------------------------------------------------------------------------------------------
// same as problem _Goo_22_Character_Occurrences_Order

/**
 * "Write a procedure which accept this string “THISISGOOD” .
 * ==> print string in sorted order - DGHIIOOSST
 * ==> print letter with highest count - 2 - IOS"
 */

package GooPrep;

//Efficient sol is in _Goo_22
//below is another way to solve
public class _Goo_31_Sort_String {

    public static void main(String args[]) {
        String s = "THISIISGOOOD";
        sortString(s);


    }

    static void sortString(String s){

        if(s.length()==0){
            System.out.println("Empty String");
        }

        String newStr = "";

        int[] chars = new int[26];

        for(char c : s.toCharArray()){
            chars[c - 'A'] ++;
        }

        int maxCount =0;

        for(int i =0; i<chars.length; i++){
            maxCount = Math.max(maxCount, chars[i]);
            if(chars[i] > 0){
                for(int j =0; j < chars[i]; j++){
                    char c = (char)(i + 'A');
                    newStr+=c;
                }
            }
        }


        System.out.println("Given String  : " + s);
        System.out.println("Sorted String : " + newStr);

        for(int i =0; i<chars.length; i++){
            if(chars[i] == maxCount){
                System.out.println("Char : "+((char)(i +'A')) + " its Count : " + maxCount );

            }
        }
    }

}
