import java.util.Arrays;

public class ArraySum {

    public static void main(String[] args) {
         int[] numbers = {5,2,1,3,4,6,7,9,8,3};

         for(int i=1;i<numbers.length;i++){
             numbers[i]=numbers[i-1]+numbers[i];
         }

        System.out.println(Arrays.toString(numbers));
    }
}
