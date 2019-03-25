import java.util.Stack;

public class LargestRectangleArea {

    public static void main(String[] args) {

        int[] heights = {2, 2};
        largestRectangleArea(heights);
        largestRectangleAreaStack(heights);
        ;
    }

    private static int largestRectangleAreaStack(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int globalMaxArea = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                i++;
            } else {
                Integer currentIndex = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int length = heights[currentIndex];
                int currentMaxArea = length * width;
                globalMaxArea = Integer.max(globalMaxArea, currentMaxArea);
            }
        }

        while (!stack.isEmpty()) {
            Integer currentIndex = stack.pop();
            int length = heights[currentIndex];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            int currentMaxArea = length * width;
            globalMaxArea = Integer.max(globalMaxArea, currentMaxArea);
        }

        System.out.println(globalMaxArea);
        return globalMaxArea;

        //        Stack<Integer> stack = new Stack<Integer>();
        //
        //        int max = 0;
        //        int i = 0;
        //
        //        while (i < height.length) {
        //            //push index to stack when the current height is larger than the previous one
        //            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
        //                stack.push(i);
        //                i++;
        //            } else {
        //                //calculate max value when the current height is less than the previous one
        //                int p = stack.pop();
        //                int h = height[p];
        //                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
        //                max = Math.max(h * w, max);
        //            }
        //
        //        }
        //
        //        while (!stack.isEmpty()) {
        //            int p = stack.pop();
        //            int h = height[p];
        //            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
        //            max = Math.max(h * w, max);
        //        }
        //
        //        return max;
    }

    private static int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length == 0) {
            return 0;
        }

        int size = heights.length;

        int[] left = new int[size];
        int[] right = new int[size];

        left[0] = -1;
        for (int i = 1; i < size; i++) {
            int previous = i - 1;
            while (previous >= 0 && heights[previous] >= heights[i]) {
                previous--;
            }
            left[i] = previous;
        }

        right[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int next = i + 1;
            while (next < heights.length && heights[next] >= heights[i]) {
                next++;
            }
            right[i] = next;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Integer.max(maxArea, heights[i] * (right[i] - left[i] - 1));
        }
        System.out.println(maxArea);
        return maxArea;
    }
}
