class Solution {
    public long maximumTripletValue(int[] nums) {
         int n = nums.length;
        if (n < 3) return 0; // Not enough elements for a triplet

        long maxTripletValue = 0;
        int maxPrefix = 0; // Tracks max(nums[i]) seen so far
        int maxDiff = Integer.MIN_VALUE; // Tracks max(nums[i] - nums[j])

        for (int j = 1; j < n - 1; j++) {
            maxPrefix = Math.max(maxPrefix, nums[j - 1]); // Track max before `j`
            maxDiff = Math.max(maxDiff, maxPrefix - nums[j]); // Best (nums[i] - nums[j]) so far
            maxTripletValue = Math.max(maxTripletValue, (long) maxDiff * nums[j + 1]); // Calculate the triplet
        }
        return maxTripletValue;
    }
}