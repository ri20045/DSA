
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][W + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, val, wt, W, dp);
    }

    public int solve(int idx, int[] val, int[] wt, int W, int[][] dp) {

        if (idx == 0) {
            if (wt[0] <= W) {
                return val[0];
            }
            return 0;
        }

        if (dp[idx][W] != -1) {
            return dp[idx][W];
        }

        if (wt[idx] <= W) {
            return dp[idx][W] = Math.max(
                val[idx] + solve(idx - 1, val, wt, W - wt[idx], dp),
                solve(idx - 1, val, wt, W, dp)
            );
        } else {
            return dp[idx][W] = solve(idx - 1, val, wt, W, dp);
        }
    }
}
