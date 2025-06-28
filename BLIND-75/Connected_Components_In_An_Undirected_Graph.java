
class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        for (int i=0; i<V; i++) {
            if(!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, adj, visited, component);
                result.add(component);
            }
        }
        return result;
    }
    
    private void dfs (int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> component) {
        visited[node] = true;
        component.add(node);
        
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, component);
            }
        }
    }
}
