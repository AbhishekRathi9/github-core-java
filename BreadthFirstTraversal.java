import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTraversal {

    public static void main(String[] args) {
        TreeNode<Character> a = new TreeNode<>('A');
        TreeNode<Character> b = new TreeNode<>('B');
        TreeNode<Character> c = new TreeNode<>('C');
        TreeNode<Character> d = new TreeNode<>('D');
        TreeNode<Character> e = new TreeNode<>('E');
        TreeNode<Character> f = new TreeNode<>('F');
        TreeNode<Character> g = new TreeNode<>('G');
        TreeNode<Character> h = new TreeNode<>('H');
        TreeNode<Character> x = new TreeNode<>('X');

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);
        d.setLeft(h);
        h.setRight(x);

        BreadthFirstTraversal bft = new BreadthFirstTraversal();
        bft.traverse(a);
    }

    private void traverse(TreeNode<Character> a) {
        if (a == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(a);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.println(poll.getData());
            if (poll.getLeft() != null) {
                queue.add(poll.getLeft());
            }
            if (poll.getRight() != null) {
                queue.add(poll.getRight());
            }
        }
    }
}
