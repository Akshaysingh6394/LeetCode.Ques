class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        int count = 0;
        int lsum = 0;
        for(int i=0;i<nums.length-1;i++){
            lsum += nums[i];
            if((lsum -(sum-lsum)) %2 == 0){
                count++;
            }
        }
        return count;

    }
}