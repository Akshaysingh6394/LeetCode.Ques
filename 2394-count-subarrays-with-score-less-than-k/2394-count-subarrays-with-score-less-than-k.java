class Solution {
    public long countSubarrays(int[] nums, long k) {
        
        long res = 0, partSum = 0;
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            partSum += nums[right];
            while (partSum * (right - left + 1) >= k) {
                partSum -= nums[left++];
            }
            res += right - left + 1;
        }
        
        return res;
    }
}
   