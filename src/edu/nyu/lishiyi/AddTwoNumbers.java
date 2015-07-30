/*
Add Two Numbers

22% Accepted
You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.

Have you met this question in a real interview? Yes
Example
Given 7->1->6 + 5->9->2. That is, 617 + 295.

Return 2->1->9. That is 912.

Given 3->1->5 and 5->9->2, return 8->0->8.
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null && l2 == null){

        	return null;
        }
        else if(l1 == null){

        	return l2;
        }
        else if(l2 == null){

        	return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while(l1 != null && l2 != null){

        	int sum = l1.val + l2.val + carry;
        	current.next = new ListNode(sum % 10);
        	carry = (sum >= 10) ? 1 : 0;
        	current = current.next;
        	l1 = l1.next;
        	l2 = l2.next;
        }

        while(l1 != null){

        	int sum = l1.val + carry;
        	current.next = new ListNode(sum % 10);
        	carry = (sum >= 10) ? 1 : 0;
        	current = current.next;
        	l1 = l1.next;
        }

        while(l2 != null){

        	int sum = l2.val + carry;
        	current.next = new ListNode(sum % 10);
        	carry = (sum >= 10) ? 1 : 0;
        	current = current.next;
        	l2 = l2.next;
        }

        if(carry != 0){

        	current.next = new ListNode(carry);
        	current = current.next;
        }

        return dummy.next;

    }
}
