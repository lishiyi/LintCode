/*
Binary Tree Preorder Traversal

Given a binary tree, return the preorder traversal of its nodes' values.

Example
Given binary tree {1,#,2,3}:

1
 \
  2
 /
3
return [1,2,3].

Challenge
Can you do it without recursion?
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class BinaryTreePreorderTraversal2 {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(root == null){

          return result;
        }

        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right =  preorderTraversal(root.right);

        result.add(root.val);
        result.addAll(left);
        result.addAll(right);

        return result;
    }

}