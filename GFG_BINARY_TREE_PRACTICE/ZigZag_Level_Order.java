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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack1 = new Stack<>(); //left to right
        Stack<TreeNode> stack2 = new Stack<>(); //right to left

        stack1.push(root);

        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            while(!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                level.add(node.val);
                if(node.left != null) stack2.push(node.left);
                if(node.right != null) stack2.push(node.right);
            }
            if (!level.isEmpty()) result.add(level);

            level = new ArrayList<>();
            while(!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                level.add(node.val);
                if(node.right != null) stack1.push(node.right);
                if(node.left != null) stack1.push(node.left);
            }
            if(!level.isEmpty()) result.add(level);
        }
        return result;
    }
}
