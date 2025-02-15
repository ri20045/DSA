/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int bottomLeftValue = root.val;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            bottomLeftValue = curr.val;

            if (curr.right != null) queue.offer(curr.right);
            if (curr.left != null) queue.offer(curr.left);
        }
        return bottomLeftValue;
    }
}
