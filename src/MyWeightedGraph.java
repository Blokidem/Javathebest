import java.util.*;

public class MyWeightedGraph<T> {
    private final boolean undirected;
    private Map<T, Vertex<T>> map = new HashMap<>();

    public MyWeightedGraph() {
        this.undirected = true;
    }

    public MyWeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(T v) {
        map.put(v, new Vertex<T>(v));
    }

    public void addEdge(T source, T dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).addVertex((Vertex<T>) dest, weight);

        if (undirected)
            map.get(dest).addVertex((Vertex<T>) source, weight);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).sizeAdjVertex();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(T v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(T source, T dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).isVertex(dest);
    }

    public Iterable<T> adjacencyList(T v) {
        if (!hasVertex(v)) return null;
        Vertex<T> vertices = map.get(v);
        return vertices.getVert();
    }

    public Iterable<Vertex<T>> getVertex(T v) {
        if (!hasVertex(v)) return null;
        return map.get(v);
    }
}
