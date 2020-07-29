package graphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    private T val;
    private List<Vertex<T>> child;

    public List<Vertex<T>> getChildren() {
        return this.child;
    }

    public void addChild(Vertex<T> vertex) {
        if(child == null)
            child = new ArrayList<>();
        child.add(vertex);
    }
}
