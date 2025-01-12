import java.util.*;

class TreeNode {
    TreeNode left , right;
    int val;

    public TreeNode (int val) {
        this.val = val;
        left = right = null;
    }
}

public class HeightBinaryTree {

    public static int heightBinaryTree (TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            int lh = heightBinaryTree(root.left);
            int rh = heightBinaryTree(root.right);
            int height = Math.max(lh, rh) + 1;
            return height;
        }

    }
    public static void main (String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        System.out.println("Height of Binary Tree: " + heightBinaryTree(root));
    }   
}
