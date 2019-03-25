import java.util.Arrays;

public class FlippingImage {

    public static void main(String[] args) {
        int[][] A = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };

        flip(A);
    }

    private static int[][] flip(int[][] A) {

        for (int i = 0; i < A.length; i++) {
            // for (int j = 0; j < A[i].length; j++) {
            int low = 0;
            int high = A[i].length - 1;

            while (low < high) {
                int temp = A[i][low];
                A[i][low] = A[i][high];
                A[i][high] = temp;

                low++;
                high--;
            }
            // }
            for (int k = 0; k < A.length; k++) {
                A[i][k] = A[i][k] == 1 ? 0 : 1;
            }
        }
        return  A;
    }
}
