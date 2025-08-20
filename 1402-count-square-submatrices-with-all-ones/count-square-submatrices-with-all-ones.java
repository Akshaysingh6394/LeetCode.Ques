class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int totalSquares = 0;

        // We'll use the input matrix itself as our DP table to save space!
        // This won't work if the matrix must remain unchanged.
        // For a more general solution, a separate DP table is fine.
        int[][] dp = new int[rows][cols];

        // Fill the DP table
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        // For the first row and column, the largest square is always size 1.
                        dp[i][j] = 1;
                    } else {
                        // The magic DP formula: a square's size is 1 + the smallest neighbor.
                        dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    }
                }
                totalSquares += dp[i][j];
            }
        }

        return totalSquares;
    }
}
