class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                mini = Math.min(mini, nums[j]);
                maxi = Math.max(maxi, nums[j]);
                if (mini == minK && maxi == maxK) {
                    count++;
                }
            }
        }
        return count;
    }
}