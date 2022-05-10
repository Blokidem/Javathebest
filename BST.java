public class BST<K extends Comparable<K>, V> {
    private Node root, rad;

    private class Node{
        private K key;
        private V val;
        private Node left, right;
        private Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val){
        Node newNode = new Node(key, val);
        root = put(root, newNode);
    }

    private Node put(Node current, Node newNode){
        if(current == null) return newNode;
        if(newNode.key.compareTo(current.key)>0){
            current.right = put(current.right, newNode);
        }
        else if(newNode.key.compareTo(current.key)<0){
            current.left = put(current.left, newNode);
        }
        return current;
    }

    public V get(K key){
        Node instant = root;
        return get(instant, key);
    }

    private V get(Node current, K key){
        if(current == null) return null;
        if(key.compareTo(current.key)>0){
            return get(current.right, key);
        }
        else if(key.compareTo(current.key)<0){
            return get(current.left, key);
        }
        return current.val;
    }

    public void delete(K key){
        Node flow = root;
        flow = extract(flow, key);
        if(flow == null || (flow.right == null && flow.left == null)){
            return;
        }
        if(flow.left == null){
            rad.right = flow.right;
        }
        else if(flow.right == null){
            rad.left = flow.left;
        }
        else {
            Node minNode = findMinElement(flow.right);
            if (rad != null) {
                rad.left = minNode.right;
            }
            else {
                flow.right = minNode.right;
            }
            flow.val = minNode.val;
            flow.key = minNode.key;
        }
    }

  private Node findMinElement(Node node) {
        if (node.left == null) return node;
        rad = node;

        return findMinElement(node.left);
  }

    private Node extract(Node current, K key){
        if (current == null) return null;
        rad = current;
        if(key.compareTo(current.key)>0){
            return extract(current.right, key);
        }
        else if(key.compareTo(current.key)<0){
            return extract(current.left, key);
        }
        return current;
    }

    public Iterable<K> iterator(){
        MyQueue<K> q = new MyQueue<K>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node current, MyQueue<K> q){
        if (current == null) return;
        inorder(current.left, q);
        q.enqueue(current.key);
        inorder(current.right, q);
    }

    public static void main(String[] args) {
    }
}