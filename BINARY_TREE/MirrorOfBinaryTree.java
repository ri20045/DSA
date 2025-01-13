import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode (int val) {
        this.val = val;
        left = right = null;
    }
}

public class MirrorOfBinaryTree {

    public static void inorderTraversal (TreeNode root) {
        //left->root->right
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                current = stack.pop();
                System.out.print(current.val + " ");
                current = current.right;
            }           
        }
    }

    public static void mirrorOfBinaryTree (TreeNode root) {
        if (root == null) {
            return;
        }
        else {
            mirrorOfBinaryTree(root.left);
            mirrorOfBinaryTree(root.right);
            //swap both the nodes
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }

    public static void main (String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        System.out.println("Mirror Of Binary Tree: ");
        System.out.println("First Inorder Traversal");
        inorderTraversal(root);
        mirrorOfBinaryTree(root); 
        System.out.println("\nSecond Inorder Traversal");
        inorderTraversal(root);  //if we get reverse of previous inorder traversal then it worked correctly!
    }
}
