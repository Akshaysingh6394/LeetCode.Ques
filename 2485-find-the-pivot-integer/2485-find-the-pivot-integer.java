class Solution {
    public int pivotInteger(int n) {
        int totalSum = 0;
        
        // Calculate the total sum of integers from 1 to n
        for (int i = 1; i <= n; i++) {
            totalSum += i;
        }
        
        // Iterate through each integer and check if it is a pivot integer
        for (int x = 1; x <= n; x++) {
            int leftSum = 0;
            int rightSum = 0;
            
            // Calculate the sum of elements before x
            for (int i = 1; i < x; i++) {
                leftSum += i;
            }
            
            // Calculate the sum of elements after x
            for (int i = x + 1; i <= n; i++) {
                rightSum += i;
            }
            
            // Check if leftSum equals rightSum
            if (leftSum == rightSum) {
                return x;
            }
        }
        
        // If no pivot integer is found, return -1
        return -1;
    }
}

