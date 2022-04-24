import java.util.ArrayList;

public class MyHeap<T extends Comparable<T>> {
    private ArrayList<T> store;

    public MyHeap() {
        store = new ArrayList<>();
    }

    private void heapify(int position) {
        int most = position;
        int left = leftChild(position);
        int right = rightChild(position);
        if (left < size() && store.get(left).compareTo(store.get(most))>0)
            most = left;
        if (right < size() && store.get(right).compareTo(store.get(most))>0)
            most = right;

        if (most != position) {
            T temp = store.get(most);
            store.set(most, store.get(position));
            store.set(position, temp);

            heapify(most);
        }
    }

    private int leftChild(int index) {
        return (2*index) +1;
    }

    private int rightChild(int index) {
        return (2*index)+2;
    }

    public void add(T object) {
        if (size() == 0) {
            store.add(object);
        } else {
            store.add(object);
            for (int i = size() / 2 - 1; i >= 0; i--) {
                heapify(i);
            }
        }
    }

    public void printAll(){
        for (int i=0;i<size();i++) {
            System.out.println(" " + store.get(i));
        }
    }

    public void remove(T object)
    {
        int index=0;
        for (int i = 0; i < size(); i++)
        {
            if (object.equals(store.get(i)))
                break;
            index++;
        }

        T temp = store.get(index);
        store.set(index, store.get(size()-1));
        store.set(size()-1, temp);

        store.remove(size()-1);
        for (int i = size() / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public T removeRoot() {
        T remove = store.get(0);

        store.set(0, store.get(size()-1));
        store.set(size()-1, remove);

        store.remove(size()-1);
        for (int i = size() / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
        return remove;
    }

    public int size() {
        return store.size();
    }

    public static void main(String[] args) {
        MyHeap<Integer> heap = new MyHeap<>();

        heap.add(777);
        heap.add(300);
        heap.add(370);
        heap.add(800);
        heap.add(75);
        heap.add(350);

        heap.printAll();
    }
}


