Delete Node in the Middle of Singly Linked List

35% Accepted
Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.

Have you met this question in a real interview? Yes
Example
Given 1->2->3->4, and node 3. return 1->2->4

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
 */ 
public class Solution {
    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
    	node.val = node.next.val;
    	node.next = node.next.next;
    }
}
