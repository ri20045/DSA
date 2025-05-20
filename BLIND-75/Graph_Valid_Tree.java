// User function Template for Java
class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // code here
        if (m != n-1) return false;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) adj.add(new ArrayList<>());
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0), v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        if (hasCycle(0, -1, adj, visited)) return false;
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
    
    public boolean hasCycle(int node, int prev, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, node, adj, visited)) return true;
            } else if (neighbor != prev) return true;
        }
        return false;
    }
}
