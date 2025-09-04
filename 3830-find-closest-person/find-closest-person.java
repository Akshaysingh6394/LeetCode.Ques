class Solution {
    public int findClosest(int x, int y, int z) {
        int first = Math.abs(z - x);
        int second = Math.abs(z - y);
        if (first == second) return 0;
        return first < second ? 1 : 2;
    }
}