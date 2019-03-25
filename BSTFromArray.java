package BinaryTreeSeries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BSTFromArray {

    TreeNode root;
    int lastLevel = -1;

    public static void main(String[] args) {
        int[] array = {12, 18, 11, 1, 3, 20, 17, 19};
        // int[] array = {15, 9, 6};
        BSTFromArray bstFromArray = new BSTFromArray();
        for (int num : array) {
            bstFromArray.createBST(num, null);
        }

        // System.out.println(bstFromArray.leftLeavesSum());

        // System.out.println(bstFromArray.leftLeavesSumDFS());
        // System.out.println(bstFromArray.leftLeavesSumBFS());

        bstFromArray.iterativeInOrderTraversal();
        //   bstFromArray.iterativePreOrderTraversal();
        // bstFromArray.iterativePostOrderTraversal();

        // bstFromArray.recursiveInOrderTraversal();
        // bstFromArray.recursivePreOrderTraversal();
        //bstFromArray.nodeAtKDistance(2);
        // bstFromArray.allAncestorsOfGivenNode(new BST(3));
        //        Map<Integer, Integer> childParentMap = bstFromArray.allAncestorsOfGivenNodeIteratively(new BST(3));
        //        printResult(childParentMap, new BST(3));
        // bstFromArray.isSubTree(new BST(3), new BST(3));
        // System.out.println( bstFromArray.sumOfAllNodes());
        // System.out.println(bstFromArray.isSumTree());
        //        System.out.println(bstFromArray.countLeafNodes());
        //        System.out.println(bstFromArray.countNonLeafNodes());
        //        System.out.println(bstFromArray.countAllNodes());
        //System.out.println(bstFromArray.printAllRootToLeafPaths());
        //  System.out.println(bstFromArray.printAllRootToLeafPathsBFSIteratively());
        // bstFromArray.printAllDiagonalsUsingMap();
        // bstFromArray.printDiagonalsUsingQueue();

        //        bstFromArray.verticalOrderTraversalRecursivelyUsingMap();
        //        bstFromArray.verticalOrderTraversalIterativelyUsingMap();

        // bstFromArray.leftViewUsingLevelOrderTraversal();
        // bstFromArray.leftViewUsingLevelAndRecusrsion();
        // bstFromArray.leftViewUsingLevelsAndRecursion();
        //       bstFromArray.lowestCommonAncestor(new BST(1), new BST(3));
        //  bstFromArray.lowestCommonAncestorRecursion(new BST(1), new BST(3));

        // bstFromArray.nodesWithLeaves(2);
        //        bstFromArray.spiralTraversalUsingStacks();
        //        bstFromArray.spiralLevelOrderTraversal();

        //System.out.println(bstFromArray.hasPathSum(47));
        // System.out.println( bstFromArray.hasPathSumBfsIteratively(47));;
        //System.out.println(bstFromArray.hasPathSumDFSIteratively(47));
        //System.out.println(bstFromArray.pathSumii(47));
        //  System.out.println(bstFromArray.pathSumIII(4));
        // System.out.println(bstFromArray.pathSumIIIPrefix(4));
        //System.out.println( bstFromArray.diameter());;
        // System.out.println(bstFromArray.findTarget(4));
        ;
    }

    private int leftLeavesSumBFS() {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                if (poll.left.left == null && poll.left.right == null) {
                    sum = sum + poll.left.val;
                } else {
                    queue.add(poll.left);
                }
            }
            if (poll.right != null) {
                if (poll.right.left != null || poll.right.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return sum;
    }

    private int leftLeavesSumDFS() {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.left != null) {
                if (pop.left.left == null && pop.left.right == null) {
                    sum = sum + pop.left.val;
                } else {
                    stack.add(pop.left);
                }
            }
            if (pop.right != null) {
                if (pop.right.left != null || pop.right.right != null) {
                    stack.add(pop.right);
                }
            }
        }

        return sum;
    }

    private int leftLeavesSum() {
        if (root == null) {
            return 0;
        }

        return leftLeavesSum(root);
    }

    private int leftLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + leftLeavesSum(root.right);
        }
        return leftLeavesSum(root.left) + leftLeavesSum(root.right);
    }

    private boolean findTarget(int k) {
        Set<Integer> set = new HashSet<>();
        return findTarget(root, k, set);
    }

    private boolean findTarget(TreeNode root, int k, Set<Integer> set) {

        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);

        boolean left = findTarget(root.left, k, set);
        if (left) {
            return true;
        }
        boolean right = findTarget(root.right, k, set);
        if (right) {
            return true;
        }
        return left || right;
    }

    private int diameter() {
        return diameter(root);
    }

    private int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);

        return Integer.max(lHeight + rHeight, Integer.max(lDiameter, rDiameter));
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Integer.max(height(root.left), height(root.right));
    }

    private int pathSumIIIPrefix(int sum) {

        Map<Integer, Integer> prefixMap = new HashMap<>();
        return pathSumIIIPrefix(prefixMap, sum, root, 0);
    }

    private int pathSumIIIPrefix(Map<Integer, Integer> prefixMap, int target, TreeNode node, int currentSum) {

        if (node == null) {
            return 0;
        }
        currentSum = currentSum + node.val;

        int res = prefixMap.getOrDefault(currentSum - target, 0);

        prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);

        res += pathSumIIIPrefix(prefixMap, target, node.left, currentSum) + pathSumIIIPrefix(prefixMap, target, node.right, currentSum);
        prefixMap.put(currentSum, prefixMap.get(currentSum - 1));
        return res;
    }

    private int pathSumIII(int sum) {
        return pathSumIII(root, sum);
    }

    private int pathSumIII(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumIIIRecursive(root, sum) + pathSumIII(root.left, sum) + pathSumIII(root.right, sum);
    }

    private int pathSumIIIRecursive(TreeNode root, int sum) {
        int count = 0;
        if (root == null) {
            return count;
        }
        if (root.val == sum) {
            count++;
        }
        count = count + pathSumIIIRecursive(root.left, sum - root.val);
        count = count + pathSumIIIRecursive(root.right, sum - root.val);

        return count;
    }

    private List<List<Integer>> pathSumii(int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();

        pathSumii(root, sumList, sum, result);
        return result;
    }

    private void pathSumii(TreeNode root, List<Integer> sumList, int sum, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        sumList.add(root.val);
        if (root.left == null && root.right == null && sum - root.val == 0) {
            result.add(new ArrayList<>(sumList));
        }
        pathSumii(root.left, sumList, sum - root.val, result);
        pathSumii(root.right, sumList, sum - root.val, result);
        sumList.remove(sumList.size() - 1);
    }

    private boolean hasPathSumDFSIteratively(int sum) {
        return hasPathSumDFSIteratively(root, sum);
    }

    private boolean hasPathSumDFSIteratively(TreeNode head, int sum) {
        if (head == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        stack.add(head);
        sumStack.add(0);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            Integer currentSum = sumStack.pop();
            if (pop.left == null && pop.right == null && sum == currentSum + pop.val) {
                return true;
            }
            if (pop.left != null) {
                stack.add(pop.left);
                sumStack.add(currentSum + pop.val);
            }
            if (pop.right != null) {
                stack.add(pop.right);
                sumStack.add(currentSum + pop.val);
            }
        }
        return false;
    }

    private boolean hasPathSumBfsIteratively(int sum) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        queue.add(root);
        sumQueue.add(0);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            Integer currentSum = sumQueue.remove();

            if (poll.left == null && poll.right == null && sum == currentSum + poll.val) {
                return true;
            }
            if (poll.left != null) {
                queue.add(poll.left);
                sumQueue.add(currentSum + poll.val);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                sumQueue.add(currentSum + poll.val);
            }
        }
        return false;
    }

    private boolean hasPathSum(int sum) {
        return hasPathSum(root, sum);
    }

    private boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }

        boolean left = hasPathSum(root.left, sum - root.val);
        if (left) {
            return true;
        }
        boolean right = hasPathSum(root.right, sum - root.val);
        if (right) {
            return true;
        }

        return left || right;
    }

    private List<List<Integer>> spiralLevelOrderTraversal() {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> levelResult = new ArrayList<>();
            for (int i = 0; i < level; i++) {

                TreeNode poll = queue.poll();
                if (flag) {
                    levelResult.add(poll.val);
                } else {
                    levelResult.add(0, poll.val);
                }

                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            flag = !flag;
            result.add(levelResult);
        }
        System.out.println(result);
        return result;
    }

    private void spiralTraversalUsingStacks() {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.add(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode pop = stack1.pop();
                System.out.println(pop.val);
                if (pop.left != null) {
                    stack2.add(pop.left);
                }
                if (pop.right != null) {
                    stack2.add(pop.right);
                }
            }
            while (!stack2.isEmpty()) {
                TreeNode pop = stack2.pop();
                System.out.println(pop.val);
                if (pop.right != null) {
                    stack1.add(pop.right);
                }
                if (pop.left != null) {
                    stack1.add(pop.left);
                }
            }
        }
    }

    private void nodesWithLeaves(int leaves) {
        nodesWithKLeavesRecursion(root, leaves);
    }

    private int nodesWithKLeavesRecursion(TreeNode head, int leaves) {
        if (head == null) {
            return 0;
        }
        if (head.left == null && head.right == null) {
            return 1;
        }

        int left = nodesWithKLeavesRecursion(head.left, leaves);
        int right = nodesWithKLeavesRecursion(head.right, leaves);
        int totalLeaves = left + right;
        if (totalLeaves == leaves) {
            System.out.println(head.val);
        }
        return totalLeaves;
    }

    private void lowestCommonAncestorRecursion(TreeNode treeNode, TreeNode treeNode1) {
        System.out.println(lowestCommonAncestorRecursion(root, treeNode, treeNode1).val);
    }

    private TreeNode lowestCommonAncestorRecursion(TreeNode head, TreeNode p, TreeNode q) {
        if (head == null) {
            return null;
        }
        if (head.val == p.val || head.val == q.val) {
            return head;
        }
        TreeNode left = lowestCommonAncestorRecursion(head.left, p, q);
        TreeNode right = lowestCommonAncestorRecursion(head.right, p, q);

        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return head;
        }
        return left == null ? right : left;
    }

    private void lowestCommonAncestor(TreeNode treeNode, TreeNode treeNode1) {
        lowestCommonAncestor(root, treeNode, treeNode1);
    }

    private void lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<Integer> path = new ArrayList<>();
        findPath(p, root, path);
        System.out.println(path);
        List<Integer> path2 = new ArrayList<>();
        findPath(q, root, path2);
        System.out.println(path2);
        int i;
        for (i = 0; i < path.size(); i++) {
            if (!path.get(i).equals(path2.get(i))) {
                break;
            }
        }
        System.out.println(path.get(i - 1));
    }

    private boolean findPath(TreeNode target, TreeNode node, List<Integer> path) {
        if (node == null) {
            return false;
        }
        path.add(node.val);
        if (node.val == target.val) {
            return true;
        }
        boolean left = findPath(target, node.left, path);
        if (left) {
            return true;
        }
        boolean right = findPath(target, node.right, path);
        if (right) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    private void leftViewUsingLevelsAndRecursion() {
        leftViewUsingLevelsAndRecursion(0, this.root);
    }

    private void leftViewUsingLevelsAndRecursion(int currentLevel, TreeNode head) {
        if (head == null) {
            return;
        }
        if (currentLevel > lastLevel) {
            System.out.println(head.val);
            lastLevel = currentLevel;
        }
        leftViewUsingLevelsAndRecursion(currentLevel + 1, head.left);
        leftViewUsingLevelsAndRecursion(currentLevel + 1, head.right);
    }

    private void leftViewUsingLevelAndRecusrsion() {
        Map<Integer, Integer> map = new HashMap<>();
        leftViewUsingLevelAndRecusrsion(map, root, 0);
        map.forEach((integer, integer2) -> System.out.println(integer2));
    }

    private void leftViewUsingLevelAndRecusrsion(Map<Integer, Integer> map, TreeNode head, int level) {
        if (head == null) {
            return;
        }
        if (map.containsKey(level)) {
        } else {
            map.put(level, head.val);
        }
        leftViewUsingLevelAndRecusrsion(map, head.left, level + 1);
        leftViewUsingLevelAndRecusrsion(map, head.right, level + 1);
    }

    private void leftViewUsingLevelOrderTraversal() {
        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();

            for (int i = 0; i < level; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    result.add(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        System.out.println(result);
    }

    private void verticalOrderTraversalIterativelyUsingMap() {
        if (root == null) {
            return;
        }
        Map<Integer, List<String>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> distance = new LinkedList<>();
        queue.add(root);
        distance.add(0);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            Integer horizontalDistance = distance.poll();
            if (min > horizontalDistance) {
                min = horizontalDistance;
            }
            if (max < horizontalDistance) {
                max = horizontalDistance;
            }
            if (map.get(horizontalDistance) == null) {
                List<String> path = new ArrayList<>();
                path.add(poll.val + "->");
                map.put(horizontalDistance, path);
            } else {
                List<String> path = map.get(horizontalDistance);
                path.add(poll.val + "->");
            }
            if (poll.left != null) {
                queue.add(poll.left);
                distance.add(horizontalDistance - 1);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                distance.add(horizontalDistance + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                System.out.println(map.get(i));
            }
        }
    }

    private void verticalOrderTraversalRecursivelyUsingMap() {
        Map<Integer, List<String>> map = new HashMap<>();
        verticalOrderTraversalRecursivelyUsingMap(map, root, 0);
        map
                .forEach(
                        (k, v)
                                -> System.out.println("Nodes at distance " + k + " = " + v));
    }

    private void verticalOrderTraversalRecursivelyUsingMap(Map<Integer, List<String>> map, TreeNode head, int distance) {
        if (head == null) {
            return;
        }
        if (map.get(distance) == null) {
            List<String> path = new ArrayList<>();
            path.add(head.val + "->");
            map.put(distance, path);
        } else {
            List<String> path = map.get(distance);
            path.add(head.val + "->");
        }
        verticalOrderTraversalRecursivelyUsingMap(map, head.left, distance - 1);
        verticalOrderTraversalRecursivelyUsingMap(map, head.right, distance + 1);
    }

    private void printDiagonalsUsingQueue() {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //        queue.add(null);
        //
        //        while (!queue.isEmpty()) {
        //            BST poll = queue.poll();
        //            if (poll == null) {
        //                if (queue.isEmpty()) {
        //                    return;
        //                }
        //                System.out.println();
        //                queue.add(null);
        //            } else {
        //                while (poll != null) {
        //                    System.out.println(poll.val);
        //                    if(poll.left!=null){
        //                        queue.add(poll.left);
        //                    }
        //                    poll = poll.right;
        //                }
        //            }
        //    }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            // List<Integer> diagonal = new ArrayList<>();
            int diagonalSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                while (poll != null) {
                    // diagonal.add(poll.val + "->");
                    diagonalSum = diagonalSum + poll.val;
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    poll = poll.right;
                }
            }
            result.add(diagonalSum);
        }
        System.out.println(result);
    }

    private void printAllDiagonalsUsingMap() {
        Map<Integer, List<Integer>> diagonals = new HashMap<>();
        printAllDiagonalsUsingMapHelper(diagonals, root, 0);
        diagonals.forEach((key, values) -> values.forEach(System.out::println));
    }

    private void printAllDiagonalsUsingMapHelper(Map<Integer, List<Integer>> diagonalsMap, TreeNode head, int distance) {
        if (head == null) {
            return;
        }
        List<Integer> diagonals = diagonalsMap.get(distance);
        if (diagonals == null) {
            diagonals = new ArrayList<>();
            diagonals.add(head.val);
            diagonalsMap.put(distance, diagonals);
        } else {
            diagonals.add(head.val);
        }

        printAllDiagonalsUsingMapHelper(diagonalsMap, head.left, distance + 1);
        printAllDiagonalsUsingMapHelper(diagonalsMap, head.right, distance);
    }

    private List<String> printAllRootToLeafPathsBFSIteratively() {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> path = new LinkedList<>();
        queue.add(root);
        path.add("");
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            String currentPath = path.remove();
            if (poll.left == null && poll.right == null) {
                // path.add(currentPath+poll.val);
                result.add(currentPath + poll.val);
            }
            if (poll.left != null) {
                queue.add(poll.left);
                path.add(currentPath + poll.val + "->");
            }
            if (poll.right != null) {
                queue.add(poll.right);
                path.add(currentPath + poll.val + "->");
            }
        }
        return result;
    }

    private List<String> printAllRootToLeafPaths() {
        List<String> result = new ArrayList<>();
        printAllRootToLeafPaths("", root, result);
        return result;
    }

    private void printAllRootToLeafPaths(String path, TreeNode head, List<String> result) {

        if (head == null) {
            return;
        }
        if (head.left == null && head.right == null) {
            path = path + head.val;
            result.add(path);
            return;
        }
        printAllRootToLeafPaths(path + head.val + "-->", head.left, result);
        printAllRootToLeafPaths(path + head.val + "-->", head.right, result);
    }

    private int countAllNodes() {
        return countAllNodes(root);
    }

    private int countAllNodes(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return 1 + countAllNodes(head.left) + countAllNodes(head.right);
    }

    private int countNonLeafNodes() {
        return countNonLeafNodes(root);
    }

    private int countNonLeafNodes(TreeNode head) {
        if (head == null) {
            return 0;
        }
        if (head.left == null && head.right == null) {
            return 0;
        }
        return 1 + countNonLeafNodes(head.left) + countNonLeafNodes(head.right);
    }

    private int countLeafNodes() {
        return countLeafNodes(root);
    }

    private int countLeafNodes(TreeNode head) {
        if (head == null) {
            return 0;
        }
        if (head.left == null && head.right == null) {
            return 1;
        }
        return countLeafNodes(head.left) + countLeafNodes(head.right);
    }

    private boolean isSumTree() {
        return isSumTree(root);
    }

    private boolean isSumTree(TreeNode head) {
        if (head == null) {
            return true;
        }
        if (head.left == null && head.right == null) {
            return true;
        }

        int left = sumOfAllNodes(head.left);
        int right = sumOfAllNodes(head.right);
        if (head.val == left + right) {
            return isSumTree(head.left) && isSumTree(head.right);
        }
        return false;
    }

    private int sumOfAllNodes() {
        return sumOfAllNodes(root);
    }

    private int sumOfAllNodes(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return head.val + sumOfAllNodes(head.left) + sumOfAllNodes(head.right);
    }

    private boolean isSubTree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.val == t.val) {
                return isSameTree(poll, t);
            }
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return false;
    }

    private boolean isSameTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return true;
        }
        return tree1.val == tree2.val && isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
    }

    private static void printResult(Map<Integer, Integer> childParentMap, TreeNode targetnode) {
        while (childParentMap.containsKey(targetnode.val)) {
            System.out.println(childParentMap.get(targetnode.val));
            targetnode = new TreeNode(childParentMap.get(targetnode.val));
        }
    }

    private Map<Integer, Integer> allAncestorsOfGivenNodeIteratively(TreeNode targetNode) {
        if (root == null || targetNode == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        if (targetNode.val == root.val) {
            map.put(root.val, targetNode.val);
            return map;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.val == targetNode.val) {
                return map;
            }
            if (pop.left != null) {
                stack.add(pop.left);
                map.put(pop.left.val, pop.val);
            }
            if (pop.right != null) {
                stack.add(pop.right);
                map.put(pop.right.val, pop.val);
            }
        }

        return map;
    }

    private boolean allAncestorsOfGivenNode(TreeNode node) {
        return allAncestorsOfGivenNode(root, node);
    }

    private boolean allAncestorsOfGivenNode(TreeNode head, TreeNode targetNode) {

        if (head == null) {
            return false;
        }

        if (head.val == targetNode.val) {
            return true;
        }

        boolean left = allAncestorsOfGivenNode(head.left, targetNode);
        boolean right = false;
        if (!left) {
            right = allAncestorsOfGivenNode(head.right, targetNode);
        }
        if (left || right) {
            System.out.println(head.val);
        }
        return left || right;
    }

    private void nodeAtKDistance(int distance) {
        nodeAtKDistance(root, distance);
    }

    private void nodeAtKDistance(TreeNode head, int distance) {
        if (head == null) {
            return;
        }
        if (distance == 0) {
            System.out.println(head.val);
        }
        nodeAtKDistance(head.left, distance - 1);
        nodeAtKDistance(head.right, distance - 1);
    }

    private void iterativePostOrderTraversal() {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(0, pop.val);
            if (pop.left != null) {
                stack.add(pop.left);
            }
            if (pop.right != null) {
                stack.add(pop.right);
            }
        }
        System.out.println(result);
    }

    private void recursivePreOrderTraversal() {
        recursivePreOrderTraversal(root);
    }

    private void recursivePreOrderTraversal(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        recursivePreOrderTraversal(head.left);
        recursivePreOrderTraversal(head.right);
    }

    private void iterativePreOrderTraversal() {
        TreeNode node = root;
        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.add(node);
                result.add(node);
                System.out.println(node.val);
                node = node.left;
            }

            TreeNode pop = stack.pop();
            node = pop.right;
        }
    }

    private void recursiveInOrderTraversal() {
        recursiveInOrderTraversal(root);
    }

    private void recursiveInOrderTraversal(TreeNode head) {
        if (head == null) {
            return;
        }
        recursiveInOrderTraversal(head.left);
        System.out.println(head.val);
        recursiveInOrderTraversal(head.right);
    }

    private void iterativeInOrderTraversal() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            //  stack.add(root);
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            current = pop.right;
        }
    }

    private void createBST(int number, TreeNode node) {
        if (root == null) {
            root = new TreeNode(number);
        } else {
            if (node == null) {
                node = root;
            }
            if (number <= node.val) {
                if (node.left == null) {
                    node.setLeft(new TreeNode(number));
                } else {
                    createBST(number, node.left);
                }
            } else {
                if (node.right == null) {
                    node.setRight(new TreeNode(number));
                } else {
                    createBST(number, node.right);
                }
            }
        }
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

// if (root == null) {
//         return null;
//         }
//         if (root.val == p.val || root.val == q.val) {
//         return root;
//         }
//
//         BST left = lowestCommonAncestorRecursion(root.left, p, q);
//         BST right = lowestCommonAncestorRecursion(root.right, p, q);
//
//         if (left == null && right == null) {
//         return null;
//         }
//         if (left != null && right != null) {
//         return root;
//         }
//
//         return left == null ? right : left;
