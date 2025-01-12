import java.util.*;

class TreeNode {
    TreeNode left, right;
    int val;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class NodesInBinaryTree {

    //RECURSIVE WAY
    public static int nodesInBinaryTree (TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            int countr = nodesInBinaryTree(root.right);
            int countl = nodesInBinaryTree(root.left);
            int nodes = (countr + countl) + 1;
            return nodes;
        }
    }

    //ITERATIVE WAY
    // public static int nodesInBinaryTree(TreeNode root) {

    //     if (root == null) {
    //         return 0;
    //     } else {
    //         Queue<TreeNode> queue = new LinkedList<>();
    //         queue.add(root);
    //         int count = 0;
    //         while (!queue.isEmpty()) {
    //             TreeNode node = queue.poll();
    //             count++;
    //             if (node.left != null) {
    //                 queue.add(node.left);
    //             }
    //             if (node.right != null) {
    //                 queue.add(node.right);
    //             }
    //         }
    //         return count;
    //     }
    // }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.left = new TreeNode(7);
        root.left.right.right.right = new TreeNode(10);

        System.out.println("Number of Nodes in Binary Tree: " + nodesInBinaryTree(root));
    }
}
