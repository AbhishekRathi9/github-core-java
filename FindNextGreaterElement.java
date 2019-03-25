import java.util.Stack;

public class FindNextGreaterElement {

    //Zig Zag
    //int[] numbers={3,4,6,2,1,8,9};

    public static void main(String[] args) {

        int[] numbers = {5, 3, 2, 10, 6, 8, 1, 4, 12, 7, 4};

        findnextGreatest(numbers);
    }

    private static void findnextGreatest(int[] numbers) {

        Stack<Integer> stack = new Stack<>();
        stack.add(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i]<stack.peek()){
                stack.add(numbers[i]);
            } else{
                while(!stack.isEmpty() && stack.peek() < numbers[i] ){
                    System.out.println(stack.pop() + " next largest number is -->" +numbers[i]);
                }
                stack.add(numbers[i]);
            }
        }
    }
}
