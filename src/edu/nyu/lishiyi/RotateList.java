/*
Rotate List

27% Accepted
Given a list, rotate the list to the right by k places, where k is non-negative.

Have you met this question in a real interview? Yes
Example
Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.
*/


/**
 * Definition for singly-linked list.
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if(head == null || head.next == null || k == 0){

        	return head;
        }

        int length = 0;
        ListNode pointer = head;
        while(pointer != null){

        	length += 1;
        	if(pointer.next == null){

        		pointer.next = head;
        		break;
        	}
        	pointer = pointer.next;
        }

        if(k % length == 0){

        	return head;
        }

        for(int i = 0; i < (length - k) % length - 1; i++){

        	head = head.next;
        }

        ListNode newHead = head.next;
        head.next = null;

        return newHead;
    }
}
