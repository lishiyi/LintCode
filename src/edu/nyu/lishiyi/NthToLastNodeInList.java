Nth to Last Node in List

43% Accepted
Find the nth to last element of a singly linked list. 

The minimum number of nodes in list is n.

Have you met this question in a real interview? Yes
Example
Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.

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
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if(head == null || n <= 0){

        	return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        for(int i = 0; i < n; i++){

        	fast = fast.next;
        }

        while(fast != null){

        	fast = fast.next;
        	slow = slow.next;
        }

        return slow;
    }
}