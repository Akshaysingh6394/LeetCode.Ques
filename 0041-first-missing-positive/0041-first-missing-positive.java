class Solution {
    public int firstMissingPositive(int[] nums) {
        //Approach:
        // 1. Mark the elements which are out of range
        // 2. Map the element with index : arr[element-1]=0-arr[element-1]
        // 3. Check which number is not negative i.e. Positive, return its index+1
            int n=nums.length;
            boolean one = false;
            // 1. Mark the elements which are out of range
            for(int i=0;i<n;i++)
            {
                if(nums[i]==1)
                    one = true;
                if(nums[i]<1 || nums[i]>n)
                    nums[i]=1;
            }
            if(one==false) return 1;
            // 2. Map the element with index : arr[element-1]=0-arr[element-1]
            for(int i=0;i<n;i++)
            {
                int idx = Math.abs(nums[i]); // making the value +ve by abs() so that idx will be a +ve one
                nums[idx-1] = -Math.abs(nums[idx-1]); //making the element negative 
            }
            // 3. Check which number is not negative i.e. Positive, return its index+1
            for(int i=0;i<n;i++)
            {
                if(nums[i]>0)
                    return i+1;
            }
        return n+1;
    }
}