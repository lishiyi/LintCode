Merge k Sorted Lists

26% Accepted
Merge k sorted linked lists and return it as one sorted list.

Analyze and describe its complexity.

Have you met this question in a real interview? Yes
Example
Given lists:

[
  2->4->null,
  null,
  -1->null
],
return -1->2->4->null.

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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists == null || lists.size() == 0){
        	return null;
        }
        // Create  a comparator for the PriorityQueue
        Comparator<ListNode> c = new Comparator<ListNode>(){
        	@Override
        	public int compare(ListNode l1, ListNode l2){
        		return l1.val - l2.val;
        	}
        };
        //Create the heap  
        PriorityQueue<ListNode> heap = new PriorityQueue(lists.size(), c);
        //put each list's head into heap.
        for(ListNode list : lists){
        	if(list != null) heap.add(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(!heap.isEmpty()){
        	//Compare the heads in the heaf. Poll() the smallest one
        	current.next = heap.poll();
        	current = current.next;
        	//Lest the smallest's next be the new head in the heap.
        	if(current.next != null){
        		heap.add(current.next);
        	}
        }

        return dummy.next;
    }
}
