import java.util.Arrays;

public class HeapSort {

    private static int[] numbers = {4, 6, 9, 2, 10, 56, 12, 5, 1, 17, 14};

    public static void main(String[] args) {

        HeapSort heapSort = new HeapSort();

        heapSort.heapSort();

        System.out.println(Arrays.toString(numbers));
    }

    private void heapSort() {
        heapify();
        int end = numbers.length - 1;
        while (end >= 0) {
            swap(0, end);
            end--;
            percolateDown(0, end);
        }
    }

    private void heapify() {
        int parentIndex = getParentIndex(numbers.length - 1);
        while (parentIndex > 0) {
            parentIndex--;
            percolateDown(parentIndex, numbers.length - 1);
        }
    }

    private void percolateDown(int parentIndex, int endIndex) {
        int leftIndex = getLeftIndex(parentIndex, endIndex);
        int rightIndex = getRightIndex(parentIndex, endIndex);

        if (leftIndex == -1 && rightIndex == -1) {
            return;
        }

        if (leftIndex != -1 && numbers[leftIndex] > numbers[parentIndex]) {
            swap(leftIndex, parentIndex);
            percolateDown(leftIndex, endIndex);
        }
        if (rightIndex != -1 && numbers[rightIndex] > numbers[parentIndex]) {
            swap(rightIndex, parentIndex);
            percolateDown(rightIndex, endIndex);
        }
    }

    private void swap(int parentIndex, int smallerIndex) {
        int temp = numbers[parentIndex];
        numbers[parentIndex] = numbers[smallerIndex];
        numbers[smallerIndex] = temp;
    }

    private int getRightIndex(int parentIndex, int endIndex) {
        int rightIndex = (2 * parentIndex) + 2;
        if (rightIndex > endIndex) {
            return -1;
        }
        return rightIndex;
    }

    private int getLeftIndex(int parentIndex, int endIndex) {
        int leftIndex = (2 * parentIndex) + 1;
        if (leftIndex > endIndex) {
            return -1;
        }
        return leftIndex;
    }

    private int getParentIndex(int endIndex) {
        int parentIndex = (endIndex - 1) / 2;
        if (parentIndex < 0) {
            return -1;
        }
        return parentIndex;
    }
}
