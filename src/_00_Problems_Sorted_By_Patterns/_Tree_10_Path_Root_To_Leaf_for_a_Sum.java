/* [  _Tree_10_ ] [Path_Root_To_Leaf_for_a_Sum ]
_______________________________________________________________________________
                1
        ┌───────┴───────┐
        2               4
    ┌───┴───┐       ┌───┴───┐
    3       7       5       9
  ┌─┴─┐
 10   4
[[1, 2, 3, 4], [1, 2, 7], [1, 4, 5]]
*/
package _00_Problems_Sorted_By_Patterns;
import java.util.ArrayList;
import java.util.List;

public class _Tree_10_Path_Root_To_Leaf_for_a_Sum {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, res, path);
        return res;
    }

    private static void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        //base
        if(root==null) return;
        path.add(root.value);

        //if we have leaf node and leaf value is remaining sum required
        if(root.left==null && root.right==null){
            if(root.value==sum) { //last node value
                res.add(new ArrayList<>(path));
            }
        }

        //go all the way lest until its null
        if(root.left!= null){
            dfs(root.left, sum-root.value, res, path);
            //at this point we either found the pathSum or looking for different path
            // remove the last node from path and go one above and rightSide
            path.remove(path.size()-1);
        }
        //all the way right
        if(root.right!=null){
            dfs(root.right, sum- root.value, res, path);
            //at this point we either found the pathSum or looking for different path
            // remove the last node from path and go one above and rightSide
            path.remove(path.size()-1);
        }
    }
    public static void main(String args[]) {
        int[] nodes = new int[]{1, 2, 4, 3, 7, 5, 9, 10, 4};
        TreeNode p = TreeHelper.create(nodes);
        System.out.println(pathSum(p, 10));
    }


}
