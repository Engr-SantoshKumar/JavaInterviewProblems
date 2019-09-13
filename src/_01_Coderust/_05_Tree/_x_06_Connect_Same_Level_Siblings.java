package _01_Coderust._05_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class _x_06_Connect_Same_Level_Siblings {

    private static void connect_next_level(Node head){

        if(head == null ) return;

        Queue<Node> queue = new LinkedList<>();

        queue.add(head);
        queue.add(null);

        while(!queue.isEmpty()){
            Node current = queue.peek();
            queue.remove();
            if(current != null){
                System.out.print(current.data + " ");
                if(current.left!=null)
                    queue.add(current.left);
                if(current.right!=null)
                    queue.add(current.right);
            }else{
                if(!queue.isEmpty()){
                    System.out.println("\nNext Level");
                    queue.add(null);
                }
            }
            }

        }


    public static void main(String[] args) {
        Node r1 = TreePrint.create(new int[]{10, 5, 20, 3, 8, 15, 50, 1, 4, 6, 9, 12, 18, 40, 60});
        System.out.print("\nAbove Tree's Level-order traversal:\n");
        connect_next_level(r1);
    }
}
