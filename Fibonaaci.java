public class Fibonaaci {

    static int number = 4;
    static int[] cache = new int[number + 1];

    public static void main(String[] args) {
        if (number > 1) {
            cache[0] = 1;
            cache[1] = 1;
        }
        // System.out.println(recursive(number));
        //System.out.println(iterative(number));
        int i = lessSpaceComplexityLogic(5);
        System.out.println(i);
    }

    private static int lessSpaceComplexityLogic(int number) {
        int a = 1;
        int b = 1;
        int c = 0;
        if (number < 2) {
            return a;
        }
        for (int i = 2; i <= number; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    private static int iterative(int number) {
        int[] array = new int[number + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= number; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[number];
    }

    private static int recursive(int number) {
        if (number <= 1) {
            return 1;
        }
        if (cache[number] != 0) {
            return cache[number];
        }
        cache[number] = recursive(number - 1) + recursive(number - 2);
        return cache[number];
    }
}
