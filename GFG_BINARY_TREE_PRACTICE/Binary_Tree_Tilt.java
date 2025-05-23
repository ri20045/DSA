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
    private int totalTilt = 0;
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        calculateSum(root);
        return totalTilt;
    }

    public int calculateSum(TreeNode node) {
        if (node == null) return 0;

        int leftSum = calculateSum(node.left);
        int rightSum = calculateSum(node.right);

        int tilt = Math.abs(leftSum - rightSum);
        totalTilt += tilt;

        return node.val + leftSum + rightSum;
    }
}
