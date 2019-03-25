public class EggDroppingProblem {

    public static void main(String[] args) {

        int number = 2;
        int floor = 100;

        // System.out.println(recursionEggDropping(number, floor));
        dynamicED(number, floor);
    }

    private static void dynamicED(int eggs, int floor) {

        int[][] cache = new int[eggs + 1][floor + 1];

        for (int i = 1; i <= eggs; i++) {
            cache[i][1] = 1;
        }

        for (int i = 1; i <= floor; i++) {
            cache[1][i] = i;
        }

        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floor; j++) {
                cache[i][j] = Integer.MAX_VALUE;
                int temp = 0;
                for (int k = 1; k <= j; k++) {
                    temp = 1 + Integer.max(cache[i - 1][k - 1], cache[i][j - k]);
                    cache[i][j] = Integer.min(temp, cache[i][j]);
                }
            }
        }

        System.out.println(cache[eggs][floor]);
    }

    private static int recursionEggDropping(int number, int floor) {
        if (floor == 0 || floor == 1) {
            return floor;
        }

        if (number == 1) {
            return floor;
        }

        int temp = Integer.MAX_VALUE;
        for (int i = 1; i <= floor; i++) {
            temp = Integer.min(temp, Integer.max(recursionEggDropping(number - 1, i - 1), recursionEggDropping(number, floor - i)));
        }
        return temp + 1;
    }
}
