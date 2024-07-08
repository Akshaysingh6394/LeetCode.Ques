class Solution {
    public int findTheWinner(int n, int k) {
        int winner = 1;
        for(int groupSize = 2; groupSize <= n; groupSize++){
            winner = ((winner + k - 1) % groupSize) + 1;
        }
        return winner;
    }
}