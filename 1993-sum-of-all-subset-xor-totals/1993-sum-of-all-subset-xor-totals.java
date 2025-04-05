class Solution {
    public int subsetXORSum(int[] nums) {
       return solve(0,nums,0);
        
    }
    private int solve(int i,int[]nums,int xor){
        if(i>=nums.length){
            return xor;
        }
        return solve(i+1,nums,xor)
        +solve(i+1,nums,xor^nums[i]);
    }
}