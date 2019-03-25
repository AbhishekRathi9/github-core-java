public class SearchInSortedRotatedarray {

    static int[] array = {9, 12, 15, 17, 25, 28, 32, 37, 3, 5, 7, 8};

    //pairs sum
    // odd occurences
    public static void main(String[] args) {

        System.out.println(find(0, array.length - 1, 28));;
    }

    private static int find(int start, int end, int number) {

        while (start <= end) {
            int center = (start + end) / 2;

            if (number == array[center]) {
                return center;
            } else if (array[center] < array[end]) { //rhs is sorted
                if (number > array[center] && number <= array[end]) {
                    start = center + 1;
                } else {
                    end = center - 1;
                }
            } else { //lhs is sorted
                if (number >= array[start] && number < array[center]) {
                    end = center - 1;
                } else {
                    start = center + 1;
                }
            }
        }
        return -1;
    }
}
