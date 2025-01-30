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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        return findSecondMin(root, root.val);
    }
    private int findSecondMin(TreeNode node, int minVal) {
        if (node == null) return -1;
        if (node.val > minVal) return node.val;
        int left = findSecondMin(node.left, minVal);
        int right = findSecondMin(node.right, minVal);

        if (left == -1) return right;
        if (right == -1) return left;

        return Math.min(left, right);
    }
}
