package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    final private List<GraphNode> nodes = new ArrayList<>();
    final private Map<Integer, GraphNode> map = new HashMap<>();

    public List<GraphNode> getNodes() {
        return this.nodes;
    }

    public GraphNode getOrCreateNode(int data) {
        if(!map.containsKey(data)) {
            GraphNode graphNode = new GraphNode(data);
            map.put(data, graphNode);
            nodes.add(graphNode);
        }
        return map.get(data);
    }

    public void addEdge(int start, int end) {
        GraphNode startNode = getOrCreateNode(start);
        GraphNode endNode = getOrCreateNode(end);
        startNode.addDependency(endNode);
    }
}
