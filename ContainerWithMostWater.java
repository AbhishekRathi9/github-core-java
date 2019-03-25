public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        maxArea(height);
    }

    private static int maxArea(int[] height) {
        if(height==null){
            return 0;
        }
        int low = 0;
        int high = height.length - 1;
        int maxArea = 0;

        while (low <= high) {
            if (height[low] >= height[high]) {
                maxArea = Integer.max(maxArea, height[high] * (high - low));
                high--;
            } else {
                maxArea = Integer.max(maxArea, height[low] * (high - low));
                low++;
            }
        }
        System.out.println(maxArea);
        return maxArea;
    }
}
