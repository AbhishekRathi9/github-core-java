import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnapSackZeroOne {

    public static void main(String[] args) {

        int maximumWeight = 13;
        int[] itemWeight = {5, 6, 8, 4};
        int[] itemProfit = {5, 4, 7, 7};
        Map<String, Integer> lookUp = new HashMap<>();
        System.out.println(recursion(itemWeight, itemProfit, 0, maximumWeight, lookUp));

        int[][] matrix = new int[itemWeight.length + 1][maximumWeight + 1];

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j <= maximumWeight; j++) {
                if (itemWeight[i - 1] > j) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Integer.max(matrix[i - 1][j], itemProfit[i - 1] + matrix[i - 1][j - itemWeight[i - 1]]);
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix));

        int i = itemProfit.length - 1;
        int j = maximumWeight;
        List<Integer> list = new ArrayList<>();
        while (i != 0 && j != 0) {
            if (matrix[i][j] != matrix[i - 1][j]) {
                list.add(itemWeight[i]);
                j = j - itemWeight[i];
                i--;
            } else {
                i--;
            }
        }

        System.out.println(list);
    }

    private static int recursion(int[] itemWeight, int[] itemProfit, int index, int maximumWeight,
            Map<String, Integer> lookUp) {

        if (index == itemProfit.length) {
            return 0;
        }

        if (maximumWeight - itemWeight[index] < 0) {
            return recursion(itemWeight, itemProfit, index + 1, maximumWeight, lookUp);
        }

        String key = index + "@" + maximumWeight;

        if (!lookUp.containsKey(key)) {
            int include = itemProfit[index] + recursion(itemWeight, itemProfit, index + 1, maximumWeight - itemWeight[index], lookUp);

            int exclude = recursion(itemWeight, itemProfit, index + 1, maximumWeight, lookUp);

            lookUp.put(key, Integer.max(include, exclude));
        }
        return lookUp.get(key);
    }
}
