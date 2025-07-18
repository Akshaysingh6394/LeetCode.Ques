class Solution {
    public long minimumDifference(int[] nums) {
        
        long[] leftMins = new long[nums.length];
        long[] rightMaxs = new long[nums.length];

        int n = nums.length;
        int oneThird = n/3;
        PriorityQueue<Integer> pqMin = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
        PriorityQueue<Integer> pqMax = new PriorityQueue<>();
        long minSum = 0;
        long maxSum = 0;
        long ret = Long.MAX_VALUE;


        for (int i = 0; i < oneThird; i++) {
            pqMin.offer(nums[i]);
            minSum += nums[i];
        }
        leftMins[oneThird-1] = minSum;

        for (int i = oneThird; i < n-oneThird; i++) {
            int x = nums[i];
            if (x < pqMin.peek()) {
                minSum += x-pqMin.poll();
                pqMin.offer(x);
            }

            leftMins[i] = minSum;
        }
        
        for (int i = n-1; i >= n-oneThird; i--) {
            pqMax.offer(nums[i]);
            maxSum += nums[i];
        }
        rightMaxs[n-oneThird] = maxSum;

        for (int i = n-oneThird-1; i >= oneThird-1; i--) {
            int x = nums[i];
            if (x > pqMax.peek()) {
                maxSum += x-pqMax.poll();
                pqMax.offer(x);
            }

            rightMaxs[i] = maxSum;
        }

        for (int i = oneThird-1; i < n-oneThird; i++) {
            ret = Math.min(ret, leftMins[i]-rightMaxs[i+1]);
        }

        return ret;
    }
}