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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, null)); //adding root with null parent

        //parent nodes of x and y
        TreeNode parentX = null, parentY = null;
        int depthX = -1, depthY = -1;
        int depth = 0; //tracker for current depth

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                TreeNode parent = current.parent;

                if (node.val == x) {
                    parentX = parent;
                    depthX = depth;
                }
                else if (node.val == y) {
                    parentY = parent;
                    depthY = depth;
                }

                if (node.left != null) queue.add(new Pair(node.left, node));
                if (node.right != null) queue.add(new Pair(node.right, node));

            }
            
            if (parentX != null && parentY != null) break;
            depth++;
        }
        return (depthX == depthY) && (parentX != parentY);
    }
}

class Pair{
    TreeNode node;
    TreeNode parent;

    Pair(TreeNode node, TreeNode parent) {
        this.node = node;
        this.parent = parent;
    }
}
