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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> list = new LinkedList<List<Integer>>();

        if (root == null) return list;

        queue.offer(root);

        while(!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> subList = new LinkedList<>();

            for (int i=0; i<level; i++) {
                TreeNode currentNode = queue.poll();
                subList.add(currentNode.val);

                if(currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            list.add(subList);
        }
        return list;
    }
}
