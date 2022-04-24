import java.util.ArrayList;

public class MyStack <T extends Comparable<T>>{
    private ArrayList<T> stack;

    public MyStack(){
        stack = new ArrayList<T>();
    }

    public boolean empty(){
        if (this.size() == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return stack.size();
    }

    public T peek(){
        return stack.get(size() - 1);
    }

    public T push(T newItem){
        stack.add(newItem);
        return newItem;
    }

    public T pop(){
        return stack.remove(size() - 1);
    }
}
