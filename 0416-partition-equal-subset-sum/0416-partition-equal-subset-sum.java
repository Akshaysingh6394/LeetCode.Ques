class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If sum is odd, cannot be divided into two equal subsets
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int n = nums.length;

        // dp[i] = true if subset with sum i can be formed
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
