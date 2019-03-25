import java.util.HashSet;
import java.util.Set;

public class ListNode<T extends Comparable<T>> {

    private Node<T> head;
    static Node left;

    public ListNode() {
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        ListNode list2 = new ListNode();
        list2.add(1);

        // addTwoNumbers(list1, list2);
        // list1.reverse();
        // list1.reverseRecursively();
        pairwiseSwapBetterApproach(list1);
        list1.print();
        //        list1.add(7);
        //        list1.add(7);
        // list1.add(8);
        //   list1.add(9);

        //        MyLinkedList list2 = new MyLinkedList();
        //        list2.add(6);
        //        list2.add(3);
        //        list2.add(5);
        //        list2.add(9);

        //addLists(list1, list2);

        // pairwiseSwap(list1);
        // paireiseSwapRecursively(list1.head);
        //        list1.print();

        // pairwiseSwapBetterApproachRecursive(list1);
        ////  Node node = groupSizeSwap(list1.head, 3);
        //  list1.head = node;

        // removeDuplicatesFromSorted(list1);
        // list1.print();
        // list.print();
        // findPalindromeRecursively(list.head, list.head);

        // removeDuplicates(list);
        // removeDuplicatesUsingSet(list);
        // list.print();

        //findLoop(list);

        //findloopUsingPerimeter(list);

        //        Node middle = findMiddle(list);
        //
        //        MyLinkedList newList = new MyLinkedList();
        //        Node newHead = middle.getNext();
        //        newList.head = newHead;
        //        middle.setNext(null);
        //
        //        list.print();
        //        newList.reverse();
        //        newList.print();
        //
        //        Node temp = list.head;
        //        Node newTemp = newList.head;
        //
        //        while (temp != null && newTemp != null) {
        //            if (temp.getData() != newTemp.getData()) {
        //                System.out.println("not palindrome");
        //                break;
        //            }
        //            temp = temp.getNext();
        //            newTemp = newTemp.getNext();
        //        }
        //
        //        System.out.println("palindrome");

        //        list.add(5);
        //        // list.print();
        //        list.addAtIndex(5, 0);
        //        list.addAtIndex(10, 1);
        //                list.addAtIndex(20, 2);
        //                list.addAtIndex(30, 3);
        //                list.addAtIndex(40, 4);
        //                list.addAtIndex(15, 2);
        //                list.addAtIndex(35, 5);
        //                list.addAtIndex(45, 7);
        // list.removeFromEnd();
        //list.remove(45);

        //        list.print();
        //        // list.reverse();
        //        //list.print();
        //        list.printReverse();
        //        System.out.println("printing reverse recursively");
        //       list.print();

        //Merge two sorted lists
        //        MyLinkedList list1 = new MyLinkedList();
        //        MyLinkedList list2 = new MyLinkedList();
        //        MyLinkedList joinedList = new MyLinkedList();
        //
        //        list1.add(10);
        //        list1.add(50);
        //        list1.add(70);
        //        list1.add(90);
        //        list1.add(100);
        //
        //        // list1.reverseRecursively();
        //        list1.reverse();
        //        list1.print();
        //
        //        list2.add(20);
        //        list2.add(30);
        //        list2.add(40);
        //        list2.add(60);
        //        list2.add(80);

        // joinedIteratively(list1, list2, joinedList);

        //        Node node = joinRecursively(list1.head, list2.head);
        //        joinedList.head = node;
        //        joinedList.print();
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Node head1 = l1.head;
        Node head2 = l2.head;
        int carry = 0;
        ListNode result = new ListNode();
        while (head1 != null || head2 != null) {
            int digit1 = 0;
            int digit2 = 0;
            if (head1 != null) {
                digit1 = (int) head1.getData();
                head1 = head1.getNext();
            }
            if (head2 != null) {
                digit2 = (int) head2.getData();
                head2 = head2.getNext();
            }

            int sum = digit1 + digit2 + carry;
            int sumNode = sum % 10;
            if (sum / 10 > 0) {
                carry = sum / 10;
            }
            result.add(sumNode);
        }

        if (carry != 0) {
            result.add((carry));
        }
        result.print();
        return result;
    }

    private static void removeDuplicatesFromSorted(ListNode list1) {

        Node current = list1.head;
        Node next = current.getNext();

        while (next != null) {
            if (current.getData() != next.getData()) {
                current = next;
                next = next.getNext();
            } else {
                while (next != null && current.getData() == next.getData()) {
                    next = next.getNext();
                }
                current.setNext(next);
            }
        }
    }

    private static Node groupSizeSwap(Node head, int groupSize) {
        if (head == null) {
            return head;
        }
        Node previous = null;
        Node current = head;
        int temp = groupSize;
        while (temp > 0 && current != null) {
            Node next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
            temp--;
        }
        Node node = groupSizeSwap(current, groupSize);
        head.setNext(node);
        return previous;
    }

    private static void pairwiseSwapBetterApproachRecursive(ListNode list1) {

        Node node = recursiveSwap(list1.head, list1.head.getNext());
        list1.head = node;
    }

    private static Node recursiveSwap(Node current, Node next) {
        if (next.getNext() == null || next.getNext().getNext() == null) {
            current.setNext(next.getNext());
            next.setNext(current);

            return next;
        }
        Node previous = recursiveSwap(next.getNext(), next.getNext().getNext());
        next.setNext(current);
        current.setNext(previous);
        return next;
    }

    private static void pairwiseSwapBetterApproach(ListNode list) {
        Node previous = list.head;
        Node current = previous.getNext();
        list.head = current;
        while (true) {
            Node next = current.getNext();
            current.setNext(previous);
            while (next != null && next.getNext() != null) {
                previous.setNext(next);
                return;
            }
            previous.setNext(next.getNext());
            previous = next;
            current = previous.getNext();
        }
    }

    private static void paireiseSwapRecursively(Node head) {
        Node current = head;
        // Node next = current.getNext();

        if (current != null && current.getNext() != null) {
            int temp = (int) current.getData();
            current.setData(current.getNext().getData());
            current.getNext().setData(temp);
            paireiseSwapRecursively(current.getNext().getNext());
        }
    }

    private static void pairwiseSwap(ListNode list) {

        // 1-->2-->3-->4-->5-->6
        Node current = list.head;
        // Node next = current.getNext();

        while (current != null && current.getNext() != null) {
            int temp = (int) current.getData();
            current.setData(current.getNext().getData());
            current.getNext().setData(temp);
            current = current.getNext().getNext();
            // next = current.getNext();
        }
        list.print();
    }

    private static void addLists(ListNode list1, ListNode list2) {
        list1.reverse();
        list2.reverse();

        Node temp1 = list1.head;
        Node temp2 = list2.head;
        ListNode sumList = new ListNode();
        int cary = 0;
        int sum;
        int data;
        while (temp1 != null || temp2 != null) {
            sum = cary;

            if (temp1 != null) {
                data = temp1.getData() == null ? 0 : (int) temp1.getData();
                sum = cary + data;
                temp1 = temp1.getNext();
            }

            if (temp2 != null) {
                data = temp2.getData() == null ? 0 : (int) temp2.getData();
                sum = sum + data;
                temp2 = temp2.getNext();
            }

            int newSumNode = sum % 10;
            cary = sum / 10;
            sumList.add(newSumNode);
        }
        if (cary != 0) {
            sumList.add(cary);
        }

        sumList.reverse();
        sumList.print();
    }

    private static void findloopUsingPerimeter(ListNode list) {
        createCycle(list);
        Node slow = detectCycle(list);
        int perimeter = getPerimeter(slow);
        detectAndRemoveCycle(list, perimeter);
    }

    private static void detectAndRemoveCycle(ListNode list, int perimeter) {
        Node start = list.head;
        Node end = start;
        while (perimeter > 0) {
            end = end.getNext();
            perimeter--;
        }
        Node previous = null;
        while (end.getData() != start.getData()) {
            previous = end;
            start = start.getNext();
            end = end.getNext();
        }
        previous.setNext(null);
        list.print();
    }

    private static int getPerimeter(Node slow) {
        Node temp = slow;
        int length = 0;
        while (temp.getNext().getData() != slow.getData()) {
            length++;
            temp = temp.getNext();
        }
        length++;
        return length;
    }

    private static void findLoop(ListNode list) {
        createCycle(list);
        // list.print();

        Node slow = detectCycle(list);

        Node start = list.head;
        Node previous = null;
        while (start.getData() != slow.getData()) {
            start = start.getNext();
            previous = slow;
            slow = slow.getNext();
        }
        previous.setNext(null);
        System.out.println("start of loop is -->" + slow.getData());
        list.print();
    }

    private static Node detectCycle(ListNode list) {
        Node slow = list.head;
        Node fast = list.head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow.getData() == fast.getData()) {
                System.out.println("there is a cycle");
                break;
            }
        }
        return slow;
    }

    private static void createCycle(ListNode list) {
        Node temp = list.head;
        while (!temp.getData().equals(16)) {
            temp = temp.getNext();
        }

        Node end = temp;
        while (end.getNext() != null) {
            end = end.getNext();
        }
        end.setNext(temp);
    }

    private static void removeDuplicatesUsingSet(ListNode list) {
        Set set = new HashSet();

        Node current = list.head;
        Node previous = list.head;
        while (current != null) {

            if (set.contains(current.getData())) {
                //duplicate
                previous.setNext(current.getNext());
                current = current.getNext();
                continue;
            } else {
                set.add(current.getData());
            }
            previous = current;
            current = current.getNext();
        }
    }

    private static void removeDuplicates(ListNode list) {

        Node outer = list.head;
        Node inner;

        while (outer != null && outer.getNext() != null) {
            inner = outer;
            while (inner.getNext() != null) {
                if (outer.getData() == inner.getNext().getData()) {
                    inner.setNext(inner.getNext().getNext());
                } else {
                    inner = inner.getNext();
                }
            }
            outer = outer.getNext();
        }
    }

    private static boolean findPalindromeRecursively(Node head, Node node) {
        if (node == null) {
            return true;
        }
        left = head;

        if (!findPalindromeRecursively(left, node.getNext())) {
            return false;
        }

        boolean isPal = left.getData() == node.getData();
        left = left.getNext();
        return isPal;
    }

    private static Node findMiddle(ListNode list) {
        Node slow = list.head;
        Node fast = list.head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

    private static Node joinRecursively(Node head1, Node head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node head;
        if (head1.getData().compareTo(head2.getData()) < 0) {
            head = new Node(head1.getData());
            head.setNext(joinRecursively(head1.getNext(), head2));
        } else {
            head = new Node(head2.getData());
            head.setNext(joinRecursively(head1, head2.getNext()));
        }

        return head;
    }

    private static void joinedIteratively(ListNode list1, ListNode list2, ListNode joinedList) {
        Node head1 = list1.head;
        Node head2 = list2.head;
        //        if(head1.getData().compareTo(head2.getData())<0){
        //            joinedList.head=new Node(head1.getData());
        //
        //        } else{
        //            joinedList.head=new Node(head2.getData());
        //        }

        Node temp = null;
        // Node temp2=null;
        while (head1 != null && head2 != null) {
            if (head1.getData().compareTo(head2.getData()) < 0) {
                temp = createJoinedLink(joinedList, head1);
                head1 = head1.getNext();
            } else {
                temp = createJoinedLink(joinedList, head2);
                head2 = head2.getNext();
            }
        }

        while (head1 != null) {
            temp = joinedList.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(head1.getNext());
            head1 = head1.getNext();
        }

        while (head2 != null) {
            temp = joinedList.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(head2.getNext());
            head2 = head2.getNext();
        }

        joinedList.print();
    }

    private static Node createJoinedLink(ListNode joinedList, Node head) {
        Node temp = null;
        if (joinedList.head == null) {
            joinedList.head = new Node(head.getData());
        } else {
            temp = joinedList.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(head.getData()));
        }

        return temp;
    }

    private void reverseRecursively() {
        Node node = recursiveReverse(head);
        node.setNext(null);
    }

    private Node recursiveReverse(Node node) {
        if (node.getNext() == null) {
            head = node;
            return node;
        }
        Node returnedNode = recursiveReverse(node.getNext());
        returnedNode.setNext(node);
        return node;
    }

    private void printReverse() {
        System.out.println("printing reverse");
        printRecursively(head);
    }

    private void printRecursively(Node node) {

        if (node == null) {
            return;
        } else {
            printRecursively(node.getNext());
            System.out.println(node.getData());
        }
    }

    private void reverse() {
        Node previous = null;
        Node current = head;
        Node next = head;

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    private void remove(T data) {
        if (head == null) {
            System.out.println("cant be removed.List is empty");
        } else if (count() == 1 && head.getData() == data) {
            head = null;
        } else {
            Node<T> current = head;
            Node<T> previous = head;
            if (current.getData() == data) {
                head = head.getNext();
            }
            while (current.getNext() != null) {
                previous = current;
                current = current.getNext();
                if (current.getData() == data) {
                    previous.setNext(current.getNext());
                    break;
                }
            }
            if (current.getNext() == null) {
                System.out.println("not found");
            }
        }
    }

    private void removeFromEnd() {
        if (count() == 0) {
            System.out.println("list is empty. nothing to be removed");
        } else if (count() == 1) {
            head = null;
        } else {
            Node<T> current = head;
            Node<T> previous = head;
            while (current.getNext() != null) {
                previous = current;
                current = current.getNext();
            }
            previous.setNext(null);
        }
    }

    private void addAtIndex(T data, int index) {
        if (index > count()) {
            return;
        }
        if (index == 0) {
            Node<T> temp = head;
            head = new Node<>(data);
            head.setNext(temp);
        } else {
            Node<T> current = head;
            Node<T> previous = head;
            while (index > 0) {
                index--;
                previous = current;
                current = current.getNext();
            }
            previous.setNext(new Node(data));
            previous.getNext().setNext(current);
        }
    }

    private int count() {
        if (head == null) {
            return 0;
        } else {
            Node<T> temp = head;
            int count = 0;
            while (temp != null) {
                count = count + 1;
                temp = temp.getNext();
            }
            return count;
        }
    }

    private void print() {
        Node<T> temp = head;
        if (temp == null) {
            System.out.println("list is empty");
        } else {
            while (temp != null) {
                System.out.println(temp.getData());
                temp = temp.getNext();
            }
        }
    }

    private void add(T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(data));
        }
    }
}
