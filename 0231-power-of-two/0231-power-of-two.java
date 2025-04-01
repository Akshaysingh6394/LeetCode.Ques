class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        if(n==-2147483648){
            return false;
        }
        if((n & (n-1))!=0){
            return false;
        }
        return true;
        
    }
}