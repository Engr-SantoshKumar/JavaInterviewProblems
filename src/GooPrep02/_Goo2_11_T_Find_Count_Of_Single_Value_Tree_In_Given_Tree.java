/** [ Goo2_11_Tree ] [ Single Value Tree ]
____________________________________________________________________________________________________________________
 Given a binary tree, find the number of unival subtrees (the unival tree is a tree which has the same
 value for every node in it).
             5
         ┌───┴───┐
         5       5
       ┌─┴─┐   ┌─┴─┐
      5    5   4   5

 There are 7 nodes i.e. 7 subtrees. Left subtree has 3 nodes and all nodes values are identical.
 So, there is 3 single value tree in the left subtree of the given tree. Right subtree has also 3 nodes.
 But all values are not identical. There are two leaves. So, 2 single value tree in the right subtree.
 As right subtree is not a single value tee, the whole tree is not a single value tree either.
 */
package GooPrep02;
public class _Goo2_11_T_Find_Count_Of_Single_Value_Tree_In_Given_Tree {

    // passing count variable to findSubTree is bit complex, so better to create a global variable
    static int count =0;

    public static int countSingleValueSubTrees(Node root){
        findSubTree(root);
        return count;
    }

    public static boolean findSubTree(Node root){
        if(root == null){
            return true;
        }

        boolean leftNode = findSubTree(root.left);
        boolean rightNode = findSubTree(root.right);

        //check first all the negative cases
        if(leftNode == false || rightNode == false) return false;
        if(root.left!=null && root.data != root.left.data) return false;
        if(root.right!=null && root.data != root.right.data) return false;
        //one all false cases satisfy, increase counter and return true
        count++;
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 5, 5, 5, 5, 4, 5};
        Node root = TreeHelper.create(arr);
        System.out.println("\n No of UniVal trees in above tree: " + countSingleValueSubTrees(root));

    }
}
