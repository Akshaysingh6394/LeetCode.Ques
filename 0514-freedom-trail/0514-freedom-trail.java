class Solution 
{
    public int method(int i1, int i2, String ring, String key, int m, int n, int dp[][])
    {
        if(i2==n)
          return 0;
        if(dp[i1][i2]!=-1)
         return dp[i1][i2];
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<m;i++)
        {
            if(ring.charAt(i)==key.charAt(i2))
            {
                int count = Math.min(Math.abs(i1-i), m - Math.abs(i1-i));
                ans = Math.min(ans, count + method(i,i2+1,ring, key, m,n,dp));
            }
        }
        return dp[i1][i2]=ans;
    }
    public int findRotateSteps(String ring, String key) 
    {
        int m = ring.length();
        int n = key.length();
        int dp[][]=new int[m][n];
        for(int []row:dp)
          Arrays.fill(row, -1);
        return n+method(0,0,ring, key, m,n,dp);
    }
}

