public class MaximumDifferenceArray {

    public static void main(String[] args) {
        int[] A = {2, 7, 9, 5, 1, 3, 5};

        System.out.print("The maximum difference is " + diff(A));
    }

    private static int diff(int[] nums) {

        int globaMaxDiff=0;
        int maxElement=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>maxElement){
                maxElement=nums[i];
            }
            globaMaxDiff=Integer.max(globaMaxDiff,maxElement-nums[i]);
        }
        System.out.println(globaMaxDiff);
        return globaMaxDiff;
    }
}
