Reverse Linked List II

28% Accepted
Reverse a linked list from position m to n.

Have you met this question in a real interview? Yes
Example
Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.

Note
Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if(head == null || head.next == null || m >= n){

        	return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        for(int i = 1; i < m; i++){

        	if(current.next == null){
        		return head;
        	}
        	current = current.next;
        }

        ListNode prevM = current;
        ListNode nodeM = current.next;
        ListNode prev = nodeM;

        //current = current.next;

        for(int i = m; i < n + 2; i++){

        	if(current == null){
        		return head;
        	}

        	ListNode next = current.next;
        	current.next = prev;
        	prev = current;
        	current = next;
        }

        ListNode nodeN = prev;
        ListNode postN = current;

        prevM.next = nodeN;
        nodeM.next = postN;

        return dummy.next;
    }
}