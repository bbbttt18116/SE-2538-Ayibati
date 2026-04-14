public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<>();

    // Push an item onto the top of the stack
    public void push(T item) {
        list.add(item);
    }

    // Remove and return the top item
    public T pop() {
        if (isEmpty()) throw new java.util.EmptyStackException();
        T item = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return item;
    }

    // Look at the top item without removing it
    public T peek() {
        if (isEmpty()) throw new java.util.EmptyStackException();
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
