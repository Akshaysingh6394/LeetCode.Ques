class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        int imax = 0, dmax = 0;
        for (int i=0;i<n;i++) {
            res = Math.max(res, (long) dmax * nums[i]);
            dmax = Math.max(dmax, imax - nums[i]);
            imax = Math.max(imax, nums[i]);
        }
        return res;
    }
}