import java.util.HashSet;
import java.util.Set;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        // This set will store all unique OR values found across all subarrays.
        Set<Integer> resultOrs = new HashSet<>();
        
        // This set stores the distinct ORs of all subarrays ending at the previous position.
        Set<Integer> currentOrs = new HashSet<>();

        for (int x : arr) {
            // `nextOrs` will store the ORs of subarrays ending at the current element `x`.
            Set<Integer> nextOrs = new HashSet<>();
            
            // The subarray of just the element x gives an OR of x.
            nextOrs.add(x);

            // Compute new ORs by extending previous subarrays with the current element x.
            for (int y : currentOrs) {
                nextOrs.add(x | y);
            }

            // Add all newly found ORs to the main result set.
            resultOrs.addAll(nextOrs);
            
            // For the next iteration, the current results become the previous results.
            currentOrs = nextOrs;
        }

        return resultOrs.size();
    }
}