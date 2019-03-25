public class AddDigits {

    public static void main(String[] args) {

        int num = 38;
        System.out.println( addDigit(num));;
    }

    private static int addDigit(int num) {
        if (num == 0){
            return 0;
        }
        int digitSum = num;
        while (true) {
            digitSum = getDigitSum(digitSum);
            if (digitSum / 10 == 0) {
                break;
            }
           // num=digitSum;
        }

        return digitSum;
    }

    private static int getDigitSum(int num) {
        int sum = 0;
        while (num != 0) {
            int rem = num % 10;
            sum = sum + rem;
            num = num / 10;
        }
        return sum;
    }
}
