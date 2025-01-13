import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    TreeNode left, right;
    int val;

    public TreeNode (int val) {
        this.val = val;
        left = right = null;
    }
}

public class LeafNodesInBinaryTree {

    //RECURSIVE WAY
    public static int leafNodesInBinaryTree (TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        else {
            int countr = leafNodesInBinaryTree(root.right);
            int countl = leafNodesInBinaryTree(root.left);
            return countl + countr;
        }
    }

    //ITERATIVE WAY
    // public static int leafNodesInBinaryTree (TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.add(root);

    //     int count = 0;

    //     while (!queue.isEmpty()) {
    //         TreeNode current = queue.poll();
    //         if (current.left == null && current.right == null) {
    //             count++;
    //         }
    //         else {
    //             if (current.left != null) {
    //                 queue.add(current.left);
    //             }
    //             if (current.right != null) {
    //                 queue.add(current.right);
    //             }
    //         }
    //     }
    //     return count;
    // }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(8);
        root.right.left = new TreeNode(9);

        System.out.println("Number of Leaf nodes in binary tree: " + leafNodesInBinaryTree(root));
    }  
}
