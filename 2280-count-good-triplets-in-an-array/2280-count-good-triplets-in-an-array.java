class Solution {
    class BIT {
        long[] tree;
        int n;

        BIT(int size) {
            n = size;
            tree = new long[n + 2];
        }

        void update(int i, long val) {
            for (++i; i <= n; i += i & -i)
                tree[i] += val;
        }

        long query(int i) {
            long res = 0;
            for (++i; i > 0; i -= i & -i)
                res += tree[i];
            return res;
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++)
            pos[nums2[i]] = i;
        for (int i = 0; i < n; i++)
            nums1[i] = pos[nums1[i]];

        BIT bit1 = new BIT(n);
        BIT bit2 = new BIT(n);
        long ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            int x = nums1[i];
            long val = bit1.query(n - 1) - bit1.query(x);
            long trip = bit2.query(n - 1) - bit2.query(x);
            ans += trip;
            bit2.update(x, val);
            bit1.update(x, 1);
        }

        return ans;
    }
}