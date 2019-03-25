import java.util.Arrays;

public class RodCutting {

    public static void main(String[] args) {
        int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        int cache[] = new int[arr.length + 1];
        int trace[] = new int[arr.length + 1];
        //System.out.println(recursiveRC(arr, size, cache));
        dynamicRC(arr, size, cache, trace);

    }



    private static void dynamicRC(int[] price, int size, int[] cache, int[] trace) {

        for (int i = 1; i <= size; i++) {
            int q = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                int result = price[i - 1 - j] + cache[j];
                if (result > q) {
                    q = result;
                    trace[i] = j;
                }
            }
            cache[i] = q;
        }
        System.out.println(Arrays.toString(cache));
        System.out.println(Arrays.toString(trace));
    }

    private static int recursiveRC(int[] price, int size, int[] cache) {

        if (size <= 0) {
            return 0;
        }
        int q = Integer.MIN_VALUE;

        if (cache[size] == 0) {
            for (int i = 1; i <= size; i++) {
                int result = price[i - 1] + recursiveRC(price, size - i, cache);
                if (result > q) {
                    q = result;
                }
                cache[size] = q;
            }
        }
        return cache[size];
    }
}
