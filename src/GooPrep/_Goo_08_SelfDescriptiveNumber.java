/** 08 [Self Descriptive Number]
-------------------------------------------------------------------------------------------------------
 *Consider the following number: 21200. If you look at the digits in the respective positions,
 * you can say it describes itself -
 * Position: 01234
 * Digit:    21200
 * The number 21200 has two 0s, one 1, two 2s, zero 3s and 4s.
 * The question is: given any integer, is it a self-describing number?"
 */
package GooPrep;

import java.util.ArrayList;
import java.util.Collections;


public class _Goo_08_SelfDescriptiveNumber {

    public static boolean isSelfDescriptiveNumber(int num) {

        String s = Integer.toString(num);
        for (int i = 0; i < s.length(); i++) {
            // Extracting each digit one by one from the string
            String temp_char = s.charAt(i) + "";
            int b = Integer.parseInt(temp_char);
            //counting how many times the particular digit
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                int temp = Integer.parseInt(s.charAt(j) + "");
                if (temp == i) {
                    count++;
                }
            }
            /* If it is not equal*/
            if (count != b)
                return false;
        }
        return true;
    }

    //N^2 solution
    public static boolean isDescriptive(int num){
        boolean isSelfDesc = true;
        String s = Integer.toString(num);
        int i =0;
            while(i<s.length() && isSelfDesc){
                int currentDigit = Integer.parseInt(s.charAt(i) + "");
                int count =0;
                    for(int k=0; k<s.length(); k++){
                        if(i == Integer.parseInt(s.charAt(k)+ "")){
                            count ++;
                        }
                    }
                    if(currentDigit != count){
                        return false;
            }
            i++;
        }
        return true;
    }

    public static boolean isSelfDescriptive(int num) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while(num>0){
            arrayList.add(num % 10);
            num = num /10;
        }

        Collections.reverse(arrayList);

        Integer[] arr = new Integer[arrayList.size()];
        arr=arrayList.toArray(arr);
        for(int i =0; i < arr.length; i++){
            int count =0;
            for(int j =0; j<arr.length; j++){
                if(arr[i] == arr[j]) count ++;
            }

            if(count != i){
                return false;
            }
        }
        return true;
     }

    public static void main(String[] args) {

        System.out.println(isSelfDescriptiveNumber(21200));
        System.out.println(isSelfDescriptiveNumber(1210));
        System.out.println(isSelfDescriptiveNumber(11));
        System.out.println(isSelfDescriptiveNumber(21200));


    }
}

