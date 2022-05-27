import java.util.*;

public class Vertex<T> {
    private T data;
    private HashMap<Vertex<T>, Double> adjVertices;

    public Vertex(T data){
        this.adjVertices = new HashMap<>();
    }

    public void addVertex(Vertex<T> dest, double weight){
        adjVertices.put(dest, weight);
    }

    public boolean isVertex(T v){
        return adjVertices.containsKey(v);
    }

    public void setData(T data){
        this.data = data;
    }

    public int sizeAdjVertex(){
        return adjVertices.size();
    }

    public Iterable<T> getVert(){
        LinkedList<T> ver = new LinkedList<>();
        for(Vertex<T> vertex: adjVertices.keySet()){
            ver.addFirst((T)vertex);
        }
        return ver;
    }

    public Double getWeight(T vertex){
        return adjVertices.get(vertex);
    }
}
