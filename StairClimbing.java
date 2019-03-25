import java.util.Arrays;

public class StairClimbing {

    public static void main(String[] args) {

        int numOfStairs = 4;
        int[] cache = new int[numOfStairs + 1];
       // System.out.println(recusionSC(numOfStairs, cache));

       // dynamicSC(numOfStairs);
        dunamicSCWithLessSpace(numOfStairs);
    }

    private static int dunamicSCWithLessSpace(int numOfStairs) {
        int totalWaysOneStepBefore = 1;
        int totalWaysTwoStepsBefore = 1;
        if (numOfStairs == 0) {
            return 0;
        }
        if (numOfStairs == 1) {
            return 1;
        }
        int result = 0;
        for (int i = 2; i <= numOfStairs; i++) {
            result = totalWaysOneStepBefore + totalWaysTwoStepsBefore;
            totalWaysOneStepBefore = totalWaysTwoStepsBefore;
            totalWaysTwoStepsBefore = result;
        }
        System.out.println(result);
        return result;
    }

    private static void dynamicSC(int numOfStairs) {
        int[] array = new int[numOfStairs + 1];
        array[0] = 1;
        array[1] = 1;
        array[2] = array[0] + array[1];
        for (int i = 3; i <= numOfStairs; i++) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }

        System.out.println(Arrays.toString(array));
        ;
    }

    private static int recusionSC(int numOfStairs, int[] cache) {

        if (numOfStairs == 0) {
            return 1;
        }
        if (numOfStairs < 0) {
            return 0;
        }

        if (cache[numOfStairs] == 0) {
            cache[numOfStairs] =
                    recusionSC(numOfStairs - 1, cache) + recusionSC(numOfStairs - 2, cache) + recusionSC(numOfStairs - 3, cache);
        }

        return cache[numOfStairs];
    }
}
