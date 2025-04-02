class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        int water = 0;
        while(left<right){
            water = Math.min(height[left],height[right])*(right-left);
            max = Math.max(max,water);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}