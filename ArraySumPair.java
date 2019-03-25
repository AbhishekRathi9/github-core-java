import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArraySumPair {

   // static int[] array = {2,2,2,2,4,4};

    public static void main(String[] args) {
        long target =12;
       // Arrays.sort(array);

       // findPairs(0, array.length - 1, target);

        //below approach takes care of duplicates also
       // findAllPairs(target);
        List<Integer> numbers = Arrays.asList(6,12,3,9,3,5,1);
        findAllDistinctPairs(numbers,target);
    }

    private static int findAllDistinctPairs(List<Integer> a, long k) {
        if(null==a || a.size()==0){
            return 0;
        }
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : a) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        Integer modTarget = (int) (long) k;
        Set<Integer> distinctNumbers = frequencyMap.keySet();
        int doubleCount = 0;
        for (int num : distinctNumbers) {
            if (frequencyMap.containsKey(modTarget - num)) {
                doubleCount++;
            }
            if (k - num == num) {
                doubleCount++;
            }
        }
        System.out.println(doubleCount/2);
        return doubleCount / 2;
    }

//    private static int findAllPairs(int target) {
//
//        Map<Integer, Integer> frequencyMap = new HashMap<>();
//
//        for (int n : array) {
//            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
//        }
//
//        int doubleCounter = 0;
//
//        for (int num : array) {
//            if (frequencyMap.containsKey(target - num)) {
//                doubleCounter = doubleCounter + frequencyMap.get(target - num);
//            }
//
//            if (target - num == num) {
//                doubleCounter--;
//            }
//        }
//
//        System.out.println(doubleCounter / 2);
//        return doubleCounter / 2;
//    }

//    private static void findPairs(int start, int end, int number) {
//        Set<Integer> set = new HashSet<>();
//        // int count = 0;
//        while (start < end) {
//            if (array[start] + array[end] > number) {
//                end--;
//            } else if (array[start] + array[end] < number) {
//                start++;
//            } else {
//
//                //                if (set.contains(array[start])) {
//                //                    start++;
//                //                    continue;
//                //                }
//                //set.add(array[start]);
//                System.out.println("printing pair-->" + array[start] + "&" + array[end]);
//                // count++;
//                start++;
//            }
//        }
//    }
}
