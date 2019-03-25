import java.util.Stack;

public class LinkWithTwoStacks<T> {

    Stack<T> forward = new Stack<>();
    Stack<T> reverse = new Stack<>();
    private int MAX_SIZE = 5;

    public static void main(String[] args) throws queueOverflowException,queueUnderflowException {
        LinkWithTwoStacks<Integer> list = new LinkWithTwoStacks<>();
        list.enqueue(1);
        list.enqueue(2);
        list.enqueue(3);
        list.enqueue(4);
        list.enqueue(5);
        list.dequeue();
        list.dequeue();
        list.dequeue();
        list.dequeue();
        list.dequeue();
    }

    private void dequeue() throws queueUnderflowException {
        if(isEmpty()){
            throw new queueUnderflowException();
        }
        if(forward.isEmpty()){
            reverse.pop();
        } else {
            while(!forward.isEmpty()){
                reverse.add(forward.pop());
            }
            reverse.pop();
        }
    }

    private boolean isFull() {
        if (forward.size() == MAX_SIZE || reverse.size() == MAX_SIZE) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmpty(){
        if (forward.size() == 0 && reverse.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void enqueue(T data) throws queueOverflowException {
        if(isFull()){
            throw new queueOverflowException();
        }
        if(reverse.isEmpty()){
            forward.add(data);
        } else{
            while(!reverse.isEmpty()){
                forward.add(reverse.pop());
            }
            forward.add(data);
        }
    }

    private static class queueOverflowException extends Exception {

    }

    private static class queueUnderflowException extends Exception {

    }
}
