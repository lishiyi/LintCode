Linked List Cycle II

36% Accepted
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Have you met this question in a real interview? Yes
Example
Given -21->10->4->5, tail connects to node index 1，返回10

Challenge
Follow up:
Can you solve it without using extra space?

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
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        // write your code here

        if(head == null || head.next == null){

        	return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){

        	fast = fast.next.next;
        	slow = slow.next;

        	if(fast == slow){

        		break;
        	}
        }

        if(fast == null || fast.next == null){

        	return null;
        }

        slow = head;

        while(slow != fast){

        	fast = fast.next;
        	slow = slow.next;
        }

        return slow;
    }
}