/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        HashMap<Integer, UndirectedGraphNode> visited = new HashMap<Integer, UndirectedGraphNode>();
        visited.put(node.label, root);
        dfsClone(node, root, visited);
        
        return root;
    }
    
    private void dfsClone(UndirectedGraphNode node, UndirectedGraphNode copy, HashMap<Integer, UndirectedGraphNode> visited) {
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (!visited.containsKey(neighbor.label)) {
                UndirectedGraphNode copyNeighbor = new UndirectedGraphNode(neighbor.label);
                copy.neighbors.add(copyNeighbor);
                visited.put(neighbor.label, copyNeighbor);
                dfsClone(neighbor, copyNeighbor, visited);
            } else {
                copy.neighbors.add(visited.get(neighbor.label));
            }
        }
    }
}
