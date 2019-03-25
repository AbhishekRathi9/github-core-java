public class OptimumStrategy {

    public static void main(String[] args) {
        int[] coin = {4, 6, 2, 3};
        int[][] lookUp = new int[coin.length][coin.length];
        System.out.println(recursionOS(coin, 0, coin.length - 1, lookUp));
        int[][] T = new int[coin.length][coin.length];

        for (int iteration = 0; iteration < coin.length; iteration++) {
            for (int i = 0, j = iteration; j < coin.length; i++, j++) {
                System.out.println(iteration + " " + j);
            }
        }
    }

    private static int recursionOS(int[] coin, int start, int end, int[][] lookUp) {

        if (start == end) {
            return coin[start];
        }

        if (start + 1 == end) {
            return Integer.max(coin[start], coin[end]);
        }

        if (lookUp[start][end] == 0) {
            int left = coin[start] + Integer.min(recursionOS(coin, start + 1, end - 1, lookUp), recursionOS(coin, start + 2, end, lookUp));

            int right = coin[end] + Integer.min(recursionOS(coin, start + 1, end - 1, lookUp), recursionOS(coin, start, end - 2, lookUp));

            lookUp[start][end] = Integer.max(left, right);
        }

        return lookUp[start][end];
    }
}
