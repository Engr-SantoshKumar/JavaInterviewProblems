/**
[ Apple_12 ] [ Construct Binary Search Tree from Preorder Traversal ]
 _______________________________________________________________________________________________________
 Return the root node of a binary search tree that matches the given preorder traversal.
 Input: [8,5,1,7,10,12]
 Output: [8,5,10,1,7,null,12]

 Complexity Analysis
 Time complexity :{O}(N) since we visit each node exactly once.
 Space complexity :{O}(N) to keep the stack and the tree.
 */
package Apple_FB_Prep;
import java.util.ArrayDeque;
import java.util.Deque;

public class _oA_12_Construct_Binary_Search_Tree_from_Peorder_Traversal {

    static Node bstFromPreOrder(int[] arr){
        if(arr == null || arr.length==0) return null;

        Deque<Node> stack = new ArrayDeque<>();
        //Pick the first preorder element as a root root = new TreeNode(preorder[0]) and push it into stack.
        Node head  = new Node(arr[0]);
        stack.push(head);

        //Pick the last element of the stack as a parent node, and the the current element of preorder as a child node.
        for(int i=1; i<arr.length; i++){
            Node currentHead = stack.peek();
            Node child = new Node(arr[i]);
            //Adjust the parent node :
            // pop out of stack all elements with the value smaller than the child value.
            while(!stack.isEmpty() && stack.peek().data < child.data){
                currentHead = stack.pop();
            }
            if(currentHead.data > arr[i]) currentHead.left = child;
            else currentHead.right = child;
            //Push child node into the stack.
            stack.push(child);
        }
        return head;
    }

    public static void main(String[] args) {
        //Test One
        int[] arr = new int[]{8,5,1,7,10,12};
        TreeHelper.print(bstFromPreOrder(arr));
    }

}
