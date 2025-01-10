import java.util.*;
class TreeNode{
    int val;
    TreeNode right, left;

    public TreeNode(int val){
        this.val = val;
        left = right = null;
    }
}

public class TopView {
    public static void topView(TreeNode root){

        if (root == null) {
            return;
        }

        TreeMap<Integer, Integer> columnMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode currNode = current.node;
            int column = current.column;

            if (!columnMap.containsKey(column)) {
                columnMap.put(column, currNode.val);
            }

            if (currNode.left != null) {
                queue.add(new Pair(currNode.left, column - 1));
            }

            if (currNode.right != null) {
                queue.add(new Pair(currNode.right, column + 1));
            }
        }

        // Print the top view from the TreeMap
        for (Integer value : columnMap.values()) {
            System.out.print(value + " ");
        }
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(10);
        root.right.right.right = new TreeNode(9);
        root.right.right.left.right = new TreeNode(11);
        root.right.right.left.right.right = new TreeNode(12);

        System.out.println("Top Level View of Binary Tree");
        topView(root);
    }
}

class Pair{
    TreeNode node;
    int column;

    public Pair(TreeNode node, int column) {
        this.node = node;
        this.column = column;
    }
}
