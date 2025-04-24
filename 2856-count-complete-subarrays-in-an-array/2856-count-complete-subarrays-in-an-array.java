class Solution {
    public int countCompleteSubarrays(int[] nums) {
          int n = nums.length;
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : nums) {
            uniqueSet.add(num);
        }

        int c = uniqueSet.size();  // total number of distinct elements
        int i = 0, j = 0, res = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        while (j < n) {
            freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0) + 1);

            while (freqMap.size() == c) {
                res += (n - j);  // all subarrays ending from j to n-1 are valid

                freqMap.put(nums[i], freqMap.get(nums[i]) - 1);
                if (freqMap.get(nums[i]) == 0) {
                    freqMap.remove(nums[i]);
                }
                i++;
            }
            j++;
        }

        return res;

    }
}