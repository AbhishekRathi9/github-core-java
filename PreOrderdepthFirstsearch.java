import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PreOrderdepthFirstsearch {

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

        TreeNode<Character> aa = new TreeNode<>('A');
        TreeNode<Character> bb = new TreeNode<>('B');
        TreeNode<Character> cc = new TreeNode<>('C');
        TreeNode<Character> dd = new TreeNode<>('D');
        TreeNode<Character> ee = new TreeNode<>('E');
        TreeNode<Character> ff = new TreeNode<>('F');
        TreeNode<Character> gg = new TreeNode<>('G');
        TreeNode<Character> hh = new TreeNode<>('H');
        TreeNode<Character> xx = new TreeNode<>('X');

        aa.setLeft(bb);
        aa.setRight(cc);
        bb.setLeft(dd);
        bb.setRight(ee);
        cc.setLeft(ff);
        cc.setRight(gg);
        dd.setLeft(hh);
        hh.setRight(xx);

        //                 1
        //                / \
        //               2   2
        //              / \  / \
        //             3   4 4  3

        TreeNode<Integer> one = new TreeNode<>(1);
        TreeNode<Integer> twoLeft = new TreeNode<>(2);
        TreeNode<Integer> twoRight = new TreeNode<>(2);
        TreeNode<Integer> threeLeft = new TreeNode<>(3);
        TreeNode<Integer> fourLeft = new TreeNode<>(4);
        TreeNode<Integer> threeRight = new TreeNode<>(3);
        TreeNode<Integer> fourRight = new TreeNode<>(4);
        one.setLeft(twoLeft);
        one.setRight(twoRight);
        twoLeft.setLeft(threeLeft);
        twoLeft.setRight(fourRight);
        twoRight.setLeft(fourLeft);
        twoRight.setRight(threeRight);
        PreOrderdepthFirstsearch dfs = new PreOrderdepthFirstsearch();

        // dfs.preOrderTraversing(a);
        // dfs.preOrderTraversingIteratively(a);
        // dfs.inOrderTraversing(a);
        //dfs.postOrderTraversing(a);
        //dfs.levelTraversal(a);
        // System.out.println(dfs.isSame(a, aa));
        //System.out.println(dfs.isSameIteratively(a, aa));
        //System.out.println(dfs.isMirrorRecursively(one));
        //System.out.println(dfs.isMirrorIteratively(one));
        //        System.out.println(dfs.maxDepth(a));;
        //        System.out.println(dfs.maxDepthIteratively(a));
        dfs.balancedBinaryTreeRecursive(a);
        dfs.balancedBinaryTreeIterative(a);
      //  dfs.lowestCommonAncestor(one,twoRight,threeRight)
    }

    private int balancedBinaryTreeIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = balancedBinaryTreeIterative(root.getLeft());
        if (left == -1) {
            return -1;
        }
        int right = balancedBinaryTreeIterative((root.getRight()));
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Integer.max(left, right) + 1;
    }

    private boolean balancedBinaryTreeRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = maxDepth(root.getLeft());
        int right = maxDepth(root.getRight());

        if (Math.abs(left - right) > 1) {
            return false;
        }
        return balancedBinaryTreeRecursive(root.getLeft()) && balancedBinaryTreeRecursive(root.getRight());

        // return false;
    }

    private int maxDepthIteratively(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int level = queue.size();
            while (level != 0) {
                TreeNode node = queue.poll();
                if (node.getLeft() == null && node.getRight() == null) {
                    return depth;
                }
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
                level--;
                depth++;
            }
        }
        return depth;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.getLeft());
        int right = maxDepth(root.getRight());

        return Integer.max(left, right) + 1;
    }

    private boolean isMirrorIteratively(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.getLeft());
        queue.add(root.getRight());
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.getData() != rightNode.getData()) {
                return false;
            }

            queue.add(leftNode.getLeft());
            queue.add(rightNode.getRight());
            queue.add(leftNode.getRight());
            queue.add(rightNode.getLeft());
        }
        return true;
    }

    private boolean isMirrorRecursively(TreeNode<Integer> root) {
        if (root == null) {
            return true;
        }

        return isMirrorHelper(root.getLeft(), root.getRight());
    }

    private boolean isMirrorHelper(TreeNode<Integer> left, TreeNode<Integer> right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.getData().equals(right.getData()) && isMirrorHelper(left.getLeft(), right.getRight()) && isMirrorHelper(left.getRight(),
                right.getLeft());
    }

    private boolean isSameIteratively(TreeNode<Character> p, TreeNode<Character> q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(p);
        queue2.add(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = ((LinkedList<TreeNode>) queue1).pop();
            TreeNode node2 = ((LinkedList<TreeNode>) queue2).pop();

            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }

            if (node1.getData() != node2.getData()) {
                return false;
            }

            queue1.add(node1.getLeft());
            queue1.add(node1.getRight());
            queue2.add(node2.getLeft());
            queue2.add(node2.getRight());
        }

        return true;
    }

    private boolean isSame(TreeNode<Character> p, TreeNode<Character> q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.getData() == q.getData() && isSame(p.getLeft(), q.getLeft()) && isSame(p.getRight(), q.getRight());
    }

    private List<List<Character>> levelTraversal(TreeNode<Character> node) {

        List<List<Character>> result = new ArrayList<>();
        if (node == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            List<Character> level = new ArrayList<>();
            int levelSize = queue.size();
            while (levelSize != 0) {
                TreeNode<Character> treeNode = queue.poll();
                level.add(treeNode.getData());
                if (treeNode.getLeft() != null) {
                    queue.add(treeNode.getLeft());
                }
                if (treeNode.getRight() != null) {
                    queue.add(treeNode.getRight());
                }
                levelSize--;
            }

            result.add(level);
        }
        System.out.println(result);
        return result;
    }

    private void preOrderTraversingIteratively(TreeNode<Character> node) {
        if (node == null) {
            return;
        }
        List<Character> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            TreeNode<Character> pop = stack.pop();
            result.add(pop.getData());

            if (pop.getRight() != null) {
                stack.add(pop.getRight());
            }
            if (pop.getLeft() != null) {
                stack.add(pop.getLeft());
            }
        }

        System.out.println(result);
    }

    private void postOrderTraversing(TreeNode<Character> node) {
        if (node == null) {
            return;
        }
        postOrderTraversing(node.getLeft());
        postOrderTraversing(node.getRight());
        System.out.println(node.getData());
    }

    private void inOrderTraversing(TreeNode<Character> node) {
        if (node == null) {
            return;
        }
        inOrderTraversing(node.getLeft());
        System.out.println(node.getData());
        inOrderTraversing(node.getRight());
    }

    private void preOrderTraversing(TreeNode<Character> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getData());
        preOrderTraversing(node.getLeft());
        preOrderTraversing(node.getRight());
    }
}
