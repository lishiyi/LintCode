Convert Sorted List to Binary Search Tree

27% Accepted
Given a singly linked list where elements are sorted in ascending order, convert it to a 
height balanced BST.

Have you met this question in a real interview? Yes
Example
               2
1->2->3  =>   / \
             1   3

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
     * @param head: The first node of linked list.
     * @return: a tree node
     */

    private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        if(head == null){

        	return null;
        }
        current = head;
        int size = findSize(head);

        return sortedListToBSTHelper(size);

    }

    private int findSize(ListNode head){

    	int size = 0;

    	while(head != null){

    		size ++;
    		head = head.next;
    	}

    	return size;
    }

    private TreeNode sortedListToBSTHelper(int size){

    	if(size <= 0){

    		return null;
    	}

    	TreeNode left = sortedListToBSTHelper(size / 2);
    	TreeNode root = new TreeNode(current.val);
    	current = current.next;
    	TreeNode right = sortedListToBSTHelper(size - 1 - size / 2 );

    	root.left = left;
    	root.right = right;

    	return root;
    }

}