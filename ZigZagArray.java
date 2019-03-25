import java.util.Arrays;

public class ZigZagArray {

    public static void main(String[] args) {

        int[] numbers = {3, 4, 6, 2, 1, 8, 9};

        boolean flag = true;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (flag) {
                if (numbers[i] > numbers[i + 1]) {
                    swap(numbers, i);
                }
            } else {
                if (numbers[i] < numbers[i + 1]) {
                    swap(numbers, i);
                }
            }
            flag=!flag;
        }

        System.out.println(Arrays.toString(numbers));
    }

    private static void swap(int[] numbers, int i) {
        int temp = numbers[i];
        numbers[i] = numbers[i + 1];
        numbers[i + 1] = temp;
    }
}
