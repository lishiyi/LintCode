/*
Binary Tree Maximum Path Sum

23% Accepted
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Have you met this question in a real interview? Yes
Example
Given the below binary tree:

  1
 / \
2   3
return 6.
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
public class BinaryTreeMaximumPathSum {

	private class ResultType{

		int singlePath;
		int maxPath;

		ResultType(int singlePath, int maxPath){
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}

	private ResultType helper(TreeNode root){

		if(root == null){

			return new ResultType(0, Integer.MIN_VALUE);
		}

		ResultType left = helper(root.left);
		ResultType right = helper(root.right);

		int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
		singlePath = Math.max(singlePath, 0);

		int maxPath = Math.max(left.maxPath, right.maxPath);
		maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

		return new ResultType(singlePath, maxPath); 
	}

    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
    	ResultType result = new ResultType(root);
    	return result.maxPath;
    }
}