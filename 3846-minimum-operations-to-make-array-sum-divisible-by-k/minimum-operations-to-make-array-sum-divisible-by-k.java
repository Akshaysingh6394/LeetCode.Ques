class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        for(int num:nums){
            sum += num;
        }
        if(sum % k == 0){
            return 0;
        }
        if(sum > k){
            while(sum % k !=0){
                count++;
                sum--;
            }
        }else{
            count = sum;
        }
        return count;

    }
}