public class MyStack<T extends Comparable<T>> {

    private Node<T> top;
    private int MAX_SIZE = 5;
    private int stackSize;

    public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(25);
        System.out.println(stack.stackSize);
        stack.peek();
        stack.pop();

        stack.pop();
        System.out.println(stack.stackSize);
    }

    private void pop() throws StackUnderflowException {
        if (stackSize == 0) {
            throw new StackUnderflowException();
        }
        System.out.println(top.getData());
        top = top.getNext();
        stackSize--;
    }

    private void peek() {
        System.out.println(top.getData());
    }

    private void push(T data) throws StackOverflowException {
        if (stackSize == MAX_SIZE) {
            throw new StackOverflowException();
        }
        if (top == null) {
            top = new Node<>(data);
            stackSize++;
        } else {
            Node<T> node = new Node<>(data);
            node.setNext(top);
            // top.setNext(new Node(data));
            top = node;
            stackSize++;
        }
    }

    public static class StackOverflowException extends Exception {
    }

    public static class StackUnderflowException extends Exception {
    }
}
