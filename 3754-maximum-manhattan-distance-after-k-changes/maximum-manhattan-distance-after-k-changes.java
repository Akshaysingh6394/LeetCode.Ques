class Solution 
{
    public int maxDistance(String s, int k) 
    {
        // Step 1: Initialize your position and max distance
        int x = 0;
        int y = 0;

        // To track the maximum Manhattan distance reached
        int ans = 0;      

        // Step 2: Loop through each character in the string
        for (int i = 0; i < s.length(); i++) 
        {
            char c = s.charAt(i);

            if (c == 'N') 
            {
                y += 1; 
            } 
            else if (c == 'S') 
            {
                y -= 1; 
            } 
            else if (c == 'E') 
            {
                x += 1; 
            } 
            else if (c == 'W') 
            {
                x -= 1; 
            }

            // Step 3: Calculate real Manhattan distance so far
            int realDist = Math.abs(x) + Math.abs(y);
            int maxPossible = realDist + 2 * k;
            int cappedDist = Math.min(maxPossible, i + 1);

            // Step 4: Update the maximum distance seen so far
            ans = Math.max(ans, cappedDist);
        }

        // Step 5: Return the final answer
        return ans;
    }
}