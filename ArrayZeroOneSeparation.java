import java.util.Arrays;

public class ArrayZeroOneSeparation {

    static int[] array = {0, 1, 0, 1, 0};

    public static void main(String[] args) {

        int left = 0;
        int right = array.length - 1;

        while (left < right) {

            while (array[left] == 0 && left < right) {
                left++;
            }

            while (array[right] == 1 && left < right) {
                right--;
            }

            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(array));
    }
}
