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
    private int maxCount = 0;
    private int currentCount = 0;
    private Integer prev = null;
    List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root, true);
        //reset every variable
        modes.clear();
        currentCount = 0;
        prev = null;
        inorder(root, false);

        int[] result = new int[modes.size()];
        for (int i=0; i<modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inorder(TreeNode node, boolean firstPass) {
        if (node == null) return;
        inorder(node.left, firstPass);
        if (prev != null && prev == node.val) {
            currentCount++;
        }
        else {
            currentCount = 1;
        }
        if (firstPass) {
            maxCount = Math.max(maxCount, currentCount);
        }
        else {
            if (currentCount == maxCount) {
                modes.add(node.val);
            }
        }
        prev = node.val;
        inorder(node.right, firstPass);
    }

    
}
