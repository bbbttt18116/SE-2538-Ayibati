/**
 * Min-Heap implementation using MyArrayList as the underlying structure.
 * Maintains the property where the parent is always smaller than its children.
 */
public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void insert(T item) {
        list.add(item); // Add to the end
        traverseUp(list.size() - 1); // Bubble up to maintain heap property
    }

    public T extractMin() {
        if (list.size() == 0) return null;
        T min = list.get(0);
        T lastItem = list.get(list.size() - 1);
        
        if (list.size() > 1) {
            list.set(0, lastItem); // Move last item to root
            list.remove(list.size() - 1);
            traverseDown(0); // Bubble down
        } else {
            list.remove(0);
        }
        return min;
    }

    private void traverseUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else break;
        }
    }

    private void traverseDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < list.size() && list.get(left).compareTo(list.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < list.size() && list.get(right).compareTo(list.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public int size() { return list.size(); }
}
