class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        for(int i=0; i<n; i++) {
            subsets.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++) {
            List<Integer> ls = new ArrayList<>();
            for(int j=0; j<i; j++) {
                if(nums[i]%nums[j]==0 && subsets.get(j).size() > ls.size()) 
                ls = subsets.get(j);
            }
            subsets.get(i).addAll(ls);
            subsets.get(i).add(nums[i]);
            if(subsets.get(i).size() > result.size())
                result = subsets.get(i);
        }
        return result;
    }
}