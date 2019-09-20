/**  [_Goo2_07- 02 ][strobogrammatic confusing and non confusing with their count in range]
 ________________________________________________________________________________________________________________
 A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Input: low = "50", high = "500"
 strobCount 8
 All strobogrammatic Numbers : [69, 88, 96, 111, 161, 181, 191, 101]

 */

package GooPrep02;

import java.util.*;

public class _Goo2_07_02_find_All_the_number_same_after_360_trun_between_range {


    public static void strobogrammaticInRange(String low, String high){
        Map<Character, Character> hMap = new HashMap<>();{
            hMap.put('1', '1');
            hMap.put('8', '8');
            hMap.put('6', '9');
            hMap.put('9', '6');
            hMap.put('0', '0');
        }

        List<String> resultList = new ArrayList<>();

        int strobCount = 0;
        List<String>  stubList = new ArrayList<>();

        // Idea, loop through low string size to upper string size
        //will formed all the number which are asked with given size
        for(int size = low.length(); size<=high.length(); size++ ){
            List<String> curSizeStrings = stringFormationHelper(size, size, hMap);
            resultList.addAll(curSizeStrings);
        }

        for(String num : resultList){
            //skip the numbs which are not in range
            if(num.length() == low.length() && num.compareTo(low) < 0) continue; // skip lower than low
            if(num.length() == high.length() && num.compareTo(high) > 0) continue; // skip higher than high

            strobCount ++;
            stubList.add(num);
        }
        System.out.println("strobCount " + strobCount );
        System.out.println("All strobogrammatic Numbers : " + stubList );
    }

    // a simple recursion method to construct string
    public static List<String> stringFormationHelper(int sLow, int sHigh, Map<Character, Character> hMap){

        if(sLow == 0){
            return new ArrayList<String>(Arrays.asList(""));
        }
        if(sLow == 1){
            return new ArrayList<String>(Arrays.asList("1", "6", "8", "9", "0")); // for 3 or more sizes, this we work as center digits
        }

        List<String> result = new ArrayList<String>();
        List<String> centerDigits = stringFormationHelper(sLow -2, sHigh, hMap);

        for(int i =0; i < centerDigits.size(); i++ ){
            String midNum = centerDigits.get(i);
            for(Character c: hMap.keySet()) {
                if(c =='0') { //special case to handle 0 in front like 00100
                    if (sLow == sHigh) continue;
                    result.add(c + midNum + hMap.get(c));
                }
                result.add(c+ midNum + hMap.get(c));
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        strobogrammaticInRange("50", "500");
    }
}


