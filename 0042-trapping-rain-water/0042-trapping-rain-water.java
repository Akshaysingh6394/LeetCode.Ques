class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int i = 0;
        int j = height.length - 1;
        int leftMax = height[i];
        int rightMax = height[j];

        while (i < j) {
            if (leftMax <= rightMax) {
                ans += (leftMax - height[i]);
                i++;
                leftMax = Math.max(leftMax, height[i]);
            } else {
                ans += (rightMax - height[j]);
                j--;
                rightMax = Math.max(rightMax, height[j]);
            }
        }

        return ans;
    }
}