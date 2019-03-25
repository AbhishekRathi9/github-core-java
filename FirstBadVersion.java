public class FirstBadVersion {

    public static void main(String[] args) {
        int n = 10;
        firstBadVersion(n);
    }

    private static int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start < end) {

            int center = start + (end - start) / 2;
            if (!isBadVersion(center)) {
                start = center + 1;
            } else {
                end = center;
            }
        }
        System.out.println(start);
        return start;
    }

    private static boolean isBadVersion(int n) {
        return n >= 7;
    }
}
