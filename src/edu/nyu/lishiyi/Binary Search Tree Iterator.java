Binary Search Tree Iterator

29% Accepted
Design an iterator over a binary search tree with the following rules:

Elements are visited in ascending order (i.e. an in-order traversal)
next() and hasNext() queries run in O(1) time in average.
Have you met this question in a real interview? Yes
Example
For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]

   10
 /    \
1      11
 \       \
  6       12
Challenge
Extra memory usage O(h), h is the height of the tree.

Super Star: Extra memory usage O(1)

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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    //@param root: The root of binary tree.
	private Stack<TreeNode> stack = new Stack();
	private TreeNode current;

    public BSTIterator(TreeNode root) {
        // write your code here
        current = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return current!= null || !stack.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
    	while(current.left != null){
    		stack.push(current.left);
    		current = current.left;
    	}

    	current = stack.pop();
    	TreeNode node = current;
    	current = current.right;
    	return node;
    }
}