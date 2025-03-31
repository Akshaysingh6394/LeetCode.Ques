import java.util.Arrays;

class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (n == 1) return 0;
        long max = weights[0] + weights[n - 1], min = weights[0] + weights[n - 1];
        int[] sum = new int[n - 1];
        for (int i = 1; i < n; i++)
            sum[i - 1] = weights[i] + weights[i - 1];
        Arrays.sort(sum);
        for (int i = 0; i < k - 1; i++) {
            min += sum[i];
            max += sum[n - i - 2];
        }
        return max - min;
    }
}
