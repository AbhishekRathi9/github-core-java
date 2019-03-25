import java.util.Arrays;

public class DutchNationalFlag {

    static int[] numbers = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

    public static void main(String[] args) {

        segregate(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));

        int[] num = {2, 1, 1, 0, 2};

        int[] temp = new int[3];

        for (int i = 0; i < num.length; i++) {
           temp[num[i]]++;
        }

        int i = 0;
        int j = 0;

        while (j < temp.length && i < num.length) {
            int occurence = temp[j];
            while (occurence > 0) {
                num[i] = j;
                i++;
                occurence--;
            }
            j++;
        }

        System.out.println(Arrays.toString(num));
    }

    private static void segregate(int[] numbers, int low, int high) {
        int m = 0;
        int pivot = 1;
        while (m <= high) {
            if (numbers[m] < pivot) {
                swap(m, low);
                m++;
                low++;
            } else if (numbers[m] > pivot) {
                swap(m, high);
                high--;
            } else {
                m++;
            }
        }

        //        while (m <= high) {
        //            if (numbers[m] == 0) {
        //                swap(m, low);
        //                low++;
        //                m++;
        //            } else if (numbers[m] == 1) {
        //                m++;
        //            } else {
        //                swap(m, high);
        //                high--;
        //            }
        //        }
    }

    private static void swap(int m, int low) {
        int temp = numbers[m];
        numbers[m] = numbers[low];
        numbers[low] = temp;
    }
}
