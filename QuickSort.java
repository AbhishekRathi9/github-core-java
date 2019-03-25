import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] numbers = {34, 65, 87, 1, 5, 8, 0, 6, 6, 87, 435436, 766, 32, 2};
      //  int[] numbers = {5, 1, 4};
        QuickSort quick = new QuickSort();
        quick.sort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }

    private void sort(int[] numbers, int start, int end) {
        if (start > end) {
            return;
        }
        int pivotIndex = findPivot(numbers, start, end);
        sort(numbers, start, pivotIndex - 1);
        sort(numbers, pivotIndex + 1, end);
    }

    private int findPivot(int[] numbers, int start, int end) {
        int pivot = numbers[start];
        int low = start;
        while (start < end) {
            while (numbers[start] <= pivot && start < end) {
                start++;
            }
            while (numbers[end] > pivot) {
                end--;
            }
            if (start < end) {
                swap(start, end, numbers);
            }
        }
        swap(end, low, numbers);
        return end;
    }

    private void swap(int start, int end, int[] numbers) {
        int temp = numbers[start];
        numbers[start] = numbers[end];
        numbers[end] = temp;
    }
}
