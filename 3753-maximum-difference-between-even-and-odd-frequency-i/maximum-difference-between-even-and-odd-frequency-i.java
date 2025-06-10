class Solution 
{
    public int maxDifference(String s) 
    {
        // Step 1: Initialize
        int odd = Integer.MIN_VALUE;
        int even = Integer.MAX_VALUE;
        int[] freq = new int[26];

        // Step 2: Count frequencies
        for(char c : s.toCharArray()) 
        {
            freq[c - 'a']++;
        }

        // Step 3: Analyze frequencies
        for(int n : freq) 
        {
            // skip zero counts
            if(n == 0)
            {
                continue; 
            } 

            if(n % 2 == 0) 
            {
                even = Math.min(even, n);
            } 
            else 
            {
                odd = Math.max(odd, n);
            }
        }

        // Step 4: Return the result
        return odd - even;
    }
}