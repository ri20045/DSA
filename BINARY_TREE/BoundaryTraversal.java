import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode (int val) {
        this.val = val;
        left = right = null;
    }
}

public class BoundaryTraversal {
    public static void printLeftNodes (TreeNode root) {
        //PRINT LEFT NODES EXCLUDING LEAF NODES
        if (root == null) {
            return;
        }
        else if (root.left == null && root.right == null) {
            return;
        }
        else {
            System.out.print(root.val + " ");
            printLeftNodes(root.left);
        }
    }

    public static void printLeafNodes (TreeNode root) {
        if (root == null) {
            return;
        }
        else if (root.left == null && root.right == null) {
            System.out.print(root.val + " ");
        }
        else {
            printLeafNodes(root.left);
            printLeafNodes(root.right);
        }
    }

    public static void printRightNodes (TreeNode root) {
        //no need to print the leaf nodes
        if (root == null) {
            return;
        }
        else if (root.left == null && root.right == null) {
            return;
        }
        else {
            printRightNodes(root.right);
            System.out.print(root.val + " ");
        }
    }
    public static void main (String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        root.left.right.right = new TreeNode(6);

        System.out.print("Boundary Traversal of Binary Tree => ");
        printLeftNodes(root);
        printLeafNodes(root);
        printRightNodes(root.right);
    }   
}
