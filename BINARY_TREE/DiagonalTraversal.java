import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode (int val) {
        this.val = val;
        left = right = null;
    }
}

class Pair {
    TreeNode node;
    int column;

    public Pair (TreeNode node, int column) {
        this.node = node;
        this.column = column;
    }
}

public class DiagonalTraversal {
    public static void diagonalTraversal (TreeNode root) {
        TreeMap<Integer, List<Integer>> columnMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        if (root == null) {
            return;
        }
        else {
            queue.add(new Pair(root, 0));
        }

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int column = current.column;

            columnMap.putIfAbsent(column, new ArrayList<>());
            columnMap.get(column).add(node.val);

            if (node.left != null) {
                queue.add(new Pair(node.left, column + 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, column));
            }
        }

        for (List<Integer> column : columnMap.values()) {
            System.out.println(String.join(",", column.stream()
                    .map(String::valueOf) // Convert integers to strings
                    .toList())); // Collect them back to a list
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        System.out.println("Diagonal Traversal of Binary Tree");
        diagonalTraversal(root);
    } 
}

