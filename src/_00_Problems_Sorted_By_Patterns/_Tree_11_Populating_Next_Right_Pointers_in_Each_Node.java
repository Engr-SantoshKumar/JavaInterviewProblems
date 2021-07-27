/* [  ] [ 116. Populating Next Right Pointers in Each Node ]
_______________________________________________________________________________

                        1 ---------------->Null
                ┌───────┴───────┐
                2-------------> 4 ------>  Null
            ┌───┴───┐       ┌───┴───┐
            3 -----> 5 ---> 7 ----> 9 -->  Null
          ┌─┘
         10------------------------------> Null
*/
package _00_Problems_Sorted_By_Patterns;
public class _Tree_11_Populating_Next_Right_Pointers_in_Each_Node {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        // Start with the root node. There are no next pointers
        // that need to be set up on the first level
        Node leftmost = root;

        // Once we reach the final level, we are done
        while (leftmost.left != null) {

            // Iterate the "linked list" starting from the head
            // node and using the next pointers, establish the
            // corresponding links for the next level
            Node head = leftmost;
            while (head != null) {
                // CONNECTION 1
                head.left.next = head.right;
                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                // Progress along the list (nodes on the current level)
                head = head.next;
            }
            // Move onto the next level
            leftmost = leftmost.left;
        }
        return root;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
