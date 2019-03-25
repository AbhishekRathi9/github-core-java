import java.util.Arrays;

public class MinJumpsArray {

    static int[] numbers = {1, 3, 0, 0 ,0,1, 6, 8, 9, 5};

    public static void main(String[] args) {

        System.out.println(minJumpsRecursively(0));

        // System.out.println(minJumpsDynamically());

        System.out.println(minJumpsGreedy(numbers));
        ;
        ;
    }

    private static int minJumpsGreedy(int[] nums) {
        int currentMax = 0;
//        int endPoint = 0;
//        int steps = 0;
//        for (int i = 0; i < nums.length; i++) {
//            currentMax = Integer.max(currentMax, nums[i] + i);
//
//            if (i == endPoint) {
//                steps++;
//                endPoint = currentMax;
//            }
//        }
//
//        return steps;

        int step_count = 0;
        int last_jump_max = 0;
        int current_jump_max = 0;
        for(int i = 0; i< nums.length-1; i++) {
            current_jump_max = Math.max(current_jump_max, i+ nums[i]);
            if( i == last_jump_max ) {
                step_count++;
                last_jump_max = current_jump_max;
            }
        }
        return step_count <= nums.length-1?step_count:-1;
    }

    private static int minJumpsDynamically() {

        int[] stepCounter = new int[numbers.length];
        int[] result = new int[numbers.length];
        Arrays.fill(stepCounter, 100000);
        stepCounter[0] = 0;
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                int farthestPoint = j + numbers[j];
                if (farthestPoint >= i) {
                    //stepCounter[i] = Integer.min(stepCounter[i], 1 + stepCounter[j]);
                    if (stepCounter[j] + 1 < stepCounter[i]) {
                        stepCounter[i] = 1 + stepCounter[j];
                        result[i] = j;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(stepCounter));
        int temp = numbers.length - 1;
        while (temp != 0) {
            System.out.println(result[temp] + "->");
            temp = result[temp];
        }
        return stepCounter[numbers.length - 1];
    }

    //    int[] stepsCounter = new int[numbers.length];
    //        Arrays.fill(stepsCounter, 9999);
    //    stepsCounter[0] = 0;
    //    int[] result = new int[numbers.length];
    //
    //        for (int i = 1; i < numbers.length; i++) {
    //        for (int j = 0; j < i; j++) {
    //            if (j + numbers[j] >= i) {
    //                if (1 + stepsCounter[j] < stepsCounter[i]) {
    //                    stepsCounter[i] = 1 + stepsCounter[j];
    //                    result[i] = j;
    //                }
    //            }
    //        }
    //    }
    //
    //        System.out.println(Arrays.toString(stepsCounter));
    //        System.out.println(Arrays.toString(result));
    //
    //    int i = numbers[numbers.length - 1];
    //
    //    i = numbers.length - 1;
    //        while (i != 0) {
    //        System.out.println(numbers[i]);
    //        i = result[i];
    //    }
    //        System.out.println(numbers[0]);

    // 1->3->7->6->3->5;
    private static int minJumpsRecursively(int start) {

        int maxIndexsize = numbers.length - 1;
        if (start == maxIndexsize) {
            return 0;
        }
        if (numbers[start] == 0) {
            System.out.println("can not move further");
            return Integer.MAX_VALUE;
        }
        int farthestPoint = Integer.min(start + numbers[start], maxIndexsize);
        int minJump = Integer.MAX_VALUE;
        for (int i = start + 1; i <= farthestPoint; i++) {
            int temp = minJumpsRecursively(i);
            if (temp != Integer.MAX_VALUE) {
                minJump = Integer.min(minJump, 1 + temp);
            }
        }
        return minJump;
    }
}




