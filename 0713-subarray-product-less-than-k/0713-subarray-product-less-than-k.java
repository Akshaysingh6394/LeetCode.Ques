class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        int prod = 1;
        int start = 0;
        int end = 0;
        int count = 0;
        while (end < nums.length) {
            prod = prod * nums[end];
            while (start <= end && prod >= k) {
                prod /= nums[start];
                start++;
            }
            if (prod < k) {
                count += (end - start + 1);
            }
            end++;
        }
        return count;
    }
}