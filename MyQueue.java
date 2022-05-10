import java.util.Iterator;
import java.util.LinkedList;

public class MyQueue <T extends Comparable <T>> implements Iterable<T>{
    private LinkedList<T> queueNode;

    public MyQueue(){
        queueNode = new LinkedList<T>();
    }
    public boolean empty(){
        return queueNode.size() == 0;
    }
    public int size(){
        return queueNode.size();
    }
    public T peek(){
        return queueNode.get(0);
    }
    public T enqueue(T newItem){
        queueNode.add(newItem);
        return newItem;
    }
    public T dequeue(){
        return queueNode.remove(0);
    }

    @Override
    public Iterator<T> iterator(){
        return null;
    }
}