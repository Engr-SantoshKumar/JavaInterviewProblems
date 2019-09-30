package GooPrep02;

import java.util.Arrays;
import java.util.Stack;

/**
 * [Goo2 12 T ] [PostOrder_Without_Recursion]
 * ____________________________________________________________________________________________________________________
 */
public class _Goo2_12_T_PostOrder_Without_Recursion {


    public static int[] postOrderUsingStack(Node root){

        Stack<Node> rootStack = new Stack<>();
        Stack<Node> resultStack = new Stack<>();

        rootStack.push(root);
        while(!rootStack.isEmpty()){

            Node current = rootStack.pop();
            resultStack.push(current);

            if(current.left!= null)
                rootStack.push(current.left);
            if(current.right!=null)
                rootStack.push(current.right);
        }

        int[] resultArray = new int[resultStack.size()];
        int i =0;
        while(!resultStack.isEmpty()){
            resultArray[i++] = resultStack.pop().data;
        }
        return resultArray;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 8, 1, 4, 7, 9};
        Node root = TreeHelper.create(arr);
        int[] result = postOrderUsingStack(root);

        System.out.println(Arrays.toString(result));

    }
}
