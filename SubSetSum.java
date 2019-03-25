import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubSetSum {

    public static void main(String[] args) {
        int set[] = {4, 3, 5};
        int sum = 9;
        Map<String, Boolean> lookUp = new HashMap<>();
        System.out.println(subSetSumRecursive(set, sum, 0, lookUp));
        System.out.println(subSetdynamic(set, sum));
        ;
        ;
    }

    private static boolean subSetdynamic(int[] set, int sum) {
        boolean[][] matrix = new boolean[set.length + 1][sum + 1];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = true;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (set[i - 1] > j) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = matrix[i - 1][j] || matrix[i - 1][j - set[i - 1]];
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        return matrix[set.length][sum];
    }

    private static boolean subSetSumRecursive(int[] set, int sum, int index, Map<String, Boolean> lookUp) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || index >= set.length) {
            return false;

        }
        String key = sum + "!" + index;
        if (lookUp.containsKey(key)) {
            return lookUp.get(key);
        }
        boolean include = subSetSumRecursive(set, sum - set[index], index + 1, lookUp);

        boolean exclude = subSetSumRecursive(set, sum, index + 1, lookUp);

        lookUp.put(key, include || exclude);

        return lookUp.get(key);
    }
}
