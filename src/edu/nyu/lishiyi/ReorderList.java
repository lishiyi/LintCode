/*
Reorder List

23% Accepted
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.



Have you met this question in a real interview? Yes
Example
For example,
Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
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
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // write your code here
        if(head == null || head.next == null){

        	return;
        }

        ListNode mid = findMiddle(head);
        ListNode dummy = mid.next;
        mid.next = null;
        ListNode newHead = reverse(dummy);

        merge(head, newHead);
    }

    private ListNode findMiddle(ListNode head){

    	if(head == null || head.next == null){

    		return head;
    	}

    	ListNode fast = head.next;
    	ListNode slow = head;

    	while(fast != null && fast.next != null){

    		fast = fast.next.next;
    		slow = slow.next;
    	}

    	return slow;
    }

    private ListNode reverse(ListNode head){

    	if(head == null || head.next == null){

    		return head;
    	}

    	ListNode prev = null;
    	ListNode current = head;

    	while(current != null){

    		ListNode next = current.next;
    		current.next = prev;
    		prev = current;
    		current = next;
    	}

    	return prev;
    }

    private ListNode merge(ListNode left, ListNode right){

    	if(left == null){

    		return right;
    	}
    	else if(right == null){

    		return left;
    	}

    	ListNode dummy = new ListNode(0);
    	ListNode current = dummy;
    	boolean chooseLeft = true;

    	while(left != null && right != null){

    		if(chooseLeft == true){

    			current.next = left;
    			left = left.next;
    			chooseLeft = !chooseLeft;
    		}
    		else{

    			current.next = right;
    			right = right.next;
    			chooseLeft = !chooseLeft; 
    		}

    		current = current.next;
    	}

    	if(left == null){

    		current.next = right;
    	}
    	else{

    		current.next = left;
    	}

    	return dummy.next;
    }
}
