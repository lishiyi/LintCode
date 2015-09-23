Max Tree

28% Accepted
Given an integer array with no duplicates. A max tree building on this array is defined as follow:

The root is the maximum number in the array
The left subtree and right subtree are the max trees of the subarray divided by the root number.
Construct the max tree by the given array.

Have you met this question in a real interview? Yes
Example
Given [2, 5, 6, 0, 3, 1], the max tree constructed by this array is:

    6
   / \
  5   3
 /   / \
2   0   1
Challenge
O(n) time and memory.

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
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
        	return null;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();

        for(int i = 0; i <= A.length; i++){

        	TreeNode right = (i == A.length) ? new TreeNode(Integer.MAX_VALUE) : new TreeNode(A[i]);

        	while(!stack.empty() && right.val >= stack.peek().val){

        		TreeNode current = stack.pop();
        		TreeNode left = stack.empty() ? new TreeNode(Integer.MAX_VALUE) : stack.peek();
        		if(right.val <= left.val){

        			right.left = current;
        		}
        		else{

        			left.right = current;
        		}
        	}
        	stack.push(right);
        }

        return stack.peek().left;
    }
}
