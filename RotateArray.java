import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    private static void rotate(int[] nums, int k) {
        if(nums==null || nums.length < 2){
            return;
        }
        k=k%nums.length;
        //reverse(nums,0,nums.length - k - 1);
        reverse(nums,0,k-1);
        //reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    private static void reverse(int[] nums, int startIndex, int endIndex){
        int low = startIndex;
        int high = endIndex;
        while(low < high){
            int temp = nums[low];
            nums[low]=nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
}
