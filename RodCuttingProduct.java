import java.util.Arrays;

public class RodCuttingProduct {

    public static void main(String[] args) {
        int rodLength = 10;
        int[] cache = new int[rodLength + 1];
        System.out.println("Maximum Product is "
                + maxProd(rodLength, cache));

        dunamicRCP(rodLength);
    }

    private static void dunamicRCP(int rodLength) {
        int[] cache = new int[rodLength + 1];
        cache[1] = 1;
        for (int i = 2; i <= rodLength; i++) {
            int temp = 0;
            for (int j = 1; j < i; j++) {
                temp = Integer.max(temp, Integer.max(j * (i - j), j * cache[i - j]));
            }
            cache[i] = temp;
        }

        System.out.println(Arrays.toString(cache));
    }

    private static int maxProd(int rodLength, int[] cache) {

        if (rodLength == 1) {
            return 1;
        }
        int temp = 0;
        if (cache[rodLength] == 0) {
            for (int i = 1; i < rodLength; i++) {
                int result = Integer.max(i * (rodLength - i), i * maxProd(rodLength - i, cache));
                if (result > temp) {
                    temp = result;
                    cache[rodLength] = result;
                }
            }
        }

        return cache[rodLength];
    }
}
