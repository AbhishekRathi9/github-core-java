import java.util.Arrays;

public class NextGreatestElement {

    public static void main(String[] args) {

        int[] array = {3, 4, 20, 6, 15, 2, 1, 7};

        int max = array[array.length-1];
        for (int i = array.length - 2; i >= 0; i--) {
            if(max > array[i]){
                array[i]=max;
            } else{
                max = array[i];
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
