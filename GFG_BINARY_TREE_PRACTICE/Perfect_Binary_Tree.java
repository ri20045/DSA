//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 


class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}

class GFG {
    
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
		    String s = br.readLine();
	    	Node root = buildTree(s);
		    Solution obj = new Solution();
		    boolean res = obj.isPerfect(root);
		    if(res) {
		        System.out.println("YES");
		    } else {
		        System.out.println("NO");
		    }
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


//User function Template for Java

/*
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/

class Solution{
    
    int findHeight(Node node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    void levelOrderTraversal(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                Node temp = queue.poll();
                System.out.print(temp.data + " ");

                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            System.out.println();
        }
    }
    
    double countNodesInLastLevel(Node root) {
        if (root == null) return 0.0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int lastLevelNodeCount = 0;

        while (!queue.isEmpty()) {
            lastLevelNodeCount = queue.size();
            
            for (int i = 0; i < lastLevelNodeCount; i++) {
                Node temp = queue.poll();

                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
        return (double) lastLevelNodeCount;
    }
    
    boolean hasTwoChildren(Node root) {
        if (root == null) return true;

        if (root.left == null && root.right == null) return true;

        if (root.left == null || root.right == null) return false;

        return hasTwoChildren(root.left) && hasTwoChildren(root.right);
    }
    
    public boolean isPerfect(Node root){
        int heightOfTree = findHeight(root);

        double expectedNodesInLastLevel = Math.pow(2, heightOfTree);

        double actualNodesInLastLevel = countNodesInLastLevel(root);

        return (hasTwoChildren(root) && (expectedNodesInLastLevel == actualNodesInLastLevel));
    }
    
}
