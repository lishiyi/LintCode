Remove Nth Node From End of List

29% Accepted
Given a linked list, remove the nth node from the end of list and return its head.

Have you met this question in a real interview? Yes
Example
Given linked list: 1->2->3->4->5->null, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5->null.
Note
The minimum number of nodes in list is n.

Challenge
O(n) time

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if(head == null || n <= 0){

        	return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i = 0; i < n; i++){

        	fast = fast.next;
        }

        while(fast != null && fast.next != null){

        	fast = fast.next;
        	slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}