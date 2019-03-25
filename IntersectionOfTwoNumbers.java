import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoNumbers { //Leetcode 349

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 4, 5, 6, 7};
        int[] num2 = {7, 1, 4, 99, 99, 99, 0};

        System.out.println(Arrays.toString( intersection(num1, num2)));;
    }

    private static int[] intersection(int[] num1, int[] num2) {
        Set<Integer> set = new HashSet<>();
        for (int n : num1) {
            set.add(n);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int n : num2) {
            if (set.contains(n)) {
                set2.add(n);
            }
        }

        int[] res = new int[set2.size()];
        int index=0;
        for (int i : set2) {
            res[index++] = i;
        }

        return res;
    }

}
