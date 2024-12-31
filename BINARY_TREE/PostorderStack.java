import java.util.Stack;

class TreeNode{
    int val;
    TreeNode right, left;

    TreeNode(int val){
        this.val = val;
        right = left = null;
    }
}
public class PostorderStack {
    public void postorder(TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack1.isEmpty()) {
            if (current != null) {
                stack2.push(current);
                stack1.push(current);
                current = current.right;
            }
            else {
                current = stack1.pop();
                current = current.left;
            }
        } //Now we have explored the whole tree

        //print the element of stack2
        while (!stack2.isEmpty()) {
            TreeNode element = stack2.pop();
            System.out.print(element.val + " ");
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);

        PostorderStack traversal = new PostorderStack();
        System.out.println("Post Order Traversal: ");
        traversal.postorder(root);
    }
}
