import java.util.Stack;

public class MinElementInStack {

    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> minStack = new Stack<>();
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        addValue(5);
    }

    private static void addValue(int number) {
        stack.add(number);
        if (min > number) {
            minStack.add(number);
        } else {
            minStack.add(min);
        }
    }
}
