/*
We iterate over the whole linked list and add each visited node to a visitedNodes HashSet. At every node,
we check whether it has been visited or not.
By principle, if a node is revisited, a cycle exists!
 */

package _01_Coderust._02_LinkedList;

import java.util.HashSet;

public class _06_Loopderect {

    boolean flag = false;
    static boolean isLoop(Node head){
        /* will store the already visited nodes */
        HashSet <Node> visitedNode = new HashSet <Node> ();
        Node currentNode = head;


        /*
        Traverse the list and put each node in a HashSet and if a node appears twice in the map
        then it means there is a loop in the list
        */
        while(currentNode!=null){
            if(visitedNode.contains(currentNode)){
                System.out.println("Loop Detected");
                return true;
            }

        /* Insert a node in HashSet */
        visitedNode.add(currentNode);
        currentNode=currentNode.next;
        }
        System.out.println("No Loop Present");
        return false;
    }


    public static void main(String[] args) {

        head = new Node(1);
        head.next= new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println(isLoop(head));
    }


    public static Node head = null;
    public static class Node{
        int data;
        Node next;
        public  Node(int node){
            data=node;
            next= null;
        }
    }

}
