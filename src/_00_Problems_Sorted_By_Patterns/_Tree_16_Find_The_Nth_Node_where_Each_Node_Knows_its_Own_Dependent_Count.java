/* [  ] [ Find the k-th node in its inorder traversal ]
_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
← ↑ → ↓ ↖ ↘ ↗ ↙   ●  ○ ∞

Given a binary tree where a node also holds number of descendants and an int k .
Find the k-th node in its inorder traversal (the number if brackets is number of children of each node).

Example: For example, we have 9 nodes, FindNthNode(root,  7) should return _N7_
7th means 8th node in the inorder as its start from 0

                       N4(c:8)
        	           ↙      ↘
                 N1(c:3)      N5(c:3)
                ↙     ↘           ↘
         N0(c:0)      N3(c:1)     N6(c:2)
                      ↙               ↘
                   N2(c:0)            _N7_(c:1)  (This is the 7th node. The index is based on 0 not 1) 7th means at 8th position
                                           ↘
                                          N8(c:0)


*/
package _00_Problems_Sorted_By_Patterns;

import java.util.ArrayList;
import java.util.List;

public class _Tree_16_Find_The_Nth_Node_where_Each_Node_Knows_its_Own_Dependent_Count {

    static class NodeD {
        int val;
        int descendantsCount;
        NodeD left = null, right = null;
    
        public NodeD(int val, int dc) {
            this.val = val;
            this.descendantsCount = dc;
        }
    }
    NodeD root;
    
    public static NodeD FindNthNode(NodeD root, int k) {
        if (root == null || root.descendantsCount < k || k<0)
            return null;
    
        return FindNthNodeHelper(root, k+1);
    }
    
    private static NodeD FindNthNodeHelper(NodeD root, int k) {
        int leftSideCount = root.left==null ? 0 : root.left.descendantsCount+1; //descendantsCountOfLeft + its own leftRoot (+1)
        //System.out.println("leftSideCount " + leftSideCount );
        if (k <= leftSideCount)
            return FindNthNodeHelper(root.left, k);
        
        else if (k == leftSideCount + 1)
            return root;
        else
            return FindNthNodeHelper(root.right, k-(leftSideCount+1)); //leftSideCount+root as we are moving to right of root
    }
    
    public static void main(String[] args) {
        NodeD root = new NodeD(4,8);
        root.left = new NodeD(1, 3);
        root.left.left = new NodeD(0,0);
        root.left.right = new NodeD(3,1);
        root.left.right.left = new NodeD(2,0);
        root.right = new NodeD(5,3);
        root.right.right = new NodeD(6,2);
        root.right.right.right = new NodeD(71,1);
        root.right.right.right.right = new NodeD(8,0);
    
        NodeD NthNode = FindNthNode(root, 0);
        System.out.println("K=0 "+(NthNode==null? "null" : NthNode.val));
        NthNode = FindNthNode(root, 1);
        System.out.println("K=2 "+(NthNode==null? "null" : NthNode.val));
        NthNode = FindNthNode(root, 2);
        System.out.println("K=2 "+(NthNode==null? "null" : NthNode.val));
        NthNode = FindNthNode(root, 3);
        System.out.println("K=3 "+(NthNode==null? "null" : NthNode.val));
        NthNode = FindNthNode(root, 4);
        System.out.println("K=4 "+(NthNode==null? "null" : NthNode.val));
        NthNode = FindNthNode(root, 5);
        System.out.println("K=5 "+(NthNode==null? "null" : NthNode.val));
        NthNode = FindNthNode(root, 6);
        System.out.println("K=6 "+(NthNode==null? "null" : NthNode.val));
        NthNode = FindNthNode(root, 7);
        System.out.println("K=7 "+(NthNode==null? "null" : NthNode.val));
        NthNode = FindNthNode(root, 8);
        System.out.println("K=8 "+(NthNode==null? "null" : NthNode.val));
        NthNode = FindNthNode(root, 9);
        System.out.println("K=9 "+(NthNode==null? "null" : NthNode.val));
    
        //=======================================================
        System.out.println("Using InOrderTraversal O(N), MemoryStack O(N)");
        NthNode = findNthNodeOrderOfNode(root, 0);
        System.out.println("K=0 "+(NthNode==null? "null" : NthNode.val));
        NthNode = findNthNodeOrderOfNode(root, 1);
        System.out.println("K=2 "+(NthNode==null? "null" : NthNode.val));
        NthNode = findNthNodeOrderOfNode(root, 2);
        System.out.println("K=2 "+(NthNode==null? "null" : NthNode.val));
        NthNode = findNthNodeOrderOfNode(root, 3);
        System.out.println("K=3 "+(NthNode==null? "null" : NthNode.val));
        NthNode = findNthNodeOrderOfNode(root, 4);
        System.out.println("K=4 "+(NthNode==null? "null" : NthNode.val));
        NthNode = findNthNodeOrderOfNode(root, 5);
        System.out.println("K=5 "+(NthNode==null? "null" : NthNode.val));
        NthNode = findNthNodeOrderOfNode(root, 6);
        System.out.println("K=6 "+(NthNode==null? "null" : NthNode.val));
        NthNode = findNthNodeOrderOfNode(root, 7);
        System.out.println("K=7 "+(NthNode==null? "null" : NthNode.val));
        NthNode = findNthNodeOrderOfNode(root, 8);
        System.out.println("K=8 "+(NthNode==null? "null" : NthNode.val));
        NthNode = findNthNodeOrderOfNode(root, 9);
        System.out.println("K=9 "+(NthNode==null? "null" : NthNode.val));
        
    }
    
    
    //inOrder Traversal
    //Time Complexity: O(n) where n is number of nodes
    public static NodeD findNthNodeOrderOfNode(NodeD root, int k){
        if (root == null || root.descendantsCount < k || k<0)
            return null;
        List<NodeD> treeNodesList = new ArrayList<>();
        inOrderTraversal(root, treeNodesList);
        /*for(NodeD current: treeNodesList){
            System.out.print(current.val + " ");
        }*/
        return treeNodesList.get(k);
    }
    
    public static void inOrderTraversal(NodeD root, List<NodeD> treeNodesList){
        if(root==null) return;
        inOrderTraversal(root.left, treeNodesList);
        treeNodesList.add(root);
        inOrderTraversal(root.right, treeNodesList);
    }
}
