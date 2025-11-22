class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minL = Integer.MAX_VALUE;;
        int i=0,j=0;
        int sum = 0;

        while(j<nums.length){
            sum += nums[j];
            while(sum >= target ){
                minL = Math.min(minL , j-i+1);
                sum -= nums[i];
                i++;
            }
            j++;

        }
        return minL == Integer.MAX_VALUE ?0:minL ;

    }
}