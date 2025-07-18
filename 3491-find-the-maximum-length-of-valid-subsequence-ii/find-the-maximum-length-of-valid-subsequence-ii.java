class Solution {
    public int maximumLength(int[] nums, int k) {
        int res = 1; // Minimum valid subsequence length
        
        // We'll perform k+1 iterations to allow up to k transitions
        for (int j = 0; j <= k; j++) {
            int[] dp = new int[k]; // Tracks longest sequence for each remainder
            
            for (int num : nums) {
                int mod = num % k;
                // The position we'd look for in previous step
                int pos = (j - mod + k) % k;
                dp[mod] = Math.max(dp[mod], (j > 0 ? dp[pos] : 0) + 1);
            }
            
            // Update global maximum
            for (int length : dp) {
                res = Math.max(res, length);
            }
        }
        
        return res;
    }
}