package _00_Problems_Sorted_By_Patterns;/* [  ] [  ]
_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
← ↑ → ↓ ↖ ↘ ↗ ↙   ●  ○ ∞
*/

import java.util.ArrayList;
import java.util.List;

public class _Tree_16_Find_Nth_Node {
   
   static class NodeD {
        char val;
        int descendantsCount;
        NodeD left = null, right = null;
        
        public NodeD(char val, int dc) {
            this.val = val;
            this.descendantsCount = dc;
        }
    }
    NodeD root;
    
    public static NodeD FindNthNode(NodeD root, int k) {
        if (root == null || root.descendantsCount < k)
            return null;
        
        return FindNthNodeHelper(root, k);
    }
    
    private static NodeD FindNthNodeHelper(NodeD root, int k) {
        int leftSideCount = root.left==null ? 0 : root.left.descendantsCount+1;
        
        if (k <= leftSideCount)
            return FindNthNodeHelper(root.left, k);
        else if (k == leftSideCount + 1)
            return root;
        else
            return FindNthNodeHelper(root.right, k-(leftSideCount+1));
    }
    
    public static void main(String[] args) {
        NodeD root = new NodeD('e',8);
        root.left = new NodeD('b', 3);
        root.left.left = new NodeD('a',0);
        root.left.right = new NodeD('d',1);
        root.left.right.left = new NodeD('c',0);
        root.right = new NodeD('f',3);
        root.right.right = new NodeD('g',2);
        root.right.right.right = new NodeD('h',1);
        root.right.right.right.right = new NodeD('i',0);
        
        NodeD NthNode = FindNthNode(root, 1);
        System.out.println("1st Node " + NthNode==null? "null" : NthNode.val);
        NthNode = FindNthNode(root, 1);
        System.out.println(NthNode==null? "null" : NthNode.val);
        NthNode = FindNthNode(root, 2);
        System.out.println(NthNode==null? "null" : NthNode.val);
        NthNode = FindNthNode(root, 3);
        System.out.println(NthNode==null? "null" : NthNode.val);
        NthNode = FindNthNode(root, 4);
        System.out.println(NthNode==null? "null" : NthNode.val);
        
        NthNode = FindNthNode(root, 10);
        System.out.println(NthNode==null? "null" : NthNode.val);
        
        NthNode = FindNthNode(root, 9);
        System.out.println(NthNode==null? "null" : NthNode.val);
        
        NthNode = FindNthNode(root, 8);
        System.out.println(NthNode==null? "null" : NthNode.val);
        
        NthNode = findNthNodeOrderOfNode(root, 8);
        System.out.println(NthNode==null? "null" : NthNode.val);
        NthNode = findNthNodeOrderOfNode(root, 5);
        System.out.println(NthNode==null? "null" : NthNode.val);
        NthNode = findNthNodeOrderOfNode(root, 2);
        System.out.println(NthNode==null? "null" : NthNode.val);
        
    }
    
    
    //inOrder Traversal
    //Time Complexity: O(n) where n is number of nodes
    public static NodeD findNthNodeOrderOfNode(NodeD root, int k){
        if (root == null || root.descendantsCount < k)
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
