import java.util.Arrays;

public class ShellSort {

    private int[] numbers = {34, 65, 87, 1, 5, 8, 0, 6, 6, 87, 435436, 766, 32, 2};

    public static void main(String[] args) {

        ShellSort shellSort = new ShellSort();
        shellSort.sort();
    }

    private void sort() {
        int increment = numbers.length / 2;
        while (increment >= 1) {
            for (int i = 0; i < increment; i++) {
                insertionSort(i, increment);
            }
            increment = increment / 2;
        }
        System.out.println(Arrays.toString(numbers));
    }

    private void insertionSort(int startIndex, int gap) {
        for (int i = startIndex; i < numbers.length - 1; i = i + gap) {
            for (int j = Math.min(i + gap, numbers.length - 1); j - gap >= 0; j = j - gap) {
                if (numbers[j] < numbers[j - gap]) {
                    swap(j, j - gap);
                }
            }
        }
    }

    private void swap(int i, int j) {

        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
