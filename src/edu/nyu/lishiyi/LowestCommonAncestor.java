/*
Lowest Common Ancestor

34% Accepted
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

Have you met this question in a real interview? Yes
Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7
*/

public class LowestCommonAncestor {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // if this is a leaf, or this node is just what we need, return it.
        if(root == null || root == A || root == B){

        	return root;
        }

        //devide
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        //conquer
        //If left has A(or B), right has B(or A), return this root.
        //It will be the final result, because other branches do not have A or B, they will return null.
        if(left != null && right != null){

        	return root;
        }
        //If only one side(left) has A(and/or B), return this root.
        //It may be the final result, when A and B are all in left side, if this contains
        //the 2 nodes, the final result is the higher one, because other branches do not have A or B.
        if(left != null){

        	return left;
        }
        if(right != null){

        	return right;
        }

        return null;
    }
}
