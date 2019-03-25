import java.util.Arrays;

public class PrimeNumber {

    public static void main(String[] args) {
        int n = 2;
        countPrimes(n);
    }

    private static int countPrimes(int n) {

        boolean[] notPrimeNumbers = new boolean[n];

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrimeNumbers[i]) {
                count++;
                for (int j = 2; j * i < n; j++) {
                    notPrimeNumbers[j * i] = true;
                }
            }
        }
        System.out.println(count);
        return count;
    }
}
