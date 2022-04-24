import java.util.ArrayList;

public class MyQueue <T extends Comparable <T>>{
    private ArrayList<T> queue;

    public boolean empty(){
        if (this.size() == 0){
            return true;
        }
        return false;
    }
    public int size(){
        return queue.size();
    }
    public T peek(){
        return queue.get(0);
    }
    public T enqueue(T newItem){
        queue.add(newItem);
        return newItem;
    }
    public T dequeue(){
        return queue.remove(0);
    }
}
