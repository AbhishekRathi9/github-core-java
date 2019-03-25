public class TrapRainWater {

    public static void main(String[] args) {

        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        trap(height);
        trap2(height);
    }

    private static int trap2(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while (low <= high) {
            if (leftMax <= rightMax) {
                if (height[low] > leftMax) {
                    leftMax = height[low];
                } else {
                    water += leftMax - height[low];
                }
                low++;
            } else {
                if (height[high] > rightMax) {
                    rightMax = height[high];
                } else {
                    water += rightMax - height[high];
                }
                high--;
            }
        }
        System.out.println(water);
        return water;
    }

    private static int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int length = height.length;
        int[] left = new int[length];
        left[0] = height[0];

        for (int i = 1; i < length; i++) {
            left[i] = Integer.max(left[i - 1], height[i]);
        }
        int totalWater = 0;
        int[] right = new int[length];
        right[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            right[i] = Integer.max(right[i + 1], height[i]);
            totalWater += Integer.min(left[i], right[i]) - height[i];
        }

        return totalWater;
    }
}
