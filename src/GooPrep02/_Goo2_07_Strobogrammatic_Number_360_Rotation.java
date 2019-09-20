package GooPrep02;

import java.util.HashMap;

public class _Goo2_07_Strobogrammatic_Number_360_Rotation {

    public static boolean find_Non_confusing_Numbers_after_upSide_Down(String num){

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('1','1');
        map.put('0','0');
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (!map.containsKey(num.charAt(left)) || !map.get(num.charAt(left)).equals(num.charAt(right))) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] nums = {"101", "69", "88", "68", "66"};

        for(int i =0; i < nums.length; i++){
            System.out.println("Is "+nums[i]+" not confusing --> "+
                    find_Non_confusing_Numbers_after_upSide_Down(nums[i]));
        }
    }

}

