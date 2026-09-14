class Solution {
	public ArrayList<String> ratInMaze(int[][] maze) {
		// code here
		ArrayList<String> ans = new ArrayList<>();
		int n = maze.length;
		if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
			return ans;
		}
		boolean[][] visited = new boolean[n][n];
		solve(0, 0, maze, visited, "", ans);
		return ans;
	}
	public static void solve(int row, int col, int[][]maze, boolean[][]visited, String path, ArrayList<String> ans) {
		int n = maze.length;
		if (row == n - 1 && col == n - 1) {
			ans.add(path);
			return;
		}
		visited[row][col] = true;
		
		// going down
		if (row + 1 < n && maze[row + 1][col] == 1 && !visited[row + 1][col]) {
			solve(row + 1, col, maze, visited, path + "D", ans);
		}
		// going left
		if (col - 1 >= 0 && maze[row][col - 1] == 1 && !visited[row][col - 1]) {
			solve(row, col - 1, maze, visited, path + "L", ans);
		}
		// going right
		if (col + 1 < n && maze[row][col + 1] == 1 && !visited[row][col + 1]) {
			solve(row, col + 1, maze, visited, path + "R", ans);
		}
		// going up
		if (row - 1 >= 0 && maze[row - 1][col] == 1 && !visited[row - 1][col]) {
			solve(row - 1, col, maze, visited, path + "U", ans);
		}
		visited[row][col] = false;
	}
}
