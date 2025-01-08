import java.util.*;

class TreeNode{
    int val;
    TreeNode left, right;

    public TreeNode(int val){
        this.val = val;
        left = right = null;
    }
}

public class VerticalOrderTraversal {
    public static void verticalOrder(TreeNode root){
        //store distance(key) and nodes
        TreeMap<Integer, List<Integer>> columnMap = new TreeMap<>();
        //store the same in queue
        Queue<Pair> queue = new LinkedList<>();

        if (root == null){
            return;
        }
        else {
            queue.add(new Pair(root, 0)); // start with root node with distance(key) as 0
        }

        while(!queue.isEmpty()) {
            Pair current = queue.poll(); //remove and return the head of the queue
            TreeNode node = current.node; //current's value
            int column = current.column; //current's distance

            columnMap.putIfAbsent(column, new ArrayList<>());
            columnMap.get(column).add(node.val);

            if(node.left != null){
                queue.add(new Pair(node.left, column - 1));
            }

            if(node.right != null){
                queue.add(new Pair(node.right, column + 1));
            }
        }

        for (List<Integer> column : columnMap.values()) {
            System.out.println(String.join(",", column.stream()
                    .map(String::valueOf) // Convert integers to strings
                    .toList())); // Collect them back to a list
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right  = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
    
        System.out.println("Vertical Order Traversal:");
        verticalOrder(root);
    }
}

class Pair{
    TreeNode node;
    int column;

    public Pair(TreeNode node, int column){
        this.node = node;
        this.column = column;
    }
}
