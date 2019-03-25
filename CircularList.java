import java.lang.reflect.Array;
import java.util.Arrays;

public class CircularList<T> {

    private T[] elements;
    private int MAX_SIXE = 5;
    private int headIndex = -1;
    private int tailIndex = -1;

    public CircularList(Class<T> integerClass) {
        elements = (T[]) Array.newInstance(integerClass, MAX_SIXE);
    }

    public static void main(String[] args) throws queueOverflowException, queueUnderflowException {

        CircularList<Integer> list = new CircularList<>(Integer.class);
        list.enqueue(1);
        list.enqueue(2);
        list.enqueue(3);
        list.enqueue(4);
        list.enqueue(5);
        System.out.println(list.dequeue());
        list.enqueue(2);
        list.print();
    }

    private T dequeue() throws queueUnderflowException {
        if (isEmpty()) {
            throw new queueUnderflowException();
        }
        T data = elements[headIndex];
        if(headIndex==tailIndex){
            headIndex=-1;
            tailIndex=-1;
        }else{
            headIndex = (headIndex + 1) % elements.length;

        }
//        if(nextHeadIndex )
        return data;
    }

    private void print() {
        System.out.println(Arrays.toString(elements));
    }

    private boolean isFull() {
        int tailNextIndex = (tailIndex + 1) % elements.length;
        if (tailNextIndex == headIndex) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmpty() {
        return headIndex == -1;
    }

    private void enqueue(T data) throws queueOverflowException {
        if (isFull()) {
            throw new queueOverflowException();
        }
        if (headIndex == -1) {
            headIndex++;
            tailIndex++;
            elements[headIndex] = data;
        } else {
            tailIndex = (tailIndex + 1) % elements.length;
            elements[tailIndex] = data;
        }
    }

    private static class queueOverflowException extends Exception {

    }

    private static class queueUnderflowException extends Exception {

    }
}
