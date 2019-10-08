/**  50  [Binary Tree Level order Traversal]
 -------------------------------------------------------------------------------------------------------
 Approach 1: [better]
    use size of the queue to print

 Approach 2:
    Use one queue and delimiter to print level by level
    each level is ending with null in queue check if the removed element is null,
    if yes push the null again ..thats means there will a null at the end if each level
 */
package GooPrep;
import java.util.LinkedList;
import java.util.Queue;
public class _Goo_50_BinaryTree_Level_Order_Traversal {

    public static void bfsLevelByLineUsingQueueSize(Node root){
        if(root==null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            while(size >0){
                Node current = q.poll();
                if(current!=null)
                {
                    System.out.print(current.data + " ");
                    if(current.left != null){
                        q.add(current.left);
                    }
                    if(current.right != null){
                        q.add(current.right);
                    }
                }
                size --;
            }
            System.out.println();
        }
    }

    public static void bfsLevelByLineUsingQueuePointer(Node root){
        if(root==null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node current = q.poll();
            if(current!=null)
            {
                System.out.print(current.data + " ");
                if(current.left != null){
                    q.add(current.left);
                }
                if(current.right != null){
                    q.add(current.right);
                }

            }else{
                if(q.size() ==0){
                    System.out.println();
                    break;
                }
                q.add(null);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        int[] nodes = new int[]{50, 30, 70, 20, 40, 60, 80, 5, 10,5};
        Node r = TreePrint.create(nodes);

        System.out.println("\n Level By Level Traversal of Above Tree");
        bfsLevelByLineUsingQueueSize(r);

        System.out.println("\n Level By Level Traversal of Above Tree");
        bfsLevelByLineUsingQueuePointer(r);
    }
}
