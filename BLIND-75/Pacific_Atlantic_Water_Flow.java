class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i=0; i<m; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]); //pacific
            dfs(heights, atlantic, i, n-1, heights[i][n-1]); //atlantic
        }

        for (int j=0; j<n; j++) {
            dfs(heights, pacific, 0, j, heights[0][j]); //pacific
            dfs(heights, atlantic, m-1, j, heights[m-1][j]); //atlantic
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs (int[][] heights, boolean[][] visited, int i, int j, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || heights[i][j] < prevHeight) {
            return;
        }
        visited[i][j] = true;
        dfs(heights, visited, i + 1, j, heights[i][j]); // Down
        dfs(heights, visited, i - 1, j, heights[i][j]); // Up
        dfs(heights, visited, i, j + 1, heights[i][j]); // Right
        dfs(heights, visited, i, j - 1, heights[i][j]); // Left
    }
}
