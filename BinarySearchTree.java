public class BinarySearchTree {

    public static void main(String[] args) {

        TreeNode<Integer> one = new TreeNode<>(1);
        TreeNode<Integer> two = new TreeNode<>(2);
        TreeNode<Integer> three = new TreeNode<>(3);
        TreeNode<Integer> four = new TreeNode<>(4);
        TreeNode<Integer> five = new TreeNode<>(5);
        TreeNode<Integer> six = new TreeNode<>(6);
        TreeNode<Integer> seven = new TreeNode<>(7);
        TreeNode<Integer> eight = new TreeNode<>(8);
        TreeNode<Integer> nine = new TreeNode<>(9);

        BinarySearchTree bst = new BinarySearchTree();
        TreeNode<Integer> head = bst.insert(null, five);
        bst.insert(head, one);
        bst.insert(head, seven);
        bst.insert(head, three);
        bst.insert(head, eight);
        bst.insert(head, two);
        bst.insert(head, nine);
        bst.insert(head, six);
        bst.insert(head, four);

        // bst.print(head);

        System.out.println( bst.lowestCommonancestor(head, two, four).getData());;

        bst.lookUp(head, nine);

        System.out.println(bst.findMin(head));

        System.out.println(bst.maxDepth(head));

        bst.mirror(head);

        System.out.println(bst.countTrees(5));

        bst.printRange(head, 4, 8);

        //  bst.isBST(head);
    }

    private TreeNode lowestCommonancestor(TreeNode<Integer> head, TreeNode<Integer> two, TreeNode<Integer> four) {
        if (two.getData() < head.getData() && four.getData() < head.getData()) {
            return lowestCommonancestor(head.getLeft(), two, four);
        } else if (two.getData() > head.getData() && four.getData() > head.getData()) {
            return lowestCommonancestor(head.getRight(), two, four);
        }
        return head;
    }

    private void printRange(TreeNode<Integer> head, int low, int high) {
        if (head == null) {
            return;
        }
        if (low <= head.getData()) {
            printRange(head.getLeft(), low, high);
        }
        if (head.getData() >= low && head.getData() < high) {
            System.out.println(head.getData());
        }
        if (low < head.getData()) {
            printRange(head.getRight(), low, high);
        }
    }

    private int countTrees(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        for (int k = 1; k <= number; k++) {
            left = countTrees(k - 1);
            right = countTrees(number - k);
            sum = sum + left * right;
        }
        return sum;
    }

    private void mirror(TreeNode<Integer> head) {
        if (head == null) {
            return;
        }
        mirror((head.getLeft()));
        mirror(head.getRight());

        TreeNode temp = head.getLeft();
        head.setLeft(head.getRight());
        head.setRight(temp);
    }

    private int maxDepth(TreeNode<Integer> head) {
        if (head == null) {
            return 0;
        }
        int left = maxDepth(head.getLeft());
        int right = maxDepth(head.getRight());
        return Math.max(left, right) + 1;
    }

    private Integer findMin(TreeNode<Integer> head) {
        if (head.getLeft() == null) {
            return head.getData();
        }
        return findMin(head.getLeft());
    }

    private void lookUp(TreeNode<Integer> head, TreeNode<Integer> node) {
        if (head == null) {
            System.out.println("not found");
            return;
        }
        if (head.getData() == node.getData()) {
            System.out.println("found");
            return;
        }
        if (node.getData() < head.getData()) {
            lookUp(head.getLeft(), node);
        }
        if (node.getData() > head.getData()) {
            lookUp(head.getRight(), node);
        }
    }

    private void print(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        print(root.getLeft());
        System.out.print(root.getData() + "->");
        print(root.getRight());
    }

    private TreeNode<Integer> insert(TreeNode<Integer> head, TreeNode<Integer> node) {
        if (head == null) {
            return node;
        }
        if (node.getData() <= head.getData()) {
            if (head.getLeft() == null) {
                head.setLeft(node);
            } else {
                insert(head.getLeft(), node);
            }
        } else {
            if (head.getRight() == null) {
                head.setRight(node);
            } else {
                insert(head.getRight(), node);
            }
        }
        return head;
    }
}

   
