//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

// import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}


// } Driver Code Ends
// User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;
// }

class Solution {
    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        // return the sorted list of all nodes at k dist
        if (root == null) return new ArrayList<>();
        Map<Node, Node> parentTrack = new HashMap<>();
        Node targetNode = markParentsAndFindTarget(root, parentTrack, target);
        if (targetNode == null) return new ArrayList<>();
        
        return bfs(targetNode, parentTrack, k);
    }
    
    private static Node markParentsAndFindTarget(Node node, Map<Node, Node> parentTrack, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Node targetNode = null;
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data == target) targetNode = current;
            
            if (current.left != null) {
                parentTrack.put(current.left, current);
                queue.offer(current.left);
            }
            
            if (current.right != null) {
                parentTrack.put(current.right, current);
                queue.offer(current.right);
            }
        }
        return targetNode;
    }
    
    private static ArrayList<Integer> bfs (Node targetNode, Map<Node, Node> parentTrack, int k) {
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Boolean> visited = new HashMap<>();
        queue.offer(targetNode);
        visited.put(targetNode, true);
        int curr_level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (curr_level == k) break;
            curr_level++;
            
            for (int i=0; i<size; i++) {
                Node current = queue.poll();
                if (current.left != null && !visited.containsKey(current.left)) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                
                if (current.right != null && !visited.containsKey(current.right)) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                
                if (parentTrack.containsKey(current) && !visited.containsKey(parentTrack.get(current))) {
                    queue.offer(parentTrack.get(current));
                    visited.put(parentTrack.get(current), true);
                }
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().data);
        }
        Collections.sort(result);
        return result;
    }
};

//{ Driver Code Starts.
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
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root, target, k);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends
