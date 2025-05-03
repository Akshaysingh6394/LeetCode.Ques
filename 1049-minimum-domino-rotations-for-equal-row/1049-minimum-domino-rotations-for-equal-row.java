class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = Integer.MAX_VALUE;
        for (int val = 1; val <= 6; val++) {
            int topSwaps = 0, bottomSwaps = 0;
            boolean valid = true;
            for (int i = 0; i < tops.length; i++) {
                if (tops[i] != val && bottoms[i] != val) {
                    valid = false;
                    break;
                }
                if (tops[i] != val) topSwaps++;
                if (bottoms[i] != val) bottomSwaps++;
            }
            if (valid)
                res = Math.min(res, Math.min(topSwaps, bottomSwaps));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}