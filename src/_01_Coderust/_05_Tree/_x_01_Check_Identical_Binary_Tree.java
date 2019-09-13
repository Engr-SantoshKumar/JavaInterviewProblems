package _01_Coderust._05_Tree;
/*
Two trees 'A' and 'B' are identical if:

1. data on their roots is the same or both roots are null
2. left sub-tree of 'A' is identical to the left sub-tree of 'B'
3. right sub-tree of 'A' is identical to the right sub-tree of 'B'

if 1, 2 and 3 are true, tree is identical
*/


public class _x_01_Check_Identical_Binary_Tree {


    public static boolean identicalTrees(Node rootOne, Node rootTwo ){

        /* breaking cond: both empty  */
        if(rootOne == null && rootTwo == null){
            System.out.println("In brak condition");
            return true;
        }


        /* 2. both non-empty -> compare them */
        if(rootOne!=null && rootTwo!=null){
            return(rootOne.data == rootTwo.data)
                    && identicalTrees(rootOne.left, rootTwo.left)// calling the identicalTree again with rootOne.left and rootTwo.right together
                    && identicalTrees(rootOne.right, rootTwo.right);

        }

        /* 3. One empty, one not --> return false */
        return false;
  }



    public static void main(String[] args) {
        // to create Binary Tree use below array
        //Node root = TreePrint.create(new int[]{50,30,20,40,70,60,80, 90, 5});
        //to create BST use below array
        Node r0 = TreePrint.create(new int[]{6,4,8,2,5,7,9,1,3});
        Node r2 = TreePrint.create(new int[]{6,4,8,2,5,7,9,1,3});
        //Node r1 = TreePrint.create(new int[]{10,5,20,3,8,15,50,1,4,6,9});

        /*      to create un-balanced tree
		Node root = new Node(5);
		root.left = new Node(6);
		root.right = new Node(7);
		root.right.right = new Node(7);
		root.right.right.right = new Node(8);
		TreePrint.print(root);  */
        System.out.println("Is Above trees are Identical:");
        System.out.println(identicalTrees(r0,r2));

        Node r3 = TreePrint.create(new int[]{6,4,8,2,5,7,9,1,3});
        Node r4 = TreePrint.create(new int[]{6,4,8,2,5,7,9,1,3,10,12});
        System.out.println("Is Above trees are Identical:");
        System.out.println(identicalTrees(r3,r4));

    }


}
