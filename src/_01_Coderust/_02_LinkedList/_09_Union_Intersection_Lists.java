package _01_Coderust._02_LinkedList;
/*
Sample Input

list1 = 10->20->80->60
list2 = 15->20->30->60->45
Sample Output

Union = 10->20->80->60->15->30->45
Intersection = 20->60
 */


import _01_Coderust._02_LinkedList.LinkedList.Node;

import java.util.HashSet;
public class _09_Union_Intersection_Lists {


    static Node union(Node headA, Node headB){
        // created two pointer pointing to head of each linkedlist
        Node currentA = headA;
        Node currentB = headB;

        HashSet<Integer> visitedNodes = new HashSet<Integer>();

        /* stored all the elements of linkedlist A
        * traverse until the last element, but not until null so that we can link last to head of 2nd list*/

        while(currentA.next!= null)
            if (!visitedNodes.contains(currentA.data)) {
            visitedNodes.add(currentA.data);
            currentA = currentA.next;
        }

        currentA.next=headB;  // linked to next list
        Node previous = null;

        // here will traverse through listB and remove the already existing from listB
        while(currentB!=null){

           if(visitedNodes.contains(currentB.data)){
               previous.next = currentB.next;
           }else{
               previous=currentB;
               visitedNodes.add(currentB.data);

           }
            currentB = currentB.next;

        }
        return headA;
    }

    static String intersection(Node headA, Node headB){
        // created two pointer pointing to head of each linkedlist
        Node currentA = headA;
        HashSet<Integer> visitedNodes = new HashSet<Integer>();

        /* stored all the elements of linkedlist A */

        while(currentA!= null)
            if (!visitedNodes.contains(currentA.data)) {
                visitedNodes.add(currentA.data);
                currentA = currentA.next;
            }

        // Traversing listB and print only those which are present in hashSet
        String result ="";
        Node currentB = headB;
        while(currentB!=null){
            if (visitedNodes.contains(currentB.data)){
                result += currentB.data;
                result += "->";
            }
            currentB=currentB.next;
        }
        result +=null;
        return result;

    }


    public static void main(String[] args) {
        Integer[] a = {10, 20, 80, 60};
        Integer[] b = {15, 20, 30, 60, 45};

        LinkedList mylistA = new LinkedList(a);
        LinkedList mylistB = new LinkedList(b);
        LinkedList.Node headA = mylistA.getHead();
        LinkedList.printList(headA);
        LinkedList.Node headB = mylistB.getHead();
        LinkedList.printList(headB);

        LinkedList.Node newHeadUnion = union(headA, headB);
        System.out.println("\n");
        System.out.println("Union of A and B");
        LinkedList.printList(newHeadUnion);
//======================================================================================

        Integer[] a1 = {10, 20, 80, 60, 45};
        Integer[] b1 = {15, 20, 30, 60, 45};

        LinkedList mylistA1 = new LinkedList(a1);
        LinkedList mylistB1 = new LinkedList(b1);

        LinkedList.Node headA1 = mylistA1.getHead();
        LinkedList.Node headB1 = mylistB1.getHead();

        String intersectionAB = intersection(headA1, headB1);
        System.out.println("\n");
        System.out.println("==========================");
        System.out.println(" Intersection of A and B ");
        System.out.println(intersectionAB);



    }
}
