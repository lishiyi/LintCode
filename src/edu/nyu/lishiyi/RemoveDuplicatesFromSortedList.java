Remove Duplicates from Sorted List

39% Accepted
Given a sorted linked list, delete all duplicates such that each element appear only once.

Have you met this question in a real interview? Yes
Example
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

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
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here

        if(head == null){

        	return null;
        }

        ListNode current = head;

        while(current != null && current.next != null){

        	if(current.next.val == current.val){

        		current.next = current.next.next;
        	}
        	else{

        		current = current.next;
        	}

        }

        return head;
    }  
}
