class Solution {
    double[][] dp = new double[200][200];

    public double probability(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;
        if (dp[a][b] > 0) return dp[a][b];

        dp[a][b] = 0.25 * (
            probability(a - 4 , b) +
            probability(a - 3 , b - 1) +
            probability(a - 2 , b - 2) +
            probability(a - 1 , b - 3)
        );
        return dp[a][b];
    }

    public double soupServings(int n) {
        if (n > 4600) return 1.0;
        int scaled = (n + 24) / 25;
        return probability(scaled , scaled);
    }
}