class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return count(nums,upper+1)-count(nums,lower);
    }


    public static long count(int nums[],int target){
        long count =0;

        int right = nums.length-1;
        int left = 0;
        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum<target){
                count+=(right-left);
                left++;
            }else{
                right--;
            }
        }
        return count;
    }
}