/**
 * [ Goo2_14_T ] [ Binary Tree Paths ]
 * ____________________________________________________________________________________________________________________
 Input:
                        15
                 ┌───────┴───────┐
                10               8
            ┌───┴───┐       ┌───┴───┐
           2       4       6       7
         ┌─┘
        5
 Output: ["15->10->2->5", "15->10->3", "15->8->6", "15->8->7"]

 */
package PrepSetTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _Goo2_14_T_Path_Node_To_Root {

    public List<List<Integer>> findAllPaths(Node root){
        List<List<Integer>> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        pathFinder(root, result, stack);
        return result;
    }

    private void pathFinder(Node root, List<List<Integer>> resultList, Stack<Node> nodeStack){

        if(root == null) return;

        // add current node to stack
        nodeStack.add(root);
        // add currently travelled path
        if(root.left == null && root.right==null){
            storePath(resultList, nodeStack);
            nodeStack.pop();
            return;
        }
        pathFinder(root.left, resultList, nodeStack);
        pathFinder(root.right, resultList, nodeStack);
        nodeStack.pop();
    }

    private void storePath(List<List<Integer>> resultList, Stack<Node> currentPath){
        List<Integer> path = new ArrayList<>();
        for(int i =0; i < currentPath.size(); i++){
            path.add(currentPath.get(i).data);
        }
        resultList.add(path);
    }

    public static void main(String[] args) {
        _Goo2_14_T_Path_Node_To_Root graph = new _Goo2_14_T_Path_Node_To_Root();
        int[] arr = new int[]{15, 10, 8, 2, 4, 6, 7, 5};
        Node root = TreeHelper.create(arr);
        System.out.println(graph.findAllPaths(root));
    }

}
