// Solution - Using recursion & DP
// TC/SC -> O(M*N)/O(M*N)
public class Solution {
    // this sequence is important as we are taking right turn in helper function 
    // based on previous index of directions array (newIndex = (index+1)%4)
    int[][] directions = {{1,1},{1,-1},{-1,-1},{-1,1}};  
    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxLength = 0;
        Integer[][][][] dp = new Integer[m][n][4][2];   // dp[row][col][diagonals possible][turned/not turned]

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) {  // as soon as found 1, explore all 4 diagonal directions for 2.
                    for(int dir=0; dir<4; dir++){
                        int currLength = 1 + helper(grid, i, j, dir, 2, 1, dp);  // 1 + because we need to consider current cell having value 1 in length calculation.
                        maxLength = Math.max(maxLength, currLength);
                    }
                }
            }
        }
        return maxLength;
    }

    private int helper(int[][] grid, int i, int j, int directionIndex, int expectedValue, int turnAllowed, Integer[][][][] dp) {

        int newI = i + directions[directionIndex][0];
        int newJ = j + directions[directionIndex][1];

        // validity check for out of bounds and expected value
        if(newI < 0 || newI >= grid.length || newJ < 0 || newJ >= grid[0].length || grid[newI][newJ] != expectedValue){
            return 0;
        }

        // Memoization or result caching
        if(dp[newI][newJ][directionIndex][turnAllowed] != null){
            return dp[newI][newJ][directionIndex][turnAllowed];
        }

        // Take NO turn (travel in same direction hence direction index is not modified)
        int noTurn = 1 + helper(grid, newI, newJ, directionIndex, 2-expectedValue, turnAllowed, dp);

        // take turn if allowed
        int turn = 0;
        if(turnAllowed == 1){
            // if we are taking right turn so next direction index from directions array -> rotated shift by 1 index 
            //(this is why the sequence in directions array matters because it is a rotational movement and CLOCKWIWSE turn specifically)
            turn = 1 + helper(grid, newI, newJ, (directionIndex+1)%4, 2-expectedValue, 0, dp);
        }

        int currMaxValue = Math.max(noTurn, turn);

        dp[newI][newJ][directionIndex][turnAllowed] = currMaxValue;

        return currMaxValue;
    }
}