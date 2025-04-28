class Solution {
    public void nextPermutation(int[] nums) {
    int n = nums.length;

        // First find the "gola"
        int gola_index = -1;

        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                gola_index = i - 1;
                break;
            }
        }

        if (gola_index != -1) {
            int swap_index = gola_index;
            
            for (int j = n - 1; j > gola_index; j--) {
                if (nums[j] > nums[gola_index]) {
                    swap_index = j;
                    break;
                }
            }

            swap(nums, gola_index, swap_index);
        }

        reverse(nums, gola_index + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}