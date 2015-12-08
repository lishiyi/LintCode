Clone Graph

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's' undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/

 /**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node == null){
        	return null;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
        map.put(node, new UndirectedGraphNode(node.label));

        while(!queue.isEmpty()){

        	UndirectedGraphNode head = queue.poll();
        	for(UndirectedGraphNode neighbor : head.neighbors){
        		if(!map.containsKey(neighbor)){
        			queue.add(neighbor);
        			map.put(neighbor, new UndirectedGraphNode(neighbor.label));
        		}
        	}
        }

        for(UndirectedGraphNode oldNode : map.keySet()){

        	UndirectedGraphNode newNode = map.get(oldNode);
        	for(UndirectedGraphNode neighbor : oldNode.neighbors){
        		newNode.neighbors.add(map.get(neighbor));
        	}
        }

        return map.get(node);
    }
}