public class Monotonicarray {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 1};
        System.out.println(isMonotonic(nums));
        ;
    }

    private static boolean isMonotonic(int[] A) {
        boolean increase = true;
        boolean decrease = true;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                increase = false;
            }
            if (A[i] < A[i + 1] ){
                decrease = false;
            }
        }
        return increase || decrease;
    }
}
