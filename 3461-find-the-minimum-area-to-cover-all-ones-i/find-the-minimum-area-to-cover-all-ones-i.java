class Solution {
    public int minimumArea(int[][] grid) {
        int startRow = Integer.MAX_VALUE;
        int endRow = Integer.MIN_VALUE;
        int startCol = Integer.MAX_VALUE;
        int endCol = Integer.MIN_VALUE;
        for(int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1) {
                    startRow = Math.min(startRow, row);
                    startCol = Math.min(startCol, col);
                    endRow = Math.max(endRow, row);
                    endCol = Math.max(endCol, col);
                }
            }
        }
        return (endRow - startRow + 1)*(endCol - startCol + 1);
    }
}