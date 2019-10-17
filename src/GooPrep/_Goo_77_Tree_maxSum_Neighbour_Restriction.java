/**
 * [ Goo 77 ] [ Maximum sum of nodes in Binary tree such that no two are adjacent]
 * --------------------------------------------------------------------------------------------------------------
 * PROBLEM STATEMENT:
 Given a binary tree with a value associated with each node, we need to choose a subset of these nodes
 such that sum of chosen nodes is maximum under a constraint that no two chosen node in subset should be
 directly connected that is,  if we have taken a node in our sum then we can’t take its any
 children in consideration and vice versa.

 Input Tree
         1
     ┌───┴───┐
    2       3                ---> if we chose 2 + 5 + 6 = 13 this is max sum
  ┌─┴─┐    ┌─┴─┐
  1   0    4   5

 Logic to solve:
 Return a pair for each node in the binary tree such that first of the pair indicates maximum sum when
 the data of node is included and second indicates maximum sum when the data of a particular node is not included.

 */
package GooPrep;

public class _Goo_77_Tree_maxSum_Neighbour_Restriction {

    public static NodeSumPairs sumOfNodesWithoutNeighbours(Node root){

        if(root == null){
            NodeSumPairs currentSum = new NodeSumPairs(0, 0);
            return currentSum;
        }

        NodeSumPairs leftNodePairs = sumOfNodesWithoutNeighbours(root.left);
        NodeSumPairs rightNodePairs = sumOfNodesWithoutNeighbours(root.right);

        NodeSumPairs finalSumPairs = new NodeSumPairs(0, 0);

        // Left and right children are not included
        finalSumPairs.sumWithRoot = leftNodePairs.sumWithOutRoot + rightNodePairs.sumWithOutRoot + root.data;

        // root not include, so if we are not including root what to add to make it max
        finalSumPairs.sumWithOutRoot = Math.max(leftNodePairs.sumWithOutRoot, leftNodePairs.sumWithRoot)
                                        +
                                        Math.max(rightNodePairs.sumWithRoot, rightNodePairs.sumWithOutRoot);

        return finalSumPairs;

    }

    public static void main(String args[]) {

        int[] nodes = new int[]{1, 2, 3, 1, 0, 5, 6};
        Node r = TreePrint.create(nodes);
        NodeSumPairs p = sumOfNodesWithoutNeighbours(r);

        System.out.println(Math.max(p.sumWithOutRoot, p.sumWithRoot));
    }


    static class NodeSumPairs{
        int sumWithRoot, sumWithOutRoot;
        public NodeSumPairs(int sumWithRoot, int sumWithOutRoot){
            this.sumWithRoot = sumWithRoot;
            this.sumWithOutRoot = sumWithOutRoot;
        }
    }

}
