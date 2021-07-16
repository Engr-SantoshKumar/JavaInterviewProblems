/*
 * [_0A_15] [Add Two Numbers non-empty linked lists]
 * _____________________________________________________________________________________________________________
 You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order, and each of their nodes contains a single digit.
 Add the two numbers and return the sum as a linked list.
 You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
*
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 */
package Code_Run_Build_LC350;
import Code_Run_Build_LC350.LinkedList.NodeLinkList;

public class _oA_15_Add_Two_Numbers_LinkList {
    public static NodeLinkList addTwoNumbers(NodeLinkList nodeOne, NodeLinkList nodeTwo){
        // need a new link list to store the sum of nodes (i.e 1st node.date of LinkListOne + 1st node.date of LinkList2nd)
        NodeLinkList sumList = new NodeLinkList(0);
        // need variable to travel/update all three linkList
        NodeLinkList l1 = nodeOne, l2 = nodeTwo, current = sumList;
        int carry = 0;
        // loop until booth ends
        while(l1!=null || l2!=null){
            int sum =carry;
            if(l1 != null){
                sum+=l1.data;
                l1 = l1.next;
            }
            if(l2 != null){
                sum+=l2.data;
                l2 = l2.next;
            }
            //create new node with sum %10 in sumLinkList
            current.next = new NodeLinkList(sum % 10);
            current = current.next;
            carry = sum / 10;
        }
        // create a last node for any carry value
        if(carry > 0){
            current.next = new NodeLinkList(carry);
        }
        return sumList.next;
    }

    public static void main(String[] args) {
        //Integer[] a = {9,9,9,9,9,9,9};
        //Integer[] b = {9,9,9,9};
        Integer[] a = {2,4,3};
        Integer[] b = {5,6,4};
        LinkedList<Number> list1 = new LinkedList<Number>(a);
        LinkedList<Number> list2 = new LinkedList<Number>(b);
        NodeLinkList headA = list1.getHead();
        NodeLinkList headB = list2.getHead();
        LinkedList.printList(addTwoNumbers(headA, headB));

    }
}
