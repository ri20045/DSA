class Node{
    int root;
    Node left, right;

    public Node(int item){
        root = item;
        right = left = null;
    }
}

public class PostOrder {
    Node root;
    public PostOrder(){
        root = null;
    }

    public static void main(String[]args){
        PostOrder tree = new PostOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);

        tree.postorderTraversal(tree.root);
    }

    void postorderTraversal(Node node){
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.root + " ");
    }  
}
