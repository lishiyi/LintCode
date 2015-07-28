Copy List with Random Pointer

27% Accepted
A linked list is given such that each node contains an additional random pointer which 
could point to any node in the list or null.

Return a deep copy of the list.

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head == null){

        	return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }

    private void copyNext(RandomListNode head){

    	while(head != null){

    		RandomListNode copy = new RandomListNode(head.label);
    		copy.next = head.next;
    		copy.random = head.random;
    		head.next = copy;
    		head = copy.next;
    	}
    }

    private void copyRandom(RandomListNode head){

    	while(head != null){

    		RandomListNode copy = head.next;
    		if(copy.random != null){

    			copy.random = copy.random.next;
    		}
    		head = head.next.next;
    	}
    }

    private RandomListNode splitList(RandomListNode head){

    	if(head == null){

    		return null;
    	}

    	RandomListNode dummy = new RandomListNode(0);
    	dummy.next = head.next;

    	while(head != null){

    		RandomListNode copy = head.next;
    		if(copy.next == null){

    			break;
    		}
    		else{

    			head = copy.next;
    			copy.next = copy.next.next;
    		}
    		
    	}

    	return dummy.next;
    }
}
