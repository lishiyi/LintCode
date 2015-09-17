Word Ladder

22% Accepted
Given two words (start and end), and a dictionary, 
find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
Have you met this question in a real interview? Yes
Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.


public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        //1. Create a queue for BFS, each level.
        Queue<String> queue = new LinkedList();
        //2. Add the start word first (that is first level).
        queue.add(start);
        //3. Add the end word to the dict.
        dict.add(end);
        //4. Step counter.
        int step = 0;

        while(!queue.isEmpty()){
        	//5. Create a queue for current level
        	Queue<String> level = new LinkedList();
        	//6. Set step +1
        	step ++;
        	//7. Iterate this level
        	while(!queue.isEmpty()){
        		//8. Take the current word out.
        		String str = queue.poll();
        		//9. If the word is same as end word, return.
        		if(str.equals(end)){
        			return step;
        		}
        		//10. Else, Make the (String)word be a char[]
        		char[] chars = str.toCharArray();
        		//11. Iterate each character of the char[]
        		for(int i = 0; i < chars.length; i++){
        			//12. Try to change this char to another char, from 'a' to 'z'
        			for(char c = 'a'; c <= 'z'; c++){
        				//13. Save current char for recovery
        				char temp = chars[i];
        				//14. Change it!
        				chars[i] = c;
        				//15. Make char[] beck to be a String
        				String newStr = new String(chars);
        				//16. If dict contains the new String, add this to this level queue,
        				//     and remove it from the dict(avoid next time, when we change
        				//      one char, it happens again) This is why we use STEP3,
        				//     when the dict contains the word, and it just the end word,
        				//     add it into the queue, so we can step++ and check it.
        				if(dict.contains(newStr)){

        					level.add(newStr);
        					dict.remove(newStr);
        				}
        				//17. Recover.
        				chars[i] = temp;
        			}
        		}
        	}
        	//18. Set queue to this level.
        	queue = level;
        }

        return 0;
    }
}
