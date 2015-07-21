Sort List

27% Accepted
Sort a linked list in O(n log n) time using constant space complexity.

Have you met this question in a real interview? Yes
Example
Given 1-3->2->null, sort it to 1->2->3->null.

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
     * @return: You should return the head of the sorted linked list,
     *              using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
    	if(head == null || head.next ==null){

    		return head;
    	}

    	ListNode mid = findMiddle(head);

    	ListNode right = sortList(mid.next);
    	mid.next = null;
    	ListNode left = sortList(head);

    	return merge(left, right);
    }

    private ListNode findMiddle(ListNode head){

    	if(head == null || head.next == null){

    		return head;
    	}

    	ListNode slow = head;
    	ListNode fast = head.next;

    	while(fast != null && fast.next != null){

    		slow = slow.next;
    		fast = fast.next.next;
    	}

    	return slow;
    }

    private ListNode merge(ListNode left, ListNode right){

    	if(left == null){

    		return right;
    	}
    	else if (right == null) {
    		
    		return left;
    	}

    	ListNode dummy = new ListNode(0);
    	ListNode current = dummy; 

    	while(left != null && right != null){

    		if(left.val < right.val){

    			current.next = left;
    			left = left.next;
    		}
    		else{

    			current.next = right;
    			right = right.next;
    		}

    		current = current.next;
    	}

    	if(right == null){

    		current.next = left;
    	}
    	else{

    		current.next = right;
    	}

    	return dummy.next;
    }
}