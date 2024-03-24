class Solution {
    public int findDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int ind = Math.abs(nums[i]) -1;
            if (nums[ind] < 0) {
                return ind + 1;
            }
            nums[ind] = (nums[ind] * (-1));
        }

        return -1;
        
    }
}