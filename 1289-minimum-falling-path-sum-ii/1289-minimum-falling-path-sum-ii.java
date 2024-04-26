class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        return minFallingPathSum(0,grid).minSum;
    }

    private Triplet minFallingPathSum(int row, int[][] grid){

        if(row == grid.length){
            return new Triplet(0,0,0);
        }

        Triplet nextRowTriplet = minFallingPathSum(row+1, grid); //trying passing row++
        Triplet currentTriplet = new Triplet(Integer.MAX_VALUE, Integer.MAX_VALUE, -1);

        for(int col = 0; col<grid[0].length; col++){
            int sum = grid[row][col] + ((col != nextRowTriplet.minSumIndex) ? nextRowTriplet.minSum : nextRowTriplet.secondMinSum);
            if(sum <= currentTriplet.minSum){
                currentTriplet.secondMinSum = currentTriplet.minSum;
                currentTriplet.minSum = sum;
                currentTriplet.minSumIndex = col;
            }else if(sum < currentTriplet.secondMinSum){
                currentTriplet.secondMinSum = sum;
            }
        }

        return currentTriplet;
    }
}

class Triplet{
    int minSum;
    int secondMinSum;
    int minSumIndex;
    
    Triplet(int minSum, int secondMinSum, int minSumIndex){
        this.minSum = minSum;
        this.secondMinSum = secondMinSum;
        this.minSumIndex = minSumIndex;
    }
}