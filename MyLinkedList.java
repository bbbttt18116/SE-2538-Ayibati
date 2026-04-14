import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a doubly linked list.
 * Each element is stored in a node with pointers to the previous and next nodes.
 */
public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    
    // Inner class representing a single node in the chain
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head; // First node
    private MyNode tail; // Last node
    private int size = 0;

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    // Helper method to find a node at a specific position
    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void remove(int index) {
        MyNode nodeToRemove = getNode(index);
        MyNode prevNode = nodeToRemove.prev;
        MyNode nextNode = nodeToRemove.next;

        if (prevNode == null) head = nextNode; // Removing head
        else prevNode.next = nextNode;

        if (nextNode == null) tail = prevNode; // Removing tail
        else nextNode.prev = prevNode;

        size--;
    }

    @Override
    public void sort() {
        // Bubble sort for linked list (swapping data, not nodes for simplicity)
        if (size < 2) return;
        for (int i = 0; i < size - 1; i++) {
            MyNode current = head;
            for (int j = 0; j < size - i - 1; j++) {
                if (current.data.compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;
            @Override
            public boolean hasNext() { return current != null; }
            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    // You should add implementations for getFirst, getLast, removeFirst, removeLast, etc.
    @Override public void clear() { head = tail = null; size = 0; }
    @Override public T getFirst() { return head != null ? head.data : null; }
    @Override public T getLast() { return tail != null ? tail.data : null; }
}
