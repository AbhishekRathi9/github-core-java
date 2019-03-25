import java.util.Arrays;

public class ArrayMajorityElement {

    static int[] array = {3, 3, 4, 2, 4, 4, 2, 4, 4};

    public static void main(String[] args) {
        Arrays.sort(array);
        int center = (0 + array.length - 1) / 2;
        int count = 1;
        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] == array[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > center) {
                System.out.println("majority found");
                System.out.println(array[i]);
            }
        }

        int[] newArray = {2, 3, 3, 2, 5};

        int[] countArray = new int[newArray.length+1];

        for (int i = 0; i < newArray.length; i++) {
            countArray[newArray[i]]=countArray[newArray[i]]+1;
        }

        System.out.println(Arrays.toString(countArray));
    }
}
