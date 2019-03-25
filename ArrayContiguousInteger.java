import java.util.HashSet;
import java.util.Set;

public class ArrayContiguousInteger {

    public static void main(String[] args) {

        int[] numbers = {5, 2, 3, 6, 4, 4, 6, 6};

        System.out.println(areElementsContiguous(numbers));;
    }

    private static boolean areElementsContiguous(int[] numbers) {

        Set<Integer> set = new HashSet<>();

        for (int n : numbers) {
            set.add(n);
        }

        int count = 0;

        int current = numbers[0];

        while (set.contains(current)) {
            count++;
            current++;
        }

        current = numbers[0] - 1;

        while (set.contains(current)) {
            count++;
            current--;
        }
        System.out.println(count);
        return count==set.size();
    }
}
