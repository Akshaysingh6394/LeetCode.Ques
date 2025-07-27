class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int i = 1, j = 1; // Start from index 1 to ensure valid left and right neighbors
        int count = 0;

        while (j < n - 1) {
            // Extend j to skip over equal elements (plateau)
            while (j < n - 1 && nums[i] == nums[j + 1]) {
                j++;
            }

            // Ensure j+1 is within bounds for right neighbor
            if (j < n - 1) {
                // Check if the group [i..j] is a hill or a valley
                boolean isHill = nums[i] > nums[i - 1] && nums[j] > nums[j + 1];
                boolean isValley = nums[i] < nums[i - 1] && nums[j] < nums[j + 1];
                if (isHill || isValley) {
                    count++; // Count this group as one hill or valley
                }
            }

            // Move to the next group
            j++;
            i = j;
        }

        return count;
    }
}