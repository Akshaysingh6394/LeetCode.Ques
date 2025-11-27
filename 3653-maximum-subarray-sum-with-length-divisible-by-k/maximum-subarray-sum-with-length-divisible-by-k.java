class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long prefix[] = new long[n];
        prefix[0] = nums[0];
        for(int i=1;i<n;i++){
            prefix[i] = nums[i]+prefix[i-1];
        }
        long res = Long.MIN_VALUE;
        for(int start=0;start<k;start++){
            long currSum = 0;
            int i = start;
            while(i<n && i+k-1<n){
                int j=i+k-1;
                long subSum = prefix[j] - (i > 0 ? prefix[i-1] : 0);

                currSum = Math.max(subSum , currSum+subSum) ;
                res = Math.max(res,currSum);
                i+=k;
            }
        }
        return res;
    }
}