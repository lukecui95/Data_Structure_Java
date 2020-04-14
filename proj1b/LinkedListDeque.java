public class LinkedListDeque <T> implements Deque <T> {
    private Node sentinel;
    private int size;

    public class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node (T t, Node p, Node n) {
            item = t;
            prev = p;
            next = n;

        }
    }

    /** Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new Node(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

    }

    public LinkedListDeque(LinkedListDeque other){
        sentinel = new Node(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

        for (int i = 0; i<other.size(); i++) {
            addLast((T) other.get(i));
        }

    }

    @Override
    public void addFirst(T item) {
        Node N = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = N;
        sentinel.next = N;
        size+=1;

    }

    @Override
    public void addLast(T item) {
        Node N = new Node(item,sentinel.prev,sentinel);
        sentinel.prev.next = N;
        sentinel.prev = N;
        size += 1;

    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public void printDeque() {
        if (isEmpty()) return;

        Node first = sentinel.next;

        for (int i = 0; i<size; i++){
            System.out.print(first.item + " ");
            first = first.next;
        }
        System.out.println();

    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;

        T res = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size-=1;

        return res;

    }


    @Override
    public T removeLast() {
        if (size == 0) return null;

        T res = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;

        return res;

    }

    @Override
    public T get(int index) {
        if (size < index+1) return null;

        Node res = sentinel.next;

        for (int i=0; i<index; i++){
            res = res.next;
        }

        return res.item;

    }

    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next,index);

    }

    public T getRecursiveHelper(Node first, int index) {
        if (index == 0) {
            return first.item;
        } else {
            first = first.next;
            return getRecursiveHelper(first, index-1);
        }
    }




}
