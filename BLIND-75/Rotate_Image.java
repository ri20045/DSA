class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //transpose
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                // swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //reverse
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
