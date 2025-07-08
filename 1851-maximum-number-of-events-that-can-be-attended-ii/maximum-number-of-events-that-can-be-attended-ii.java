class Solution {
    static class Event {
        int start, end, value;
        Event(int s, int e, int v) {
            start = s;
            end = e;
            value = v;
        }
    }

    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Event[] evs = new Event[n];
        for (int i = 0; i < n; i++) {
            evs[i] = new Event(events[i][0], events[i][1], events[i][2]);
        }

        Arrays.sort(evs, (a, b) -> Integer.compare(a.end, b.end));

        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            int low = 0, high = i - 1, idx = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (evs[mid].end < evs[i].start) {
                    idx = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            pre[i] = idx;
        }

        int[] dp0 = new int[n + 1];
        int[] dp1 = new int[n + 1];

        for (int j = 1; j <= k; j++) {
            dp1[0] = 0;
            for (int i = 1; i <= n; i++) {
                int take = evs[i - 1].value;
                int prev_index = pre[i - 1];
                if (prev_index != -1) {
                    take += dp0[prev_index + 1];
                }
                dp1[i] = Math.max(take, dp1[i - 1]);
            }
            int[] temp = dp0;
            dp0 = dp1;
            dp1 = temp;
        }

        return dp0[n];
    }
}