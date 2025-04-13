class Solution {
    public long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long odd = n/2;
        long even = (n+1)/2;
        
        // Calculate the total number of good digit strings
        // multiplying 5 by even because there could only be 5 even numbers between 0-9
        // multiplying 4 by odd because there could only be 4 prime numbers between 0-9
        return (int)(pow(5,even) * pow(4,odd) % MOD);
    }
    
    public long pow(long x, long n){
        
        // Base case for the recursion
        if(n==0) 
            return 1;
        
        // Recursively calculate x^(n/2)
        long temp = pow(x,n/2);
        
        // If n is even, return (x^(n/2))^2
        if(n%2==0){
            return (temp * temp)% MOD;
        }
        // If n is odd, return (x^(n/2))^2 * x
        else{
            return (x * temp * temp)% MOD;
        }
        
    }
}