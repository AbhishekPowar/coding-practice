package graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    private int data;
    private List<GraphNode> children = new ArrayList<>();

    public GraphNode(int data) {
        this.data = data;
    }
    public List<GraphNode> getChildren() {
        return this.children;
    }
    public int getData() {
        return this.data;
    }
    public void addDependency(GraphNode node) {
        this.children.add(node);
    }
}
