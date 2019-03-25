import java.util.Arrays;

public class EditDistance1 {

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "de";
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        System.out.println(editDistanceRecursion(word1, word2, word1.length(), word2.length(), memo));
        System.out.println(editDistanceDynamic(word1, word2));
        ;
    }

    private static int editDistanceDynamic(String word1, String word2) {

        int[][] matrrix = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word2.length(); i++) {
            matrrix[0][i] = i;
        }

        for (int i = 0; i <= word1.length(); i++) {
            matrrix[i][0] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    matrrix[i][j] = matrrix[i - 1][j - 1];
                } else {
                    matrrix[i][j] = 1 + Integer.min(matrrix[i - 1][j - 1], Integer.min(matrrix[i - 1][j], matrrix[i][j - 1]));
                }
            }
        }
        return matrrix[word1.length()][word2.length()];
    }

    private static int editDistanceRecursion(String word1, String word2, int length1, int length2, int[][] memo) {

        if (memo[length1][length2] != 0) {
            return memo[length1][length2];
        }
        if (length1 == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length1;
        }

        if (word1.charAt(length1 - 1) == word2.charAt(length2 - 1)) {
            memo[length1][length2] = editDistanceRecursion(word1, word2, length1 - 1, length2 - 1, memo);
            return memo[length1][length2];
        } else {
            int additionCost = editDistanceRecursion(word1, word2, length1, length2 - 1, memo);
            int deletionCost = editDistanceRecursion(word1, word2, length1 - 1, length2, memo);
            int transitionCost = editDistanceRecursion(word1, word2, length1 - 1, length2 - 1, memo);

            memo[length1][length2] = 1 + Integer.min(additionCost, Integer.min(deletionCost, transitionCost));
            return memo[length1][length2];
        }
    }
}
