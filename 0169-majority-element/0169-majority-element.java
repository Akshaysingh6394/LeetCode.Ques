class Solution {
    public int majorityElement(int[] nums) {
        
//This will increase the time complexicity of program        
        /*
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(nums[i]<nums[j]){
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        */


        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}