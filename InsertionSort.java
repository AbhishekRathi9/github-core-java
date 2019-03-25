import java.util.Arrays;

public class InsertionSort {

    private int[] numbers = {34, 65, 87, 1, 5, 8, 0, 6, 6, 87, 435436, 766, 32, 2};

    public static void main(String[] args) {
        InsertionSort insertion = new InsertionSort();
        insertion.sort();
    }

    private void sort() {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    swap(j, j - 1);
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

    private void swap(int i, int j) {

        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
