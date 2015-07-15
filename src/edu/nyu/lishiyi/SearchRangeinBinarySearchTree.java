/*
Search Range in Binary Search Tree

37% Accepted
Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.

Have you met this question in a real interview? Yes
Example
If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].

    20
   /  \
  8   22
 / \
4   12
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
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    private ArrayList<Integer> result = new ArrayList<Integer>();

    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
    	helper(root, k1, k2);
    	//Collections.sort(result);
    	return result;
    }

    private void helper(TreeNode root, int k1, int k2){

    	if(root == null){

    		return;
    	}

    	if(root.val > k2){

    		helper(root.left, k1, k2);
    	}
    	else if(root.val >= k1 && root.val <= k2){

    		helper(root.left, k1, k2);
    		result.add(root.val);
    		helper(root.right, k1, k2);
    	}
    	else if(root.val < k1){

    		helper(root.right, k1, k2);
    	}
    }
}