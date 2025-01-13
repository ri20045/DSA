import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class SpiralLevelOrder {

    public static void spiralLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();

            stack1.push(root);
            while (!stack1.isEmpty() || !stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    TreeNode current = stack1.pop();
                    if (current != null) {
                        System.out.print(current.val + " ");
                        stack2.push(current.left);
                        stack2.push(current.right);
                    }
                }
                while (!stack2.isEmpty()) {
                    TreeNode current = stack2.pop();
                    if (current != null) {
                        System.out.print(current.val + " ");
                        stack1.push(current.right);
                        stack1.push(current.left);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(18);
        root.left.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(17);
        root.left.right.left.left = new TreeNode(19);
        root.right.right.right = new TreeNode(8);

        System.out.println("Spiral Level Order: ");
        spiralLevelOrder(root);
    }
}
