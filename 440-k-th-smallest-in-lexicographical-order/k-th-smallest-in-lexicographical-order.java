class Solution {
    public int findKthNumber(int n, int k) {
        long res = 1;
        k = k - 1;

        while (k > 0) {
            int gap = getGap(n, res, res + 1);
            if (gap <= k) {
                res += 1;
                k -= gap;
            } else {
                res *= 10;
                k -= 1;
            }
        }

        return (int) res;
    }

    int getGap(int n, long a, long b) {
        int gap = 0;
        while (a <= n) {
            gap += Math.min(n + 1L, b) - a;
            a *= 10;
            b *= 10;
        }
        return gap;
    }
}