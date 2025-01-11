import java.util.*;

class TreeNode {
    TreeNode left, right;
    int val;

    public TreeNode (int val) {
        this.val = val;
        left = right = null;
    }
}

class Pair {
    TreeNode node;
    int column;

    public Pair (TreeNode node, int column) {
        this.column = column;
        this.node = node;
    }
}
public class BottomView {
    public static void bottomView (TreeNode root) {
        TreeMap<Integer, Integer> columnMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        if (root == null) {
            return;
        }
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int column = current.column;

            // For bottom view, always update the columnMap with the latest node value for the column
            columnMap.put(column, node.val);

            if (node.left != null) {
                queue.add(new Pair(node.left, column - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, column + 1));
            }
        }
        for (int value : columnMap.values()) {
            System.out.print(value + " ");
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);

        System.out.println("Bottom View of Binary Tree");
        bottomView(root);
    } 
}
