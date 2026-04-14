/**
 * First-In-First-Out (FIFO) queue implementation based on MyLinkedList.
 */
public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    // Add an item to the back of the queue
    public void enqueue(T item) {
        list.addLast(item);
    }

    // Remove and return the front item
    public T dequeue() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    // Look at the front item without removing it
    public T peek() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
