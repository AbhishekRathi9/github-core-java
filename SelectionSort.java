import java.util.Arrays;
import java.util.List;

public class SelectionSort {

    private List<Integer> numbers = Arrays.asList(5, 3, 65, 2, 6, 6, 7, 8, 89, 65, 90, 346);

    public static void main(String[] args) {
        SelectionSort selection = new SelectionSort();
        selection.sort();
    }

    private void sort() {
        for (int j = 0; j < numbers.size() - 1; j++) {
            for (int k = j + 1; k < numbers.size(); k++) {
                if (numbers.get(j) > numbers.get(k)) {
                    swap(j, k);
                }
            }
        }
        System.out.println(numbers);
    }

    private void swap(int j, int k) {
        int small = numbers.get(k);
        int large = numbers.get(j);
        numbers.set(j, small);
        numbers.set(k, large);
    }
}
