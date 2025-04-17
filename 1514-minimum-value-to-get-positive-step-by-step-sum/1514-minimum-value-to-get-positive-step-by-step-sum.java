class Solution {
    public int minStartValue(int[] nums) {
       int minPre = 0;
       int sum = 0;
       for(int num:nums){
        sum+=num;
        minPre = Math.min(minPre,sum);
       } 
       return 1-minPre;
    }
}