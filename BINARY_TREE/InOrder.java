class Node
{
    int root;
    Node left, right;

    public Node(int item){
        root = item;
        right = left = null;
    }
}

public class InOrder
{
    Node root;
    public InOrder(){
        root = null;
    }

    public static void main(String[] args)
    {
        InOrder tree = new InOrder();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);

        tree.inorderTraversal(tree.root);
    }

    void inorderTraversal(Node node)
    {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.root + " ");
        inorderTraversal(node.right);
    }
}
