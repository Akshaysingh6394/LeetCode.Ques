
class Solution {
    public long minOperations(int[][] queries) {
        long res = 0;
        for (int[] query: queries) 
            res += minOperations(query);  // handle each query
        return res;
    }

    public static long minOperations(int[] query) {
        long res0 = 0;
        long x = 1;

        // find the first power of 4 that covers l
        while (x < query[0]) {
            res0++;
            x *= 4;
        }

        long res1 = res0; // start operation count from here
        long res = 0;
        long prev = query[0];

        // move through power-of-4 ranges until we cover r
        while (x <= query[1] * 4L) {
            long right = Math.min(x, query[1] + 1);
            res += res1 * (right - prev); // numbers in this interval need res1 ops
            prev = x;
            res1++;
            x *= 4;
        }

        return (res + 1) / 2; // divide by 2 since each operation handles 2 numbers
    }
}