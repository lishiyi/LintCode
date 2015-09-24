LRU Cache

18% Accepted
Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before 
inserting a new item.

public class Solution {

	//1. Create a DounleLinkedList class.
	private class ListNode{

		int key;
		int value;
		ListNode prev;
		ListNode next;

		public ListNode(int key, int value){

			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}

	//2. Set the parameters
	private int capacity;
	//3. Create a HashMap for fast finding elements. O(1)
	private Map<Integer, ListNode> hashMap = new HashMap<Integer, ListNode>();
	//4. Create a head and a tail. Let the numbers in cache between them.
	private ListNode head = new ListNode(-1, -1);
	private ListNode tail = new ListNode(-1, -1);

    // @param capacity, an integer
    public Solution(int capacity) {
        // write your code here
        //5. Initialize
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        //6. If cannot find, return 0;
        if(!hashMap.containsKey(key)){

        	return -1;
        }
        //7. If these is, make it "Most Recently Used", then return the value.
        else{
        	ListNode node = hashMap.get(key);
        	//8. Delete its original location.
        	delete(node);
        	//9. Add it to tail, so that is "MRU"
        	addTail(node);
        	//10. Return the value.
        	return node.value;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here

        //11. If there is not, put it into the map, add it "MRU"
        if(!hashMap.containsKey(key)){

        	ListNode node = new ListNode(key, value);
        	hashMap.put(key, node);
        	addTail(node);
        	//12. If the size out of limit, delete "LRU", and delete it from the map
        	if(hashMap.size() > this.capacity){

        		ListNode least = head.next;
        		delete(least);
        		hashMap.remove(least.key); 
        	}
        }
        //13. If there is, update it "MRU"
        else{

        	ListNode node = hashMap.get(key);
        	node.value = value;
        	delete(node);
        	addTail(node);
        }
    }

    //14. Delete this node: cut off the connection   prev --\-- node --\-- next
    //    -->   prev ---- next, null ---- node ---- null
    private void delete(ListNode node){

    	ListNode next = node.next;
    	ListNode prev = node.prev;
    	prev.next = next;
    	next.prev = prev;
    	node.prev = null;
    	node.next = null;
    }
    //15. Add this node to tail, make it MRU.
    private void addTail(ListNode node){

    	ListNode prev = this.tail.prev;
    	prev.next = node;
    	node.prev = prev;
    	node.next = tail;
    	tail.prev = node;
    }
}