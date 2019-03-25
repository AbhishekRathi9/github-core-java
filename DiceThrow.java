public class DiceThrow {

    public static void main(String[] args) {

        int numberOfDices = 4;    // n throws
        int faceValue = 6;    // values 1 - 6
        int requiredSum = 15;

        System.out.println(recursiveDT(numberOfDices, faceValue, requiredSum));
        ;
    }

    private static int recursiveDT(int numberOfDices, int faceValue, int requiredSum) {
        if (numberOfDices == 0 && requiredSum == 0) {
            return 1;
        }
        if (requiredSum < 0) {
            return 0;
        }
        int result = 0;
        for (int faceval = 1; faceval <= faceValue; faceval++) {
            result += recursiveDT(numberOfDices - 1, faceValue, requiredSum - faceval);
        }
        return result;
    }
}
