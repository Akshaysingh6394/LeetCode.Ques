class Solution 
{
    public String[] divideString(String s, int k, char fill) 
    {
        // Step 1: Initialize result list
        ArrayList<String> list = new ArrayList<>();

        // Step 2: Loop through the string in steps of k
        for(int i = 0; i < s.length(); i += k)
        {
            StringBuilder sb = new StringBuilder();

            // Step 3: Add characters one by one to the chunk
            int j = 0;
            while(j < k && j + i < s.length())
            {
                sb.append(s.charAt(j + i));
                j++;
            }

            // Step 4: Fill with 'fill' character if needed
            while(sb.length() < k)
            {
                sb.append(fill);
            }

            // Step 5: Add to the result list
            list.add(sb.toString());
        }

        // Step 6: Convert to array and return
        return list.toArray(new String[0]);
    }
}