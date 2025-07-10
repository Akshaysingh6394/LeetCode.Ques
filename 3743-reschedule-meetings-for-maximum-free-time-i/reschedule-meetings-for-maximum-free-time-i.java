class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        long[] gaps = new long[n + 1];
        gaps[0] = startTime[0];
        gaps[n] = eventTime - endTime[n - 1];

        for(int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }

        long[] prefix = new long[n + 2];
        for(int i = 1; i <= n + 1; i++) {
            prefix[i] = prefix[i - 1] + gaps[i - 1];
        }

        long maxFreeTime = 0;
        for(int i = k + 1; i <= n + 1; i++) {
            maxFreeTime = Math.max(maxFreeTime, prefix[i] - prefix[i - (k + 1)]);
        }

        return (int)maxFreeTime;
    }
}