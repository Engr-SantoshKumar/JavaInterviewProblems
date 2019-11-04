/**
 * [ Goo2 22 ] [ Candy Crush  ]
 * ________________________________________________________________________________________________________

 Crush the numbers is its a group of 3 or more

 i/o   {1,2,3,3,3,2,1}
 o/p  {1,1}
 how --> {1,2,3,3,3,2,2,1} -->(crush 3)--> {1,2,2,2,1} -->(crush 2)--> {1,1}
 */

package GooPrep02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class _Goo2_22_Stack_Candy_Crush {
    static Stack<IntAndCount> stack = new Stack<>();
    static ArrayList<Integer> result = new ArrayList<>();

    private static void crushCandy(int[] arr){

        for(int i =0; i <arr.length; i++){
            if(stack.isEmpty()){
                stack.push(new IntAndCount(arr[i], 1));
                continue;
            }
            IntAndCount cur = stack.peek();
            if(cur.value==arr[i]){
                stack.pop();
                stack.push(new IntAndCount(arr[i], cur.count+1));
            }
            else{
                if(cur.count>=3) {
                    stack.pop();
                    cur = stack.peek();
                    if (cur.value == arr[i]) {
                        stack.pop();
                        stack.push(new IntAndCount(arr[i], cur.count+1));
                    }else{
                        stack.push(new IntAndCount(arr[i], 1));
                    }
                }else{
                    stack.push(new IntAndCount(arr[i], 1));
                }
            }
        }

        while(!stack.isEmpty()){
            IntAndCount temp  = stack.pop();
            System.out.println("integer: "+temp.value+  "Value: "+temp.count);
            result.add(temp.value);
        }
        Collections.reverse(result);
        System.out.println(result);
    }


    public static void main(String[] args) {
        int[] arr =  new int[]{1,2,3,3,3,2,2,1,3};
        crushCandy(arr);
    }


    static class IntAndCount{
        Integer value;
        Integer count;
        public IntAndCount(int value, int count){
            this.value = value;
            this.count = count;
        }
    }
}
