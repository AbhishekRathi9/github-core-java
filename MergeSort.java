import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] numbers = {34, 65, 87, 1, 5, 8, 0, 6, 6, 87, 435436, 766, 32, 2};

        MergeSort merge = new MergeSort();
        merge.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private void sort(int[] numbers) {
        if (numbers.length == 1) {
            return;
        }
        int center = getCenter(0, numbers.length);
        int[] left = new int[center];
        int[] right = new int[numbers.length - center];
        split(left, right, numbers);
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));
        sort(left);
        sort(right);
        merge(left, right, numbers);
    }

    private void merge(int[] left, int[] right, int[] numbers) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                numbers[k] = left[i];
                i++;
            } else {
                numbers[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            numbers[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            numbers[k] = right[j];
            j++;
            k++;
        }
    }

    private void split(int[] left, int[] right, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (left.length > i) {
                left[i] = numbers[i];
            } else {
                right[i - left.length] = numbers[i];
            }
        }
    }

    private int getCenter(int start, int end) {
        return (start + end) / 2;
    }
}
