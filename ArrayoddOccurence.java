public class ArrayoddOccurence {

    static int[] array = {1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5};

    public static void main(String[] args) {

        findOddOccurence();
    }

    private static void findOddOccurence() {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = result ^ array[i];
        }
        System.out.println(result);
    }
}
