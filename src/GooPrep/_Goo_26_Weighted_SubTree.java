/* 26  [Weighted Sub Tree weight of each node ]
 ---------------------------------------------------------------------------------------------------------
Input Tree
          5
      ┌───┴───┐
     -1       3
    ┌─┴─┐   ┌─┴─┐
   -2   4  -6  10

OutPut:
         13
      ┌───┴───┐
      1       7
    ┌─┴─┐   ┌─┴─┐
   -2   4  -6  10
   */
package GooPrep;


public class _Goo_26_Weighted_SubTree {

    static int converToWeightedTree(Node root) {
        if (root == null) {
            return 0;
        }
        //updating the node value with (root+left+Right)
        root.data = root.data + converToWeightedTree(root.left) + converToWeightedTree(root.right);
        return root.data;
    }

    static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        System.out.println(" weighted for node : "+root.data+" is  "
                +(root.data + sum(root.left) + sum(root.right)));
        return root.data + sum(root.left) + sum(root.right);
    }



    public static void main(String args[]) {

        int[] nodes = new int[]{5, -1, 3, -2, 4, -6, 10};
        Node r = TreePrint.create(nodes);

        // if we want to print the converted new weighted tree
        converToWeightedTree(r);
        System.out.println("\n\n\n*** weighted Tree is ****");
        TreePrint.print(r);

        // Printing the weight of each node
        System.out.println("Weighted Tree Root Node : " + sum(r));
    }

}
