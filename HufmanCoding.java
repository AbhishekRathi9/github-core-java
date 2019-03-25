import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HufmanCoding {

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        int[] frequency = {2, 6, 3, 9, 8};

        applyLogic(chars, frequency);
    }

    private static void applyLogic(char[] chars, int[] frequency) {
        PriorityQueue<HufmanNode> queue = new PriorityQueue<>(new Comparator<HufmanNode>() {
            @Override
            public int compare(HufmanNode o1, HufmanNode o2) {
                return o1.getFrequency() - o2.getFrequency();
            }
        });

        for (int i = 0; i < frequency.length; i++) {
            queue.add(new HufmanNode(chars[i], frequency[i]));
        }

        HufmanNode head = new HufmanNode();

        while (!queue.isEmpty()) {
            HufmanNode node1 = queue.poll();
            HufmanNode node2 = queue.poll();

            if (node2 == null) {
                head = node1;
                continue;
            }
            HufmanNode newNode = new HufmanNode('-', node1.getFrequency() + node2.getFrequency());

            newNode.setLeft(node1);
            newNode.setRight(node2);

            queue.add(newNode);
        }

        print(head, "");
    }

    private static void print(HufmanNode head, String code) {
        if (head.getLeft() == null && head.getRight() == null) {
            System.out.println("leaf node is" + head.getCharacter());
            System.out.println("code is" + code);
            return;
        }
        print(head.getLeft(), code+1);
        print(head.getRight(), code+0);
    }

    static class HufmanNode {

        private char character;
        private int frequency;
        private HufmanNode left;
        private HufmanNode right;

        public HufmanNode(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        public HufmanNode() {

        }

        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        public HufmanNode getLeft() {
            return left;
        }

        public void setLeft(HufmanNode left) {
            this.left = left;
        }

        public HufmanNode getRight() {
            return right;
        }

        public void setRight(HufmanNode right) {
            this.right = right;
        }
    }
}
