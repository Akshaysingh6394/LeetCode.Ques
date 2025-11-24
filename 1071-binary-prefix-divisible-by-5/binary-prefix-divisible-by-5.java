class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        ArrayList<Boolean> list = new ArrayList<>();
        int rem = 0;
        for(int i=0;i<nums.length;i++){
            rem = (rem*2 + nums[i])%5;
            list.add(rem==0);
        }

        return list;
    }
}