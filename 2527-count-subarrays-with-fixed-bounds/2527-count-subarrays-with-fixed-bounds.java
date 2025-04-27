public class Solution 
{
    public long countSubarrays(int[] nums, int minK, int maxK) 
    {
        int lastMin = -1, lastMax = -1, lastInvalid = -1;
        long count = 0;

        // Step 2: Traverse the array
        for (int i = 0; i < nums.length; i++) 
        {
            if (nums[i] < minK || nums[i] > maxK) 
            {
                lastInvalid = i;  // update lastInvalid if out of bounds
            }
            if (nums[i] == minK) 
            {
                lastMin = i;      // update lastMin when we find minK
            }
            if (nums[i] == maxK) 
            {
                lastMax = i;      // update lastMax when we find maxK
            }

            // Step 3: Calculate count of valid subarrays ending at i
            int minLast = Math.min(lastMin, lastMax);
            if (minLast > lastInvalid) 
            {
                count += minLast - lastInvalid;
            }
        }

        return count;
    }
}