class Node
{
    int root;
    Node left, right;

    public Node(int item){
        root = item;
        right = left = null;
    }
}

public class PreOrder
{
    Node root;
    public PreOrder(){
        root = null;
    }

    public static void main(String[] args)
    {
        PreOrder tree = new PreOrder();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);

        tree.preorderTraversal(tree.root);
    }

    void preorderTraversal(Node node)
    {
        if (node == null) {
            return;
        }
        System.out.print(node.root + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
}
