public class Sqrt {

    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(  sqrt(x));;
    }

    private static int sqrt(int x) {
        long low = 0;
        long high = x;
        while (low + 1 < high) {
            long center = low + (high - low) / 2;

            if (center * center == x) {
                return (int)center;
            }
            if (x > center * center) {
                low = center;
            } else {
                high = center;
            }
        }

        if (high * high == x) {
            return (int)high;
        } else {
            return (int)low;
        }
    }
}
