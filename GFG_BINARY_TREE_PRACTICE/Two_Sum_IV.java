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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> traversed = new HashSet<>();
        return traversal(root, k, traversed);
    }

    private boolean traversal(TreeNode node, int k, Set<Integer> traversed) {
        if (node == null) return false;
        if (traversed.contains(k - node.val)) return true;
        traversed.add(node.val);
        return traversal(node.left, k, traversed) || traversal(node.right, k, traversed);
    }
}
