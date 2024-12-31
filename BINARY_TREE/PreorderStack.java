import java.util.Stack;
class TreeNode{
    int val;
    TreeNode right, left;

    TreeNode(int val){
        this.val = val;
        right = left = null;
    }
}

public class PreorderStack {
    public void preorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                System.out.print(current.val + " ");
                current = current.left;   
            }
            else {
                current = stack.pop();
                current = current.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(7);

        PreorderStack traversal = new PreorderStack();
        System.out.println("Preorder Traversal: ");
        traversal.preorder(root);
    }
}
