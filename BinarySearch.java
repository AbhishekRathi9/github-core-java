import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.search(8, 0, numbers.size() - 1);
        binarySearch.searchIteratively(8, 0, numbers.size() - 1);
    }

    private void searchIteratively(int num, int min, int max) {

        //        while(min<=max){
        //            int center = (min + max) / 2;
        //            if(numbers.get(center)==num){
        //                System.out.println("found at index -->" +center);
        //                break;
        //            }
        //            if(num>numbers.get(center)){
        //                min=center+1;
        //            } else{
        //                max=center-1;
        //            }
        //        }

        while (min < max) {
            int center = (min + max) / 2;

            if (num > numbers.get(center)) {
                min = center + 1;
            } else {
                max = center;
            }
        }

        System.out.println(min);
    }

    private void search(int num, int min, int max) {

        if (min > max) {
            System.out.println("not found");
            return;
        }
        int center = (min + max) / 2;

        if (numbers.get(center) == num) {
            System.out.println(center);
        } else if (num > numbers.get(center)) {
            min = center + 1;
            search(num, min, max);
        } else {
            max = center - 1;
            search(num, min, max);
        }
    }
}
