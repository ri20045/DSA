//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) return result;

        result.add(node.data);
        if (node.left == null && node.right == null) return result;

        addLeftBoundary(node.left, result);

        addLeafNodes(node, result);

        ArrayList<Integer> rightBoundary = new ArrayList<>();
        addRightBoundary(node.right, rightBoundary);
        Collections.reverse(rightBoundary);
        result.addAll(rightBoundary);

        return result;
    }

    private void addLeftBoundary(Node root, ArrayList<Integer> result) {
        while (root != null) {
            if (root.left != null || root.right != null) { 
                result.add(root.data);
            }
            root = (root.left != null) ? root.left : root.right; 
        }
    }

    private void addLeafNodes(Node root, ArrayList<Integer> result) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            result.add(root.data);
            return;
        }
        addLeafNodes(root.left, result);
        addLeafNodes(root.right, result);
    }

    private void addRightBoundary(Node root, ArrayList<Integer> result) {
        while (root != null) {
            if (root.left != null || root.right != null) { 
                result.add(root.data);
            }
            root = (root.right != null) ? root.right : root.left;
        }
    }
}
