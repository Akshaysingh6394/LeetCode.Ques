class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans =0;
        long n1=0,n2=0,n3=0;
        for(int i=0;i<nums.length;i++){
            n1=nums[i];
            for(int j=i+1;j<nums.length;j++){
                n2=nums[j];
                for(int k=j+1;k<nums.length;k++){
                    n3=nums[k];
                    long temp = (n1-n2)*n3;
                    if(temp>ans){
                        ans=temp;
                    }
                }
            }
        }
        return ans;
    }
}