import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public void add(T item) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (T) elements[index]; // 这里需要强制转换 [cite: 58]
    }

    @Override
    public int size() {
        return size;
    }

}
