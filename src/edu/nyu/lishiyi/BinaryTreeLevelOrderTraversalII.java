/*
Binary Tree Level Order Traversal II

41% Accepted
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

Have you met this question in a real interview? Yes
Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]

*/

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList result = new ArrayList();
        
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);

        while(!queue.isEmpty()){

        	ArrayList<Integer> level = new ArrayList<Integer>();
        	int size = queue.size();

        	for(int i = 0; i < size; i++){

        		TreeNode head = queue.poll();
        		level.add(head.val);

        		if(head.left != null){

        			queue.offer(head.left);
        		}
        		if(head.right != null){

        			queue.offer(head.right);
        		}
        	}

        	result.add(level);
        }

        Collection.reverse(result);
        return result;
    }
}