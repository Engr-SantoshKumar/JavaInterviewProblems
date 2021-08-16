/** 02 [Stack Max Function]
----------------------------------------------------------------------------------------------------
 * how to implement a max stack which has additional popMax and peek
 */

package GooPrep;
import java.util.Stack;

public class _Goo_02_StackPopMaxFunction extends Stack<Integer> {

    Stack<Integer> mainStack = new Stack<Integer>();
    Stack<Integer> maxStack = new Stack<>();

    public void push(int I){
        mainStack.push(I);
        if(I >= getMax()){
            maxStack.push(I);
        }
    }
    public Integer pop(){

        Integer x = mainStack.pop();
        Integer y = maxStack.pop();

        if(!x.equals(y)){
            maxStack.push(y);
        }
        return x;
    }

    public Integer popMax(){

        Integer x = mainStack.pop();
        Integer y = maxStack.pop();

        while(!x.equals(y)){
            x = mainStack.pop();
        }
        return x;
    }

    public int getMax(){
        if(maxStack.isEmpty()){
            return Integer.MIN_VALUE;
        } else
            return maxStack.peek();
    }

    public static void main(String[] args) {
        _Goo_02_StackPopMaxFunction s = new _Goo_02_StackPopMaxFunction();
        s.push(10);
        s.push(20);
        s.push(15);
        s.push(40);
        System.out.println(s.getMax());
        s.push(50);
        System.out.println(s.getMax());
        s.pop();
        System.out.println(s.getMax());
        System.out.println(s.popMax());
        System.out.println(s.getMax());
        System.out.println(s.popMax());
        System.out.println(s.getMax());
    }
}
