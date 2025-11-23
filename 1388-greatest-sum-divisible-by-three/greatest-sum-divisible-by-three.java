import java.util.*;

class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        
        // Arrays to store numbers giving remainder 1 and 2 when divided by 3
        int[] remain1 = new int[nums.length];
        int[] remain2 = new int[nums.length];
        int count1 = 0, count2 = 0;
        
        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) {
                remain1[count1++] = num;
            } else if (num % 3 == 2) {
                remain2[count2++] = num;
            }
        }
        
        if (sum % 3 == 0) {
            return sum;
        }
        
        // Sort only the filled portions of the arrays
        Arrays.sort(remain1, 0, count1);
        Arrays.sort(remain2, 0, count2);
        
        int result = 0;
        int remainder = sum % 3; // 1 or 2
        
        if (remainder == 1) {
            int remove1 = count1 >= 1 ? remain1[0] : Integer.MAX_VALUE;
            int remove2 = count2 >= 2 ? (remain2[0] + remain2[1]) : Integer.MAX_VALUE;
            result = Math.max(result, sum - Math.min(remove1, remove2));
        } else { // remainder == 2
            int remove1 = count2 >= 1 ? remain2[0] : Integer.MAX_VALUE;
            int remove2 = count1 >= 2 ? (remain1[0] + remain1[1]) : Integer.MAX_VALUE;
            result = Math.max(result, sum - Math.min(remove1, remove2));
        }
        
        return result;
    }
}