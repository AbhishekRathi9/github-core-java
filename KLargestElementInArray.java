import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargestElementInArray {

    public static void main(String[] args) {
        //  int[] nums = {34, 65, 87, 1, 5, 8, 0, 6, 6, 87, 435436, 766, 32, 2};
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));
        System.out.println( findKthLargestUsingHeap(nums, k));;
    }

    private static int findKthLargestUsingHeap(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

       // PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
//        PriorityQueue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());
//        for (int number : nums) {
//            queue1.add(number);
//        }
//        System.out.println(queue1.peek());
        for (int number : nums) {
            queue.add(number);
            if (queue.size() > k) {
                queue.remove();
            }
        }

        return queue.peek();
    }

    private static int findKthLargest(int[] nums, int k) {

        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSort(int[] nums, int start, int end, int k) {
        if (start > end) {
            return Integer.MAX_VALUE;
        }
        int partitionIndex = partition(nums, start, end);
        if (partitionIndex == k) {
            return nums[k];
        }
        if (partitionIndex > k) {
            quickSort(nums, start, partitionIndex - 1, k);
        } else {
            quickSort(nums, partitionIndex + 1, end, k);
        }
        return nums[k];
    }

    private static int partition(int[] nums, int low, int high) {
        int pivotIndex = low;
        int pivot = nums[low];
        while (low < high) {
            while (nums[low] <= pivot && low < high) {
                low++;
            }
            while (nums[high] > pivot) {
                high--;
            }
            if (low < high) {
                swap(nums, low, high);
            }
        }
        swap(nums, pivotIndex, high);
        return high;
    }

    private static void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
}
