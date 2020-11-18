/* [ _oA_42_ ] [ Swap Nodes in Pairs stack solution ]
_______________________________________________________________________________
Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes. Only nodes itself may be changed.

Input: head = [1,2,3,4]
Output: [2,1,4,3]

*/
package Code_Run_Build_LC350;
import Code_Run_Build_LC350.LinkedList.NodeLinkList;
import java.util.Stack;

public class _oA_42_Swap_Nodes_in_Pairs_Stack {

    public static NodeLinkList swapNodesUsingStack( NodeLinkList head, int k){
        //base check
        if(head==null || head.next ==null || k<2) return head;

        NodeLinkList currentNode = new NodeLinkList(0);
        NodeLinkList dummyNode = currentNode;
        //we will use stack to reverse the nodes pointer
        Stack<NodeLinkList> stack = new Stack<>();

        while(head!=null){
            stack.push(head);
            head = head.next;
            if(stack.size() == k){
                while(!stack.isEmpty()){
                    currentNode.next = stack.pop();
                    currentNode = currentNode.next;
                }
            }
        }
        // if stack still contains any node
        while(!stack.isEmpty()){
            currentNode.next = stack.pop();
            currentNode = currentNode.next;
        }
        // end the currentNode linkList
        currentNode.next = null; //--> imp step else it will go in infinite loop
        return dummyNode.next;
    }
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4};
        LinkedList<Number> list1 = new LinkedList<Number>(a);
        LinkedList.NodeLinkList head1 = list1.getHead();
        LinkedList.NodeLinkList result =swapNodesUsingStack(head1, 2);
        LinkedList.printList(result);
    }
}
