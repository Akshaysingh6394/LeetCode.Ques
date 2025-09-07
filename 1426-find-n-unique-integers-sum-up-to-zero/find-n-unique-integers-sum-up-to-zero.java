class Solution {
    public int[] sumZero(int n) {
        int[] l = new int[n];
        int index = 0;

        int pairs = n / 2;
        for (int i = 1; i <= pairs; i++) {
            l[index++] = i;
            l[index++] = -i;
        }

        if (n % 2 == 1) {
            l[index++] = 0;
        }

        return l;
    }
}