/*
Merge Two Sorted Lists

38% Accepted
Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.

Have you met this question in a real interview? Yes
Example
Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
*/

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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null){

        	return l2;
        }
        else if(l2 == null){

        	return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(l1 != null && l2 != null){

        	if(l1.val < l2.val){

        		current.next = l1;
        		l1 = l1.next;
        	}
        	else{

        		current.next = l2;
        		l2 = l2.next;
        	}

        	current = current.next;
        }

        if(l1 == null){

        	current.next = l2;
        }
        else if(l2 == null){

        	current.next = l1;
        }

        return dummy.next;
    }
}
