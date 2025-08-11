class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;
		int numOfQueries = queries.length;
		int[] queriesProduct = new int[numOfQueries];
		int[] powersOfTwo = new int[33];
		long powOfTwo = 1;
		int index = 0;
		while(powOfTwo <= Integer.MAX_VALUE) {
			if((powOfTwo & n) == powOfTwo) {
				powersOfTwo[index++] = (int) powOfTwo;
			}
			powOfTwo = powOfTwo << 1;
		}
        
		for(int i = 0; i < numOfQueries; i++) {
			int start = queries[i][0];
			int end = queries[i][1];
			long queryResult = 1;
			while(start <= end) {
				queryResult = queryResult*powersOfTwo[start] % mod;
				start++;
			}
			queriesProduct[i] = (int) queryResult;
		}
		
		return queriesProduct;
    }
}