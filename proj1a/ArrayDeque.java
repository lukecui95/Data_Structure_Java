public class ArrayDeque <T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private static int CAPACITY = 8;
    private static int REFACTOR = 2;

    public ArrayDeque(){
        items = (T[]) new Object[CAPACITY];
        size = 0 ;
        nextFirst = 0 ;
        nextLast = 1;

    }

    public ArrayDeque(ArrayDeque other) {
        T[] array = (T[]) new Object[CAPACITY];
        size = 0;
        nextFirst = 0 ;
        nextLast = 1;

        for (int i = 0; i<other.size(); i++) {
            addLast((T) other.get(i));
        }

    }

    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];

        int curr = (nextFirst + 1) % items.length;

        for(int i = 0; i<items.length ; i++){
            a[i] = items[curr];
            curr = (curr+1) % items.length;
        }

        items = a;

        nextFirst = capacity-1;
        nextLast = size;

    }

    public void addFirst(T item) {
        if (size== items.length) {
            resize(size*REFACTOR);
        }

        items[nextFirst] = item;
        size += 1;
        nextFirst = (nextFirst - 1) % items.length;

    }

    public void addLast(T item) {
        if (size== items.length) {
            resize(size*REFACTOR);
        }

        items[nextLast] = item;
        size += 1;
        nextLast = (nextLast + 1) % items.length;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int first = nextFirst+1;

        for (int i = 0; i<size; i++){
            System.out.print(items[first] + " ");
            first = (first + 1) % items.length;

        }
        System.out.println();

    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        nextFirst = (nextFirst + 1) % items.length;
        T res = items[nextFirst];
        items[nextLast] = null;
        size -= 1;

        return res;



    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        nextLast = (nextLast-1) % items.length;
        T res = items[nextLast];
        items[nextLast] = null;

        size -= 1;

        return res;

    }

    public T get(int index) {
        if (index >= size){
            return null;
        }

        return items[(nextFirst+1+index) % items.length ];

    }


}
