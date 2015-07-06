/*
Binary Tree Zigzag Level Order Traversal

27% Accepted
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

Have you met this question in a real interview? Yes
Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
*/

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        //Crearte a new ArrayList without <>.
        ArrayList result = new ArrayList();

        if(root == null){

        	return result;
        }
        //Queue is Abstact, so we new a LinkedList here.
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);
        //A flag to control the Zig-Zag 
        boolean reverse = false;

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
        	//If latest one is -->, this time, reverse it! <--
        	if(reverse == true){

        		Collections.reverse(level);
        		reverse = false;
        	//If latest one is <--, this time, do not reverse.
        	}
        	else{

        		reverse = true;
        	}

        	result.add(level);
        }

        return result;
    }
}
