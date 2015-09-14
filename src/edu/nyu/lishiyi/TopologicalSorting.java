Topological Sorting

25% Accepted
Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

Have you met this question in a real interview? Yes
Example
For graph as follow:

picture

The topological order can be:

[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
...
Note
You can assume that there is at least one topological order in the graph.

Challenge
Can you do it in both BFS and DFS?

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here

        //1. Create a result array
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        //2. Create a map for each node in the graph: <Node, incount>
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        //3. Iterate each node
        for(DirectedGraphNode n : graph){
            //4. Iterate each neighbor of the node
        	for(DirectedGraphNode neighbor : n.neighbors){
                //5. If it is already in the map. Make its incount + 1
        		if(map.containsKey(neighbor)){

        			map.put(neighbor, map.get(neighbor) + 1);
        		}
                //6. If it is not in the map, Set its incount to 1.
        		else{

        			map.put(neighbor, 1);
        		}
        	}
        }
        //7. Create a new queue saving the nodes have incount 0. (That is, the first nodes we need to do) 
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        //8. Find all the nodes have incount 0, and put them into the queue(and result).
        for(DirectedGraphNode n : graph){

        	if(!map.containsKey(n)){

        		queue.add(n);
        		result.add(n);
        	}
        }
        //9. While there is a node in the queue
        while(!queue.isEmpty()){
            //10. Poll the head node.(Delete the node)
        	DirectedGraphNode n = queue.poll();
            //11. Iterate each neighbor of the node.
        	for(DirectedGraphNode neighbor: n.neighbors){
                //12. Because the node is deleted, all of its neighbors' incount - 1
        		map.put(neighbor, map.get(neighbor) - 1);
                //13 .If the neighbor become 0-incount, put it into the queue
        		if(map.get(neighbor) == 0){

        			queue.add(neighbor);
        			result.add(neighbor);
        		}
        	}
        }

        return result;
    }
}
