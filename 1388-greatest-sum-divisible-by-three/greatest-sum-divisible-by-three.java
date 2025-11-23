class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        
        for (int num : nums) {
            int[] temp = dp.clone();
            for (int t : temp) {
                int newSum = t + num;
                dp[newSum % 3] = Math.max(dp[newSum % 3], newSum);
            }
        }
        
        return dp[0];
        
    }
}