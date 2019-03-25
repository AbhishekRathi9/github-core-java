public class FindDuplicate {

    public static void main(String[] args) {

        int[] nums ={1,3,4,2,2};
        findDuplicate(nums);
    }

    private static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while(fast!=slow){
            fast=nums[fast];
            slow=nums[slow];
        }

        return slow;
    }
}
