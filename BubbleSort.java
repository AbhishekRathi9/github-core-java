import java.util.Arrays;

public class BubbleSort {

    private int[] numbers = {34, 65, 87, 1, 5, 8, 0, 6, 6, 87, 435436, 766, 32, 2};

    public static void main(String[] args) {

        BubbleSort bubble = new BubbleSort();
        bubble.sort();

    }

    private void sort() {

        for (int i = 0; i < numbers.length - 1; i++) {
            int j = i + 1;
            while (j < numbers.length) {
                swap(i, j);
                j++;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

    private void swap(int i, int j) {
        if (numbers[j] < numbers[i]) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }
}
