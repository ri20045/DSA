import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int data;
    TreeNode left, right;

    TreeNode (int value){
        data = value;
        left = right = null;
    }
}

public class LevelOrder {
    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //remove the front node from queue
            TreeNode current = queue.poll();
            System.out.print(current.data+" ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main (String[] args)
{
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(8);
    root.left.left.left = new TreeNode(6);
    root.left.right.right = new TreeNode(7);
    root.right.right.right = new TreeNode(9);

    System.out.println("Level Order Traversal of the tree:");
    levelOrder(root);
  }
}
