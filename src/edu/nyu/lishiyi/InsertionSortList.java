Insertion Sort List

31% Accepted
Sort a linked list using insertion sort.

Have you met this question in a real interview? Yes
Example
Given 1->3->2->0->null, return 0->1->2->3->null.

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
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if(head == null || head.next == null){

        	return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while(head != null){

        	int headVal = dummy.next.val;
        	ListNode current = dummy;

        }
    }
}
