import java.util.Stack;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
        left = right = null;
    }
}

public class InorderStack{
    public void inorder(TreeNode root){
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right = new TreeNode(4);

        InorderStack traversal = new InorderStack();
        System.out.println("Inorder Traversal: ");
        traversal.inorder(root);
    }
}
