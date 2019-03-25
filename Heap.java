import java.lang.reflect.Array;

public abstract class Heap<T extends Comparable> {

    private int MAX_SIZE = 40;
    private T[] array;
    private int count;

    public Heap(Class<T> clazz) {
        this.array = (T[]) Array.newInstance(clazz, MAX_SIZE);
    }

    public void insert(T data) throws HeapFullException {
        if (count == MAX_SIZE) {
            throw new HeapFullException();
        }
        array[count] = data;

        shiftUp(count);
        count++;
    }

    protected void shiftUp(int count) {
        int parentIndex = getParentIndex(count);
        if (parentIndex == -1) {
            return;
        }
        if (array[parentIndex].compareTo(array[count]) > 0) {
            swap(parentIndex, count);
            shiftUp(parentIndex);
        }
    }

    protected void swap(int parentIndex, int count) {
        T temp = array[parentIndex];
        array[parentIndex] = array[count];
        array[count] = temp;
    }

    public T removeHighestPriority() throws HeapEmptyException {
        if (count == 0) {
            throw new HeapEmptyException();
        }
        T temp = array[0];
        array[0] = array[count - 1];
        count--;
        shiftDown(0);
        return temp;
    }

    private void shiftDown(int count) {

        int leftIndex = getLeftIndex(count);
        int rightIndex = getRightIndex(count);

        int smallerIndex = -1;
        if (leftIndex != -1 && rightIndex != -1) {
            smallerIndex = array[leftIndex].compareTo(array[rightIndex]) < 0 ? leftIndex : rightIndex;
        } else if (leftIndex != -1) {
            smallerIndex = leftIndex;
        } else if (rightIndex != -1) {
            smallerIndex = rightIndex;
        }

        if (leftIndex == -1 && rightIndex == -1) {
            return;
        }
        if (array[smallerIndex].compareTo(array[count]) < 0) {
            swap(smallerIndex, count);
            shiftDown(smallerIndex);
        }
    }

    public static class HeapFullException extends Exception {
    }

    public static class HeapEmptyException extends Exception {
    }

    public int getLeftIndex(int index) {
        int leftIndex = (2 * index) + 1;
        if (leftIndex >= count) {
            return -1;
        }
        return leftIndex;
    }

    public int getRightIndex(int index) {
        int rightIndex = (2 * index) + 2;
        if (rightIndex >= count) {
            return -1;
        }
        return rightIndex;
    }

    public int getParentIndex(int index) {
        int parentIndex = (index - 1) / 2;
        if (parentIndex < 0 || parentIndex >= count) {
            return -1;
        }
        return parentIndex;
    }

    public void printHeapArray() {
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();

        try {
            System.out.println("Highest priority: " + getHighestPriority());
        } catch (HeapEmptyException ex) {
        }
    }

    public T getHighestPriority() throws HeapEmptyException {
        if (count == 0) {
            throw new HeapEmptyException();
        }

        return array[0];
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == array.length;
    }

    public T getElementAtIndex(int index) {
        return array[index];
    }
}
