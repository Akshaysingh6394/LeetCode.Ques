class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int prev_len = 0;
        int curr_len = 0;
        int max_len = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                curr_len++;
            } else {
                max_len = Math.max(max_len, prev_len + curr_len);
                prev_len = curr_len;
                curr_len = 0;
            }
        }

        max_len = Math.max(max_len, prev_len + curr_len);
        if (max_len == n) return n - 1;
        return max_len;
    }
}